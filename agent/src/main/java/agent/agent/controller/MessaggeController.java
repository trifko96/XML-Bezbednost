package agent.agent.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.agent.dto.MessaggeDTO;
import agent.agent.model.User;
import agent.agent.service.AgentService;
import agent.agent.service.MessaggeService;

@RestController
@RequestMapping(value="/mess")
public class MessaggeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MessaggeService service;
	
	@Autowired
	AgentService agentService;
	
	@GetMapping(value="/getReceivedMessagges")
	public ResponseEntity<List<MessaggeDTO>> getMessagges(){
		User u = agentService.getUser();
		List<MessaggeDTO> mesDTO = service.getMessagges(u.getUsername());
		return new ResponseEntity<>(mesDTO,HttpStatus.OK);
	}
	
	@PostMapping(value="/newMessagge", consumes="application/json")
	public ResponseEntity<List<MessaggeDTO>> newMessagge(@RequestBody MessaggeDTO m){
		List<MessaggeDTO> messDTO = service.newMessagge(m);
		logger.info("NP_EVENT PP {} {}", agentService.getUser().getUserId(), m.getUserName());
		return new ResponseEntity<>(messDTO, HttpStatus.OK);
	}
}
