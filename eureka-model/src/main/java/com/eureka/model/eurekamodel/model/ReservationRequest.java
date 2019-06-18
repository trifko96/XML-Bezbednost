package com.eureka.model.eurekamodel.model;

public class ReservationRequest {

	private long agentId;
	private Reservation reservation;
	
	
	public ReservationRequest() {
		
	}


	public long getAgentId() {
		return agentId;
	}


	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
	
}
