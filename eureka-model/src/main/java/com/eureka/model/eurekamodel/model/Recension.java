package com.eureka.model.eurekamodel.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recension", propOrder = {
	"id",
	"value",
	"recensionStatus",
	"user",
	"accommodation"
})
public class Recension {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private long id;
	@XmlElement(required = true)
	private String value;
	@XmlElement(required = true)
	private RecensionStatus recensionStatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUser", referencedColumnName="userId")
	@XmlElement(required = true)
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAccommodation", referencedColumnName="accommodationId")
	@XmlElement(required = true)
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
