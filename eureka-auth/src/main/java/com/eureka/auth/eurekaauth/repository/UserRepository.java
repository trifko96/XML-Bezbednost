package com.eureka.auth.eurekaauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eureka.model.eurekamodel.model.User;



public interface UserRepository extends  JpaRepository<User, Long> {

	public User save(User user);
	
	//@Query("select user from User user where user.username = ?1")
	public User findByUsername(String username);

}
