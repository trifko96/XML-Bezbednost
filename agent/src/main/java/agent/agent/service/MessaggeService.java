package agent.agent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.agent.dto.MessaggeDTO;
import agent.agent.model.Messagge;
import agent.agent.model.User;
import agent.agent.repository.MessaggeRepository;
import agent.agent.repository.UserRepository;

@Service
public class MessaggeService {

	@Autowired
	MessaggeRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<MessaggeDTO> getMessagges(String username){
		List<Messagge> messagges = repository.getMessagge(username);
		List<MessaggeDTO> messDTO = new ArrayList<>();
		for(Messagge m : messagges) {
			messDTO.add(new MessaggeDTO(m));
		}
		return messDTO;
	}
	
	public List<MessaggeDTO> newMessagge(MessaggeDTO m){
		Messagge messagge = new Messagge();
		messagge.setContent(m.getContent());
		User sender = userRepository.findByUsername(m.getAgentName());
		User receiver = userRepository.findByUsername(m.getUserName());
		messagge.setSend(sender);
		messagge.setReceive(receiver);
		repository.save(messagge);
		return getMessagges(m.getAgentName());
	}
}
