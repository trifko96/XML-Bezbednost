package com.eureka.model.eurekamodel.model;

public class MessaggeResponse {
	
	private SoapStatus status;
	private long messaggeId;
	
	public MessaggeResponse() {
		
	}

	public SoapStatus getStatus() {
		return status;
	}

	public void setStatus(SoapStatus status) {
		this.status = status;
	}

	public long getMessaggeId() {
		return messaggeId;
	}

	public void setMessaggeId(long messaggeId) {
		this.messaggeId = messaggeId;
	}
	
	
	

}
