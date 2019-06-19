package com.eureka.model.eurekamodel.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"agentId",
	"accommodation"
})

@XmlRootElement(name = "add_accommodation_request")
public class AddAccommodationRequest {
	
	@XmlElement(required = true)
	private long agentId;
	
	@XmlElement(required = true)
	private Accommodation accommodation;
	
	
	public AddAccommodationRequest() {
		
	}
	

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
	
	

}
