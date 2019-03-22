package com.example.bezbednost.controller;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bezbednost.certificates.CertificateGenerator;
import com.example.bezbednost.data.IssuerData;
import com.example.bezbednost.data.SubjectData;
import com.example.bezbednost.dbModel.CertificateDB;
import com.example.bezbednost.dto.CertificateDTO;
import com.example.bezbednost.keystore.KeyStoreReader;
import com.example.bezbednost.keystore.KeyStoreWriter;
import com.example.bezbednost.model.CertificatePerson;
import com.example.bezbednost.model.CertificateRoot;
import com.example.bezbednost.service.CertificateDBService;

@RestController
@RequestMapping(value="/Certificate")
public class CertificateController {
	
	@Autowired
	CertificateDBService service;
	
	static KeyStoreWriter keyStore = new KeyStoreWriter();
	
	@PostMapping(value="/create")
	public ResponseEntity<CertificateDTO> createCertificate (@RequestBody CertificateDTO cDTO){
		
		
		
		switch(cDTO.getTip()){
			case ROOT:
				try {
					CertificateRoot c = new CertificateRoot(cDTO);
					//CertificateExample klasa
						//generateSubjectData
							// generisemo javni i privatni kljuc subjekta kojem izdajemo sertifikat
							// posto je u pitanju root, koji potpisuje sam sebe, taj privatni ce se koristiti
							// i kod issuer-a kako bi sertifikat bio samopotpisan
					KeyPair keyPairSubject = generateKeyPair(); 
					Date startDate = c.getDatumIzdavanja();
					Date endDate = c.getDatumIsteka();
							//Serijski broj sertifikata...kako generisati??
					String sn = Long.toString(System.currentTimeMillis());
						//Podaci o vlasniku
					X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);			
				    builder.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    SubjectData subjectData = new SubjectData(keyPairSubject.getPublic(), builder.build(), sn, startDate, endDate);
					
				    	//generateIssuerData
					X500NameBuilder builder1 = new X500NameBuilder(BCStyle.INSTANCE);
				    builder1.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    IssuerData issuerData = new IssuerData(keyPairSubject.getPrivate(), builder1.build());
						
						//Generisanje sertifikata
				    CertificateGenerator cg = new CertificateGenerator();
				    X509Certificate cert = cg.generateCertificate(subjectData, issuerData);
				    cert.verify(keyPairSubject.getPublic());
				    
				    CertificateDB cDB = new CertificateDB(c, null);
				    cDB.setAuthority(true);
				    cDB.setRoot(true);
				    cDB.setPublicKey(keyPairSubject.getPublic().getEncoded());
				    cDB = service.save(cDB);
				    cDB.setNadSertifikatId(cDB.getId());
				    cDB = service.save(cDB);
				    keyStore.write(cDB.getId().toString(), keyPairSubject.getPrivate(), "123".toCharArray(), cert);
				    		//Sacuvati u KeyStore london, hong kong ili boston?
				    keyStore.saveKeyStore("KeyStore.ks", "111".toCharArray());
				    
				}catch(CertificateException e) {
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchProviderException e) {
					e.printStackTrace();
				} catch (SignatureException e) {
					e.printStackTrace();
				}
				
				break;
				
			case PERSON:
				try {
					CertificatePerson c = new CertificatePerson(cDTO);					
					//CertificateExample klasa
						//generateSubjectData
					KeyPair keyPairSubject = generateKeyPair();
					Date startDate = c.getDatumIzdavanja();
					Date endDate = c.getDatumIsteka();
							//Serijski broj sertifikata...kako generisati??
					String sn = Long.toString(System.currentTimeMillis());
						//Podaci o vlasniku
					X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);			
				    builder.addRDN(BCStyle.GIVENNAME, c.getIme());
				    builder.addRDN(BCStyle.SURNAME, c.getPrezime());
				    builder.addRDN(BCStyle.COUNTRY_OF_RESIDENCE, c.getDrzava());
				    builder.addRDN(BCStyle.EmailAddress, c.getEmail());
				    builder.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    SubjectData subjectData = new SubjectData(keyPairSubject.getPublic(), builder.build(), sn, startDate, endDate);
					
				    	//generateIssuerData
				    KeyStoreReader keyStoreReader = new KeyStoreReader();
					CertificateDB cDB = service.findOne(cDTO.getNadSertifikatId());
				    	// Izvlacimo privatni kljuc nadsertifikata kojim cemo potpisati trazeni sertifikat
				    IssuerData issuerData = keyStoreReader.readIssuerFromStore("KeyStore.ks", Long.toString(cDB.getId()), "111".toCharArray(),  "123".toCharArray());
						//Generisanje sertifikata
				    CertificateGenerator cg = new CertificateGenerator();
				    X509Certificate cert = cg.generateCertificate(subjectData, issuerData);
				    
				    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
				    X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(cDB.getPublicKey());
				    PublicKey pk = keyFactory.generatePublic(publicKeySpec);
				    
				    cert.verify(pk);
				    cDB = new CertificateDB(c, cDB.getNadSertifikatId());
				    cDB.setAuthority(cDTO.isAuthority());
				    cDB.setRoot(false);
				    
				    cDB = service.save(cDB);
				    keyStore.write(cDB.getId().toString(), issuerData.getPrivateKey(), "123".toCharArray(), cert);

				    keyStore.saveKeyStore("KeyStore.ks", "111".toCharArray());
				    
				}catch(CertificateException e) {
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchProviderException e) {
					e.printStackTrace();
				} catch (SignatureException e) {
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					e.printStackTrace();
				}
				
				break;
			case APLICATION:
				
			case ORGANIZATION:
				
			case EQUIPMENT:
				
			
		}
		
		return null;
	}
	
	private KeyPair generateKeyPair() {
        try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); 
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			keyGen.initialize(2048, random);
			return keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
        return null;
	}
}
