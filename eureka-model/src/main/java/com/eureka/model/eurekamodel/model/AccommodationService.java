package com.eureka.model.eurekamodel.model;

import javax.persistence.*;

@Entity
public class AccommodationService {
	
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
