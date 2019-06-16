package com.eureka.auth.eurekaauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.auth.eurekaauth.dto.UserDTO;
import com.eureka.auth.eurekaauth.service.AdminService;
import com.eureka.model.eurekamodel.model.User;
import com.eureka.model.eurekamodel.model.UserRole;
import com.eureka.model.eurekamodel.model.UserStatus;

@RestController
@RequestMapping(value = "/Admin")
public class AdminController {

	@Autowired
	AdminService service;
	
	@PostMapping(value = "/addNewAgent", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> addNewAgent(@RequestBody User user){
		//uraditi proveru za jedinstvenost bussinesID
		User retVal = service.addNewAgent(user);
		if(retVal != null) {
			return new ResponseEntity<>(service.getAgents(), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/activateUser", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> activateUser(@RequestBody User user){
		User u = service.getUserById(user.getUserId());
		if(u.getStatus() != UserStatus.BLOCKED || u.getRole() != UserRole.USER)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			service.activateUser(u);
			return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/blockUser", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> blockUser(@RequestBody User user){
		User u = service.getUserById(user.getUserId());
		if(u.getStatus() != UserStatus.ACTIVATED || u.getRole() != UserRole.USER)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			service.blockUser(u);
			return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/removeUser", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> removeUser(@RequestBody User user){
		User u = service.getUserById(user.getUserId());
		if(u.getRole() != UserRole.USER)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			service.removeUser(u);
			return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
		}
	}
	
	
}
