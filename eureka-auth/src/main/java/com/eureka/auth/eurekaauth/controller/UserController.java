package com.eureka.auth.eurekaauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eureka.auth.eurekaauth.service.UserService;
import com.eureka.model.eurekamodel.model.User;


@RestController
@RequestMapping(value = "/User")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/registration", method = RequestMethod.POST, consumes="application/json")
	public String registration(@RequestBody User user) {
		
		String retVal = service.registration(user);
		return retVal;
	}
	
}
