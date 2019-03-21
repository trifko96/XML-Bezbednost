package com.example.bezbednost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bezbednost.model.Certificate;
import com.example.bezbednost.repository.CertificateRepository;

@Component
public class CertificateService {
	@Autowired
	CertificateRepository repository;
	
	public Certificate findOne(long id) {
		return repository.findOneById(id);
	}
	
	public List<Certificate> findAll(){
		return repository.findAll();
	}
	
	public void revoke(Certificate c) {
		c.setRevoked(true);
		repository.save(c);
	}
}
