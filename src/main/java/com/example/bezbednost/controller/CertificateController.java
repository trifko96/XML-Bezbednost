package com.example.bezbednost.controller;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
					KeyPair keyPairIssuer = generateKeyPair();
					X500NameBuilder builder1 = new X500NameBuilder(BCStyle.INSTANCE);
				    builder1.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    IssuerData issuerData = new IssuerData(keyPairIssuer.getPrivate(), builder1.build());
						
					//Generisanje sertifikata
				    CertificateGenerator cg = new CertificateGenerator();
				    X509Certificate cert = cg.generateCertificate(subjectData, issuerData);
				    
				    cert.verify(keyPairIssuer.getPublic());
				    
				    

				    CertificateDB cDB = new CertificateDB(c, null);
				    cDB.setAuthority(true);
				    cDB.setRoot(true);
				    
				    cDB = service.save(cDB);
				    cDB.setNadSertifikatId(cDB.getId());
				    cDB = service.save(cDB);
				    keyStore.write(cDB.getId().toString(), keyPairIssuer.getPrivate(), "123".toCharArray(), cert);
				    keyStore.saveKeyStore("KeyStore", "111".toCharArray());
				    
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
				    
				    // OVO VEROVATNO NE TREBA OVAKO, TREBA KORISTITI PARENT-ov PRIVATNI KLJUC
					KeyPair keyPairIssuer = generateKeyPair();
					CertificateDB cDB = service.findOne(cDTO.getNadSertifikatId());
					X500NameBuilder builder1 = new X500NameBuilder(BCStyle.INSTANCE);
				    builder1.addRDN(BCStyle.O, cDB.getNazivOrganizacije());
				    IssuerData issuerData = new IssuerData(keyPairIssuer.getPrivate(), builder1.build());
						
					//Generisanje sertifikata
				    CertificateGenerator cg = new CertificateGenerator();
				    X509Certificate cert = cg.generateCertificate(subjectData, issuerData);
				    
				    cert.verify(keyPairIssuer.getPublic());
				    
				    
				    cDB = new CertificateDB(c, cDB.getNadSertifikatId());
				    cDB.setAuthority(cDTO.isAuthority());
				    cDB.setRoot(false);
				    
				    cDB = service.save(cDB);
				    keyStore.write(cDB.getId().toString(), keyPairIssuer.getPrivate(), "123".toCharArray(), cert);

				    keyStore.saveKeyStore("KeyStore", "111".toCharArray());
				    
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
