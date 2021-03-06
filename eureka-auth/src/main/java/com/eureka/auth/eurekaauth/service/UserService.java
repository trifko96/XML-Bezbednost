package com.eureka.auth.eurekaauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;

import com.eureka.auth.eurekaauth.repository.UserRepository;
import com.eureka.model.eurekamodel.model.User;
import com.eureka.model.eurekamodel.model.UserRole;
import com.eureka.model.eurekamodel.model.UserStatus;


@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public User registration(User user)
	{
		String tmp = encoder.encode(user.getPassword());
		User u = new User(user.getName(), user.getSurname(), user.getEmail(), tmp, user.getUsername());
		u.setRole(UserRole.USER);
		u.setStatus(UserStatus.ACTIVATED);
		
		User u1 = repository.findUserByUsername(user.getUsername());
		if(u1 != null)
			return null;
		else {
			repository.save(u);
			return u;
		}
	}
	
}
