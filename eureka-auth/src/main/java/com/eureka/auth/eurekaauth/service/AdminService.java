package com.eureka.auth.eurekaauth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.auth.eurekaauth.dto.UserDTO;
import com.eureka.auth.eurekaauth.repository.AdminRepository;
import com.eureka.model.eurekamodel.model.User;
import com.eureka.model.eurekamodel.model.UserRole;

@Service
public class AdminService {

	@Autowired
	AdminRepository repository;
	
	public User addNewAgent(User user) {
		User u = new User(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getUsername());
		u.setRole(UserRole.AGENT);
		u.setBusinessId(user.getBusinessId());
		
		User u1 = repository.findUserByUsername(user.getUsername());
		if(u1 != null)
			return null;
		else {
			repository.save(u);
			return u;
		}
	}
	
	public User getUserById(long id) {
		User u = repository.findUserById(id);
		return u;
	}
	
	public void activateUser(User user) {
		repository.activateUser(user.getUserId());
	}
	
	public List<UserDTO> getUsers(){
		List<User> users = repository.findUserByRole(UserRole.USER);
		List<UserDTO> usersDTO = new ArrayList<>();
		for(User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		return usersDTO;
	}
	
	public List<UserDTO> getAgents(){
		List<User> users = repository.findUserByRole(UserRole.AGENT);
		List<UserDTO> usersDTO = new ArrayList<>();
		for(User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		return usersDTO;
	}
	
	public void blockUser(User user) {
		repository.blockUser(user.getUserId());
	}
	
	public void removeUser(User user) {
		repository.delete(user);
	}
}
