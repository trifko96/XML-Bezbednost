package com.example.bezbednost.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bezbednost.dbModel.CertificateDB;
import com.example.bezbednost.repository.CertificateDBRepository;

@Service
public class CertificateDBService {
	
	@Autowired
	CertificateDBRepository repository;
	
	public CertificateDB save(CertificateDB c) {
		return repository.save(c);
	}
	
	public CertificateDB findOne(Long id) {
		return repository.findOneById(id);
	}
}
