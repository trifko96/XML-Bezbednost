package agent.agent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import agent.agent.model.User;
import agent.agent.repository.UserRepository;

@Service
public class AgentService {

	@Autowired
	UserRepository repository;
	
	public User getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return repository.findByUsername(principal.toString());
	}
}
