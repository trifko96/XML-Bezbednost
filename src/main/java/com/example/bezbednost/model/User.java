package com.example.bezbednost.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.bezbednost.dto.UserDTO;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "username", nullable = false, length = 50, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "users_roles", joinColumns=@JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns=@JoinColumn(name = "role_id", referencedColumnName = "id"))
//	private List<UserRole> roles;
	

	public User() {
		super();
	}

	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User(UserDTO user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

