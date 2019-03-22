package com.example.bezbednost.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bezbednost.model.Communication;
import com.example.bezbednost.repository.CommunicationRepository;


public class CommunicationService {

	@Autowired
	CommunicationRepository repository;
	
	public void create(long id1, long id2) {
		Communication c = new Communication(id1, id2);
		repository.save(c);
	}
	
	public Communication vratiPoId(long id) {
		return repository.findOneById(id);
	}
}
