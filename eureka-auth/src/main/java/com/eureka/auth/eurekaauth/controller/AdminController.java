package com.eureka.auth.eurekaauth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	AdminService service;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value = "/addNewAgent", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> addNewAgent(@RequestBody User user){
		
		User retVal = service.addNewAgent(user);
		if(retVal != null) {
			logger.warn("NP_EVENT DNA {} T", user.getUserId());
			return new ResponseEntity<>(service.getAgents(), HttpStatus.OK);
		} else {
			logger.warn("NP_EVENT DNA {} F", user.getUserId());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/activateUser", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> activateUser(@RequestBody User user){
		User u = service.getUserById(user.getUserId());
		service.activateUser(u);
		logger.info("NP_EVENT AK {}", user.getUserId());
		return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/blockUser", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> blockUser(@RequestBody User user){
		User u = service.getUserById(user.getUserId());
		service.blockUser(u);
		logger.info("NP_EVENT BK {}", user.getUserId());
		return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/removeUser", consumes = "application/json")
	public ResponseEntity<List<UserDTO>> removeUser(@RequestBody User user){
		User u = service.getUserById(user.getUserId());
		service.removeUser(u);
		logger.info("NP_EVENT OK {}", user.getUserId());
		return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getAgents")
	public ResponseEntity<List<UserDTO>> getAgents(){
		logger.info("NP_EVENT VA");
		return new ResponseEntity<>(service.getAgents(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<UserDTO>> getUsers(){
		logger.info("NP_EVENT VK");
		return new ResponseEntity<>(service.getUsers(),HttpStatus.OK);
	}
	
	
}
