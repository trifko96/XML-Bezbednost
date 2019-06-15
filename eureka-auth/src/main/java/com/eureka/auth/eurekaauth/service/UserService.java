package com.eureka.auth.eurekaauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;

import com.eureka.auth.eurekaauth.repository.UserRepository;
import com.eureka.model.eurekamodel.model.User;


@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public User registration(User user)
	{
		String tmp = encoder.encode(user.getPassword());
		User u = new User(user.getName(), user.getSurname(), user.getEmail(), tmp, user.getUsername());
		
		User u1 = repository.findByUsername(user.getUsername());
		if(u1 != null)
			return null;
		else {
			repository.save(u);
			return u;
		}
	}
//insert into user (id, name, surname, email, password, username, role) values (1, 'Petar', 'Petrovic', 'admin@gmail.com', , 'admin', 0);
}
