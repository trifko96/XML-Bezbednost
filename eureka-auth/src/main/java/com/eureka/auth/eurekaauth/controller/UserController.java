package com.eureka.auth.eurekaauth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eureka.auth.eurekaauth.service.UserService;
import com.eureka.model.eurekamodel.model.User;


@RestController
@RequestMapping(value = "/User")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/registration", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<User> registration(@RequestBody User user) {
		
		User retVal = service.registration(user);
		if(retVal != null) {
			return new ResponseEntity<>(retVal,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}


