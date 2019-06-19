package com.eureka.model.eurekamodel.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"accommodationService"
})

@XmlRootElement(name = "get_accommodation_service_response")
public class GetAccommodationServiceResponse {
	
	@XmlElement(required = true)
	private ArrayList<AccommodationService> accommodationService;
	
	
	public GetAccommodationServiceResponse() {
		
	}


	public ArrayList<AccommodationService> getAccommodationService() {
		return accommodationService;
	}


	public void setAccommodationService(ArrayList<AccommodationService> accommodationService) {
		this.accommodationService = accommodationService;
	}
	
	
	
	
}
