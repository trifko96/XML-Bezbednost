package com.eureka.model.eurekamodel.model;

import javax.persistence.*;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "accomodation_unit_id", foreignKey = @ForeignKey(name = "PRICE_PLAN_ACCOMODATION_UNIT_ID_FK"))
	private Accommodation accommodation;
	
	@ManyToOne
	@JoinColumn(name = "accomodation_unit_id", foreignKey = @ForeignKey(name = "PRICE_PLAN_ACCOMODATION_UNIT_ID_FK"))
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
