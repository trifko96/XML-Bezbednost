package com.eureka.auth.eurekaauth.endpoint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eureka.auth.eurekaauth.service.AdminService;
import com.eureka.model.eurekamodel.model.GetAgentRequest;
import com.eureka.model.eurekamodel.model.GetAgentResponse;
import com.eureka.model.eurekamodel.model.User;

@Endpoint
public class AuthEndpoint {

	@Autowired
	AdminService service;
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "get_agent_request")
	public GetAgentResponse getAgents(@RequestPayload GetAgentRequest request) {
		ArrayList<User> agents = (ArrayList<User>) service.getAllUsers();
		GetAgentResponse response = new GetAgentResponse();
		response.setUsers(agents);
		
		return response;
	}
}
