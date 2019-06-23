package agent.agent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import agent.agent.model.GetAgentResponse;
import agent.agent.model.User;
import agent.agent.repository.UserRepository;
import agent.agent.soap_clients.AuthServiceSoapClient;

@Service
public class AgentService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	AuthServiceSoapClient soapService;
	
	public User getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return repository.findByUsername(principal.toString());
	}
	
	public String getJwtToken() {
		return SecurityContextHolder.getContext().getAuthentication().getDetails().toString();
	}
	
	public void getUsers() {
		GetAgentResponse response = soapService.getAgentRequest();
		if(response.getUsers() == null)
			return;
		else
			repository.saveAll(response.getUsers());
	}
}
