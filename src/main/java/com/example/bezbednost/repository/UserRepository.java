package com.example.bezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.example.bezbednost.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneById(long id);
	User findOneByUsername(String username);
	
	User save(User user);
	
	@Modifying
	@Transactional
	void delete(User u);
	
}
