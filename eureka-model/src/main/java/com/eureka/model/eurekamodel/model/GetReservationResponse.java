package com.eureka.model.eurekamodel.model;

import java.util.List;

public class GetReservationResponse {

	private List<Reservation> reservation;
	private SoapStatus status;
	
	public GetReservationResponse () {
		
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public SoapStatus getStatus() {
		return status;
	}

	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	
	
	
}
