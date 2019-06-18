package com.eureka.model.eurekamodel.model;

public class ApproveReservationRequest {
	
	private long reservationId;
	private boolean isApproved;
	
	
	public ApproveReservationRequest() {
		
	}


	public long getReservationId() {
		return reservationId;
	}


	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
	

}
