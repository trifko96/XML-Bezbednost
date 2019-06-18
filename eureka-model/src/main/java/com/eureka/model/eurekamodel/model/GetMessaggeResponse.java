package com.eureka.model.eurekamodel.model;

import java.util.List;

public class GetMessaggeResponse {

	private List<Messagge> messagge;
	private SoapStatus status; 
	
	public GetMessaggeResponse () {
		
	}

	public List<Messagge> getMessagge() {
		return messagge;
	}

	public void setMessagge(List<Messagge> messagge) {
		this.messagge = messagge;
	}

	public SoapStatus getStatus() {
		return status;
	}

	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	
	
	
}
