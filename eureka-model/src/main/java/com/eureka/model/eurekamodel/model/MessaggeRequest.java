package com.eureka.model.eurekamodel.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"message"
})
@XmlRootElement(name = "message_request")
public class MessaggeRequest {
	@XmlElement(required = true)
	private Messagge message;
	
	public MessaggeRequest() {
		
	}

	public Messagge getMessage() {
		return message;
	}

	public void setMessage(Messagge message) {
		this.message = message;
	}
	
	
}
