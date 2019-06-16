package com.eureka.model.eurekamodel.model;

import javax.persistence.*;

@Entity
public class Recension {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
	private String value;
	private RecensionStatus recensionStatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUser", referencedColumnName="userId")
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAccommodation", referencedColumnName="accommodationId")
	private Accommodation accommodation;
	
	public Recension() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public RecensionStatus getRecensionStatus() {
		return recensionStatus;
	}

	public void setRecensionStatus(RecensionStatus recensionStatus) {
		this.recensionStatus = recensionStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
	
	
	

}
