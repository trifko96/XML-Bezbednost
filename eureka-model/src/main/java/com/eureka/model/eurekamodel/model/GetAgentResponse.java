package com.eureka.model.eurekamodel.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"users"
})
@XmlRootElement(name = "get_agent_response")
public class GetAgentResponse {
	
	@XmlElement(required = true)
	private List<User> users;
	
	
	public GetAgentResponse () {
		
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	

}
