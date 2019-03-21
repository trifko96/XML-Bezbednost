package com.example.bezbednost.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bezbednost.model.User;
import com.example.bezbednost.service.UserService;
import com.example.bezbednost.dto.UserDTO;

@RestController
@RequestMapping(value = "/User")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable long id){
		User user = service.findOne(id);
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> services = service.findAll();
		
		List<UserDTO> servicesDTO = new ArrayList<UserDTO>();
		
		for(User u : services) {
			servicesDTO.add(new UserDTO(u));
		}
		
		return new ResponseEntity<>(servicesDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		User user = new User(userDTO);
		user = service.save(user);
		
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable long id){
		User user = service.findOne(id);
		service.delete(user);
	}
	
}
