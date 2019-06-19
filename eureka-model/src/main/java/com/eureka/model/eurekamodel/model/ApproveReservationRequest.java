package com.eureka.model.eurekamodel.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"reservationId",
	"isApproved"
})

@XmlRootElement(name = "approve_reservation_request")
public class ApproveReservationRequest {
	
	@XmlElement(required = true)
	private long reservationId;
	
	@XmlElement(required = true)
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
