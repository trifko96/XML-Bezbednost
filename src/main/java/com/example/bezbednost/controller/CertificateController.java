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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bezbednost.certificates.CertificateGenerator;
import com.example.bezbednost.data.IssuerData;
import com.example.bezbednost.data.SubjectData;
import com.example.bezbednost.dbModel.CertificateDB;
import com.example.bezbednost.dto.CertificateDTO;
import com.example.bezbednost.dto.RevokedDTO;
import com.example.bezbednost.keystore.KeyStoreReader;
import com.example.bezbednost.keystore.KeyStoreWriter;
import com.example.bezbednost.model.CertificateAplication;
import com.example.bezbednost.model.CertificateEquipment;
import com.example.bezbednost.model.CertificateOrganization;
import com.example.bezbednost.model.CertificatePerson;
import com.example.bezbednost.model.CertificateRoot;
import com.example.bezbednost.service.CertificateDBService;

@RestController
@RequestMapping(value="/Certificate")
public class CertificateController {
	
	@Autowired
	CertificateDBService service;
	
	static KeyStoreWriter keyStore = new KeyStoreWriter();
	
	@GetMapping(value="isRevoked/{id}")
	public ResponseEntity<RevokedDTO> getAnswer(@PathVariable long id){
		CertificateDB cDB = service.findOne(id);
		
		if(cDB == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		RevokedDTO rDTO = new RevokedDTO(cDB);
		
		if(rDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<RevokedDTO>(rDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CertificateDTO> getCertificate(@PathVariable long id){
		CertificateDB cDB = service.findOne(id);
		
		if(cDB == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		CertificateDTO cDTO = createValidDTO(cDB);
		
		if(cDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<CertificateDTO>(cDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<CertificateDTO>> findAll(){
		List<CertificateDB> certificates = service.findAll();
		
		List<CertificateDTO> certificatesDTO = new ArrayList<CertificateDTO>();
		
		for(CertificateDB cDB : certificates) {
			
			CertificateDTO cDTO = createValidDTO(cDB);
			
			if(cDTO != null) {
				certificatesDTO.add(cDTO);
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
		}
		return new ResponseEntity<>(certificatesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/authority")
	public ResponseEntity<List<CertificateDTO>> findAuthorities(){
		List<CertificateDB> certificates = service.findAll();
		
		List<CertificateDTO> certificatesDTO = new ArrayList<CertificateDTO>();
		
		for(CertificateDB cDB : certificates) {
			if(cDB.isAuthority() && !cDB.isRevoked()) {	
				CertificateDTO cDTO = createValidDTO(cDB);
				
				if(cDTO != null) {
					certificatesDTO.add(cDTO);
				}
				else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}	
			}
		}
		return new ResponseEntity<>(certificatesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/unrevoked")
	public ResponseEntity<List<CertificateDTO>> findUnrevoked(){
		List<CertificateDB> certificates = service.findAll();
		
		List<CertificateDTO> certificatesDTO = new ArrayList<CertificateDTO>();
		
		for(CertificateDB cDB : certificates) {
			if(!cDB.isRevoked()) {
				CertificateDTO cDTO = createValidDTO(cDB);
				
				if(cDTO != null) {
					certificatesDTO.add(cDTO);
				}
				else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}	
			}
		}
		return new ResponseEntity<>(certificatesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/revoked")
	public ResponseEntity<List<CertificateDTO>> findRevoked(){
		List<CertificateDB> certificates = service.findAll();
		
		List<CertificateDTO> certificatesDTO = new ArrayList<CertificateDTO>();
		
		for(CertificateDB cDB : certificates) {
			if(cDB.isRevoked()) {
				CertificateDTO cDTO = createValidDTO(cDB);
				
				if(cDTO != null) {
					certificatesDTO.add(cDTO);
				}
				else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}	
			}
		}
		return new ResponseEntity<>(certificatesDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/revoke/{id}")
	public ResponseEntity<CertificateDTO> revoke(@PathVariable long id){
		CertificateDB cDB = service.findOne(id);
		
		if(cDB == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		cDB.setRevoked(true);
		service.save(cDB);
		
		return new ResponseEntity<CertificateDTO>(HttpStatus.OK);
	}
	
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
					//System.out.println("\nPublic person: " + keyPairSubject.getPublic());
					//System.out.println("\nPrivate person: " + keyPairSubject.getPrivate());
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
				    if(service.findOne(cDTO.getNadSertifikatId()) == null) {
				    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				    }
					CertificateDB cDB = service.findOne(cDTO.getNadSertifikatId());
					if(!cDB.isAuthority() || cDB.isRevoked()) {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
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
				    cDB.setPublicKey(keyPairSubject.getPublic().getEncoded());
				    
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
			case APPLICATION:
				try {
					CertificateAplication c = new CertificateAplication(cDTO);					
					//CertificateExample klasa
					//generateSubjectData
					KeyPair keyPairSubject = generateKeyPair();
					Date startDate = c.getDatumIzdavanja();
					Date endDate = c.getDatumIsteka();
					//Serijski broj sertifikata...kako generisati??
					String sn = Long.toString(System.currentTimeMillis());
					//Podaci o vlasniku
					X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);			
				    builder.addRDN(BCStyle.NAME, c.getNazivAplikacije());
				    builder.addRDN(BCStyle.CN, c.getVerzija());
				    builder.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    SubjectData subjectData = new SubjectData(keyPairSubject.getPublic(), builder.build(), sn, startDate, endDate);
					
				    //generateIssuerData
				    KeyStoreReader keyStoreReader = new KeyStoreReader();
				    if(service.findOne(cDTO.getNadSertifikatId()) == null) {
				    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				    }
					CertificateDB cDB = service.findOne(cDTO.getNadSertifikatId());
					if(!cDB.isAuthority() || cDB.isRevoked()) {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
				    // Izvlacimo privatni kljuc nadsertifikata kojim cemo potpisati trazeni sertifikat
				    IssuerData issuerData = keyStoreReader.readIssuerFromStore("KeyStore.ks", Long.toString(cDB.getId()), "111".toCharArray(),  "123".toCharArray());
				    //System.out.println("\n\n**** " + cDB.getId());
					//Generisanje sertifikata
				    CertificateGenerator cg = new CertificateGenerator();
				    X509Certificate cert = cg.generateCertificate(subjectData, issuerData);
				    
				    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
				    X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(cDB.getPublicKey());
				    PublicKey pk = keyFactory.generatePublic(publicKeySpec);
				    //System.out.println("\nPublic person from app: " + pk);
				    //System.out.println("\nPrivate person from app: " + issuerData.getPrivateKey());
				    cert.verify(pk);
				    cDB = new CertificateDB(c, cDB.getNadSertifikatId());
				    cDB.setAuthority(cDTO.isAuthority());
				    cDB.setRoot(false);
				    cDB.setPublicKey(keyPairSubject.getPublic().getEncoded());
				    
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
				
			case ORGANIZATION:
				try {
					CertificateOrganization c = new CertificateOrganization(cDTO);					
					//CertificateExample klasa
					//generateSubjectData
					KeyPair keyPairSubject = generateKeyPair();
					Date startDate = c.getDatumIzdavanja();
					Date endDate = c.getDatumIsteka();
					//Serijski broj sertifikata...kako generisati??
					String sn = Long.toString(System.currentTimeMillis());
					//Podaci o vlasniku
					X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
				    builder.addRDN(BCStyle.POSTAL_CODE, c.getPtt());
				    builder.addRDN(BCStyle.COUNTRY_OF_RESIDENCE, c.getDrzava());
				    builder.addRDN(BCStyle.POSTAL_ADDRESS, c.getAdresa());
				    builder.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    SubjectData subjectData = new SubjectData(keyPairSubject.getPublic(), builder.build(), sn, startDate, endDate);
					
				    //generateIssuerData
				    KeyStoreReader keyStoreReader = new KeyStoreReader();
				    if(service.findOne(cDTO.getNadSertifikatId()) == null) {
				    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				    }
					CertificateDB cDB = service.findOne(cDTO.getNadSertifikatId());
					if(!cDB.isAuthority() || cDB.isRevoked()) {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
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
				    cDB.setPublicKey(keyPairSubject.getPublic().getEncoded());
				    
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
			case EQUIPMENT:
				try {
					CertificateEquipment c = new CertificateEquipment(cDTO);					
					//CertificateExample klasa
					//generateSubjectData
					KeyPair keyPairSubject = generateKeyPair();
					Date startDate = c.getDatumIzdavanja();
					Date endDate = c.getDatumIsteka();
					//Serijski broj sertifikata...kako generisati??
					String sn = Long.toString(System.currentTimeMillis());
					//Podaci o vlasniku
					X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);	
				    builder.addRDN(BCStyle.SN, c.getMac());
				    builder.addRDN(BCStyle.NAME, c.getNazivOpreme());
				    builder.addRDN(BCStyle.COUNTRY_OF_RESIDENCE, c.getDrzava());
				    builder.addRDN(BCStyle.SERIALNUMBER, c.getIdOpreme());
				    builder.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    SubjectData subjectData = new SubjectData(keyPairSubject.getPublic(), builder.build(), sn, startDate, endDate);
					
				    //generateIssuerData
				    KeyStoreReader keyStoreReader = new KeyStoreReader();
				    if(service.findOne(cDTO.getNadSertifikatId()) == null) {
				    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				    }
					CertificateDB cDB = service.findOne(cDTO.getNadSertifikatId());
					if(!cDB.isAuthority() || cDB.isRevoked()) {
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
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
				    cDB.setPublicKey(keyPairSubject.getPublic().getEncoded());
				    
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
			default: 
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
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
	
	private CertificateDTO createValidDTO(CertificateDB cDB) {
		CertificateDTO cDTO = new CertificateDTO(cDB);
		KeyStoreReader keyStoreReader = new KeyStoreReader();
	    IssuerData issuerData = keyStoreReader.readIssuerFromStore("KeyStore.ks", Long.toString(cDB.getId()), "111".toCharArray(),  "123".toCharArray());
	    ASN1ObjectIdentifier[] identifiers = issuerData.getX500name().getAttributeTypes();
	    
	    switch (cDTO.getTip()) {
		case ROOT:
			for(ASN1ObjectIdentifier identifier: identifiers) {
				RDN[] rdnS = issuerData.getX500name().getRDNs(identifier);
				for(RDN rdn: rdnS) {
					
					if(identifier.intern().equals(BCStyle.O)) {
						cDTO.setNazivOrganizacije(rdn.getFirst().getValue().toString());
					}
				}
			}
			break;
		case PERSON:
			for(ASN1ObjectIdentifier identifier: identifiers) {
				RDN[] rdnS = issuerData.getX500name().getRDNs(identifier);
				for(RDN rdn: rdnS) {
					if(identifier.intern().equals(BCStyle.GIVENNAME)) {
						cDTO.setIme(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.SURNAME)) {
						cDTO.setPrezime(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.COUNTRY_OF_RESIDENCE)) {
						cDTO.setDrzava(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.EmailAddress)) {
						cDTO.setEmail(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.O)) {
						cDTO.setNazivOrganizacije(rdn.getFirst().getValue().toString());
					}
				}
			}
			break;
		case APPLICATION:
			for(ASN1ObjectIdentifier identifier: identifiers) {
				RDN[] rdnS = issuerData.getX500name().getRDNs(identifier);
				for(RDN rdn: rdnS) {
					
					if(identifier.intern().equals(BCStyle.NAME)) {
						cDTO.setNazivAplikacije(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.CN)) {
						cDTO.setVerzija(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.O)) {
						cDTO.setNazivOrganizacije(rdn.getFirst().getValue().toString());
					}
				}
			}
			break;
		case ORGANIZATION:
			for(ASN1ObjectIdentifier identifier: identifiers) {
				RDN[] rdnS = issuerData.getX500name().getRDNs(identifier);
				for(RDN rdn: rdnS) {
					
					if(identifier.intern().equals(BCStyle.POSTAL_CODE)) {
						cDTO.setPtt(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.COUNTRY_OF_RESIDENCE)) {
						cDTO.setDrzava(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.POSTAL_ADDRESS)) {
						cDTO.setAdresa(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.O)) {
						cDTO.setNazivOrganizacije(rdn.getFirst().getValue().toString());
					}
				}
			}
			break;
		case EQUIPMENT:
			for(ASN1ObjectIdentifier identifier: identifiers) {
				RDN[] rdnS = issuerData.getX500name().getRDNs(identifier);
				for(RDN rdn: rdnS) {
					
					if(identifier.intern().equals(BCStyle.SN)) {
						cDTO.setMac(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.NAME)) {
						cDTO.setNazivOpreme(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.COUNTRY_OF_RESIDENCE)) {
						cDTO.setDrzava(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.SERIALNUMBER)) {
						cDTO.setIdOpreme(rdn.getFirst().getValue().toString());
					}
					if(identifier.intern().equals(BCStyle.O)) {
						cDTO.setNazivOrganizacije(rdn.getFirst().getValue().toString());
					}
				}
			}
			break;
		default:
			return null;
    }
		return cDTO;
	}
}
