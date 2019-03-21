package com.example.bezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bezbednost.model.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
	
	Certificate findOneById(long id);
	
}
