package com.example.bezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bezbednost.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneById(long id);
	User findOneByUsername(String username);
	
}
