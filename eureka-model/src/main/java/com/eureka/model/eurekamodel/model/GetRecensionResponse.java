package com.eureka.model.eurekamodel.model;

import java.util.List;

public class GetRecensionResponse {
	
	private List<Recension> recension;
	private SoapStatus status;
	
	public GetRecensionResponse () {
		
	}

	public List<Recension> getRecension() {
		return recension;
	}

	public void setRecension(List<Recension> recension) {
		this.recension = recension;
	}

	public SoapStatus getStatus() {
		return status;
	}

	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	
	

}
