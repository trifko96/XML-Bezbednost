package xml.messagge_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.messagge_service.dto.MessaggeDTO;
import xml.messagge_service.service.MessaggeService;
import xml.messagge_service.service.UserService;

@RestController
@RequestMapping("/mess")
public class MessaggeController {

	@Autowired
	MessaggeService service;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/getSentMessagges")
	public ResponseEntity<List<MessaggeDTO>> getSentMessagges(){
		String tmp = userService.getUser();
		List<MessaggeDTO> mesDTO = service.getSentMessagges(tmp);
		return new ResponseEntity<>(mesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/getReceivedMessagges")
	public ResponseEntity<List<MessaggeDTO>> getReceivedMessagges(){
		String tmp = userService.getUser();
		List<MessaggeDTO> mesDTO = service.getReceivedMessagges(tmp);
		return new ResponseEntity<>(mesDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/newMessagge", consumes="application/json")
	public ResponseEntity<List<MessaggeDTO>> newMessage(@RequestBody MessaggeDTO mDTO){
		String tmp = userService.getUser();
		List<MessaggeDTO> mesDTO = service.newMessagge(tmp, mDTO);
		return new ResponseEntity<>(mesDTO, HttpStatus.OK);
	}
}
