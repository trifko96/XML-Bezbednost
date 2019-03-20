package com.example.bezbednost.dto;

import com.example.bezbednost.model.User;

public class UserDTO {
	
	private Long id;
	private String username;
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
