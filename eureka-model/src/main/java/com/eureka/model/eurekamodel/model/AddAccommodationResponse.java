package com.eureka.model.eurekamodel.model;

public class AddAccommodationResponse {

	private SoapStatus status;
	private long accommodaionId;
	
	
	public AddAccommodationResponse() {
		
	}
	
	
	public SoapStatus getStatus() {
		return status;
	}
	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	public long getAccommodaionId() {
		return accommodaionId;
	}
	public void setAccommodaionId(long accommodaionId) {
		this.accommodaionId = accommodaionId;
	}
	
	
}
