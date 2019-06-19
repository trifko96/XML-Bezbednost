package com.eureka.model.eurekamodel.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"status",
	"messaggeId"
})
@XmlRootElement(name = "message_response")
public class MessaggeResponse {
	@XmlElement(required = true)
	private SoapStatus status;
	@XmlElement(required = true)
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
