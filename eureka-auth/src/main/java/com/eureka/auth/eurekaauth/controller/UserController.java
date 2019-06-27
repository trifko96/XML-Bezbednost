package com.eureka.auth.eurekaauth.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eureka.auth.eurekaauth.service.UserService;
import com.eureka.model.eurekamodel.model.User;


@RestController
@RequestMapping(value = "/User")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/registration", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<User> registration(@RequestBody User user) {
		
		User retVal = service.registration(user);
		if(retVal != null) {
			logger.info("SE_EVENT RK {}",user.getUserId());
			return new ResponseEntity<>(retVal,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}


