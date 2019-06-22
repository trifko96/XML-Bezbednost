package com.eureka.model.eurekamodel.model;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
	"id",
	"accommodation",
	"user",
	"fromDate",
	"toDate",
	"status"
})
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAccommodation", referencedColumnName="accommodationId")
	@XmlElement(required = true)
	private Accommodation accommodation;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUser", referencedColumnName="userId")
	@XmlElement(required = true)
	private User user;
	@XmlElement(required = true)
	private Date fromDate;
	@XmlElement(required = true)
	private Date toDate;
	@XmlElement(required = true)
	private ReservationStatus status;
	
	public Reservation() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
	
	

}