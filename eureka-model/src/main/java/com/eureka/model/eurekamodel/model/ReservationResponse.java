package com.eureka.model.eurekamodel.model;

public class ReservationResponse {
	
	private long reservationId;
	private SoapStatus status;
	
	
	public ReservationResponse() {
		
	}


	public long getReservationId() {
		return reservationId;
	}


	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}


	public SoapStatus getStatus() {
		return status;
	}


	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	
	
	

}
