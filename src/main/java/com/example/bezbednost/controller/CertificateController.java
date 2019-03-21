package com.example.bezbednost.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bezbednost.dto.CertificateDTO;
import com.example.bezbednost.model.Certificate;
import com.example.bezbednost.service.CertificateService;

@RestController
@RequestMapping(value = "/Certificate")
public class CertificateController {
	
	@Autowired
	CertificateService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CertificateDTO> getCertificate(@PathVariable long id){
		Certificate c = service.findOne(id);
		
		if(c == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CertificateDTO>(new CertificateDTO(c), HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<CertificateDTO>> findAll(){
		
		List<Certificate> services = service.findAll();
		
		List<CertificateDTO> servicesDTO = new ArrayList<CertificateDTO>();
		
		for(Certificate c : services) {
			servicesDTO.add(new CertificateDTO(c));
		}
		
		return new ResponseEntity<>(servicesDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/{id}")
	public void revoke(@PathVariable long id){
		Certificate c = service.findOne(id);
		service.revoke(c);
	}
	
}
