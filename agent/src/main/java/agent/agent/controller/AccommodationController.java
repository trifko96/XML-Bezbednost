package agent.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.agent.dto.AccommodationDTO;
import agent.agent.model.Accommodation;
import agent.agent.model.AccommodationStatus;
import agent.agent.model.AccommodationType;
import agent.agent.model.User;
import agent.agent.service.AccommodationService;
import agent.agent.service.AgentService;

@RestController
@RequestMapping(value = "/acc")
public class AccommodationController {

	@Autowired
	AccommodationService service;
	
	@Autowired
	AgentService agentService;
	
	@PostMapping(value = "/addNewAcc", consumes = "application/json")
	public ResponseEntity<AccommodationDTO> addNewAcc(@RequestBody Accommodation acc){
		User agent = agentService.getUser();
		acc.setAgent(agent);
		acc.setStatus(AccommodationStatus.FREE);
		AccommodationDTO a = service.addNewAcc(acc);
		if(a != null) {
			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getAllUnits")
	public ResponseEntity<List<AccommodationDTO>> getAllUnits(){
		User agent = agentService.getUser();
		List<AccommodationDTO> accDTO = service.getAllUnits(agent.getUserId());
		return new ResponseEntity<>(accDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllTypes")
	public ResponseEntity<List<AccommodationType>> getAllTypes(){
		return new ResponseEntity<>(service.getAllTypes(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllServices")
	public ResponseEntity<List<agent.agent.model.AccommodationService>> getAllServices(){
		return new ResponseEntity<>(service.getAllServices(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/getServicesByUnit", consumes = "application/json")
	public ResponseEntity<List<agent.agent.model.AccommodationService>> getServicesByUnit(@RequestBody Accommodation acc){
		return new ResponseEntity<>(service.getServicesByUnit(acc.getAccommodationId()),HttpStatus.OK);
	}
	
	@PostMapping(value="/reserveAccUnit", consumes="application/json")
	public ResponseEntity<List<AccommodationDTO>> reserveAccUnit(@RequestBody Accommodation acc){
		service.reserveAcc(acc.getAccommodationId());
		User agent = agentService.getUser();
		List<AccommodationDTO> accDTO = service.getAllUnits(agent.getUserId());
		return new ResponseEntity<>(accDTO, HttpStatus.OK);
		
	}
}
