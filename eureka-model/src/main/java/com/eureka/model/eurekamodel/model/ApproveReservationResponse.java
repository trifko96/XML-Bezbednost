package com.eureka.model.eurekamodel.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"status"
})

@XmlRootElement(name = "approve_reservation_response")
public class ApproveReservationResponse {
	
	@XmlElement(required = true)
	private SoapStatus status;
	
	public ApproveReservationResponse() {
		
	}

	public SoapStatus getStatus() {
		return status;
	}

	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	
	

}
