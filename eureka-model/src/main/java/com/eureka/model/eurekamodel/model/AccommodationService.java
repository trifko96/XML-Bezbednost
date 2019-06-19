package com.eureka.model.eurekamodel.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accommodation_service", propOrder = {
	"name",
	"accommodationServiceId"
})
public class AccommodationService {
	
	@XmlElement(required = true)
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private long accommodationServiceId;
	
	public AccommodationService() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public long getAccommodationServiceId() {
		return accommodationServiceId;
	}


	public void setAccommodationServiceId(long accommodationServiceId) {
		this.accommodationServiceId = accommodationServiceId;
	}

	
	
}
