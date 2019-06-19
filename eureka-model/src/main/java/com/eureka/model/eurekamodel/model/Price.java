package com.eureka.model.eurekamodel.model;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "price", propOrder = {
	"id",
	"oneNightPrice",
	"fromDate",
	"toDate",
	"accommodation"
})
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private long id;
	@XmlElement(required = true)
	private int oneNightPrice;
	@XmlElement(required = true)
	private Date fromDate;
	@XmlElement(required = true)
	private Date toDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAccommodation", referencedColumnName="accommodationId")
	@XmlElement(required = true)
	private Accommodation accommodation;

	public Price() {
		
	}
	
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
	
