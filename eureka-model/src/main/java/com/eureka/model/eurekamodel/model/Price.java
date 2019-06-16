package com.eureka.model.eurekamodel.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int oneNightPrice;
	private Date fromDate;
	private Date toDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAccommodation", referencedColumnName="accommodationId")
	private Accommodation accommodation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getOneNightPrice() {
		return oneNightPrice;
	}

	public void setOneNightPrice(int oneNightPrice) {
		this.oneNightPrice = oneNightPrice;
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
	
	
	
}
	
