package com.eureka.model.eurekamodel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
	"userId",
	"name",
	"surname",
	"email",
	"password",
	"username",
	"role",
	"status",
	"businessId"
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private long userId;
	@XmlElement(required = true)
	private String name;
	@XmlElement(required = true)
	private String surname;
	@XmlElement(required = true)
	private String email;
	@XmlElement(required = true)
	private String password;
	@XmlElement(required = true)
	private String username;
	@XmlElement(required = true)
	private UserRole role;
	@XmlElement(required = true)
	private UserStatus status;
	@XmlElement(required = true)
	private String businessId;
	
	
	public User() {
		
	}
	
	public User(String name, String surname, String email, String password, String username) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
