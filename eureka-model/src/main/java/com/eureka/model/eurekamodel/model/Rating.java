package com.eureka.model.eurekamodel.model;

import javax.persistence.*;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAccommodation", referencedColumnName="accommodationId")
	private Accommodation accommodation;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUser", referencedColumnName="userId")
	private User user;
	
	private String value;
	
	public Rating() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
