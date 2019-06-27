package com.example.bezbednost.controller;

import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bezbednost.dbModel.CertificateDB;
import com.example.bezbednost.keystore.KeyStoreReader;
import com.example.bezbednost.keystore.KeyStoreWriter;
import com.example.bezbednost.service.CertificateDBService;
import com.example.bezbednost.service.CommunicationService;


@RestController
@RequestMapping(value="/Communication")
public class CommunicationController {

	@Autowired
	CommunicationService service;
	
	@Autowired
	CertificateDBService serviceDB;
	
	@PostMapping(value="/create/{id1}/{id2}")
	public void create(@PathVariable long id1, @PathVariable long id2) {
		
		service.create(id1, id2);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="enable/{id1}/{id2}")
	public ResponseEntity<String> enableCommunication(@PathVariable long id1, @PathVariable long id2){
		
		if(id1 == id2) {
			return new ResponseEntity<>("ID's are identical", HttpStatus.BAD_REQUEST);
		}
		
		CertificateDB cDB1 = serviceDB.findOne(id1);
		CertificateDB cDB2 = serviceDB.findOne(id2);
		
		if(cDB1 == null || cDB2 == null) {
			return new ResponseEntity<>("Certirficate was not found", HttpStatus.BAD_REQUEST);
		}
		
		if(cDB1.isRevoked() || cDB2.isRevoked()) {
			return new ResponseEntity<>("Some certificates are revoked", HttpStatus.BAD_REQUEST);
		}
		
		if(cDB1.getDatumIsteka().before(new Date()) || cDB2.getDatumIsteka().before(new Date())) {
			return new ResponseEntity<>("Some certificates are out of date", HttpStatus.BAD_REQUEST);
		}
		
		KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
		KeyStoreReader keyStoreReader = new KeyStoreReader();
		
		String nazivKeyStora1 = cDB1.getNazivOrganizacije().concat(Long.toString(cDB1.getId())).concat("Communication");
		String nazivKeyStora2 = cDB2.getNazivOrganizacije().concat(Long.toString(cDB2.getId()));
					
		
		try {
			// Ucitavamo sertifikat iz keyStora koji zelimo da smestimo u novi keyStore
			Certificate c2 = keyStoreReader.readCertificate(nazivKeyStora2.concat(".jks"), "111", cDB2.getId().toString());
			
			// Ucitavamo privatni kljuc sertifikata koji zelimo da smestimo u novi keyStore
			PrivateKey privatniKljuc2 = keyStoreReader.readPrivateKey(nazivKeyStora2.concat(".jks"), "111", cDB2.getId().toString(), "111");
			
			// Pretrazujemo da li keyStore vec postoji
			keyStoreWriter.loadKeyStore(nazivKeyStora1.concat(".jks"), "111".toCharArray());
			// Postavljamo alias
			keyStoreWriter.write(cDB2.getId().toString(), privatniKljuc2, "111".toCharArray(), c2);
			// Cuvamo u novi keyStore
			keyStoreWriter.saveKeyStore(nazivKeyStora1.concat(".jks"), "111".toCharArray());
			
			service.create(id1, id2);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return new ResponseEntity<>("",HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value="check/{id1}/{id2}")
	public ResponseEntity<String> checkCommunication(@PathVariable long id1, @PathVariable long id2){
		
		if(id1 == id2) {
			return new ResponseEntity<>("ID's are identical", HttpStatus.BAD_REQUEST);
		}
		
		CertificateDB cDB1 = serviceDB.findOne(id1);
		CertificateDB cDB2 = serviceDB.findOne(id2);
		
		if(cDB1 == null || cDB2 == null) {
			return new ResponseEntity<>("Certirficate was not found", HttpStatus.BAD_REQUEST);
		}
		
		KeyStoreReader keyStoreReader = new KeyStoreReader();
		
		String nazivKeyStora1 = cDB1.getNazivOrganizacije().concat(Long.toString(cDB1.getId())).concat("Communication");

		Certificate c = keyStoreReader.readCertificate(nazivKeyStora1.concat(".jks"), "111", cDB2.getId().toString());
		
		if(c == null) {
			return new ResponseEntity<>("Communication does not exist", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Communication do exist", HttpStatus.OK);
	}

}
