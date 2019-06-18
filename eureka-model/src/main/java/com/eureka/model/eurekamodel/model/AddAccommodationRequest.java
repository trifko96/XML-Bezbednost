package com.eureka.model.eurekamodel.model;

public class AddAccommodationRequest {
	
	private long agentId;
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
