package com.example.bezbednost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bezbednost.service.CommunicationService;


@RestController
@RequestMapping(value="/Communication")
public class CommunicationController {

	@Autowired
	CommunicationService service;
	
	@PostMapping(value="/create/{id1}/{id2}")
	public void create(@PathVariable long id1, @PathVariable long id2) {
		
		service.create(id1, id2);
	}
}
