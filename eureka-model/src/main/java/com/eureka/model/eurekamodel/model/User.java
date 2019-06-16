package com.eureka.model.eurekamodel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private String username;
	private UserRole role;
	private UserStatus status;
	private String businessId;
	
	@OneToMany(mappedBy = "send", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<Messagge> sendMessagge;
	
	@OneToMany(mappedBy = "receive", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<Messagge> receiveMessagge;

	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<Rating> rating;
	
	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<Recension> recension;
	
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

	public List<Messagge> getSendMessagge() {
		if (sendMessagge == null) {
            sendMessagge = new ArrayList<Messagge>();
        }
        return this.sendMessagge;
	}

	public void setSendMessage(List<Messagge> sendMessage) {
		this.sendMessagge = sendMessage;
	}

	public List<Messagge> getReceiveMessage() {
		if (receiveMessagge == null) {
            receiveMessagge = new ArrayList<Messagge>();
        }
        return this.receiveMessagge;
	}

	public void setReceiveMessage(List<Messagge> receiveMessage) {
		this.receiveMessagge = receiveMessage;
	}

	public List<Rating> getRating() {
		if (rating == null) {
            rating = new ArrayList<Rating>();
        }
        return this.rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
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

	public List<Recension> getRecension() {
		if (recension == null) {
            recension = new ArrayList<Recension>();
        }
        return this.recension;
	}

	public void setRecension(List<Recension> recension) {
		this.recension = recension;
	}	
	
	


}
