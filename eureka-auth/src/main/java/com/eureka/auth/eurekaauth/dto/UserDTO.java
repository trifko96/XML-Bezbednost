package com.eureka.auth.eurekaauth.dto;

import com.eureka.model.eurekamodel.model.User;
import com.eureka.model.eurekamodel.model.UserRole;
import com.eureka.model.eurekamodel.model.UserStatus;

public class UserDTO {

	private long userId;
	private String name;
	private String surname;
	private String email;
	private String username;
	private UserRole role;
	private UserStatus status;
	private String businessId;
	
	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.role = user.getRole();
		this.status = user.getStatus();
		this.businessId = user.getBusinessId();
	}
	
	public UserDTO() {
		
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	
	
}
