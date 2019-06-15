package com.eureka.auth.eurekaauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.eureka.auth.eurekaauth.repository.UserRepository;
import com.eureka.model.eurekamodel.model.User;


@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public User registration(User user)
	{
		User u = new User(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getUsername());
		
		User u1 = repository.findByUsername(user.getUsername());
		if(u1 != null)
			return null;
		else {
			repository.save(u);
			return u;
		}
	}

}
