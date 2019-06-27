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

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
			logger.info("NP_EVENT DNS {} {} T", agentService.getUser().getUsername(), acc.getAccommodationId());
			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			logger.warn("NP_EVENT DNS {} {} F", agentService.getUser().getUsername(), acc.getAccommodationId());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getAllUnits")
	public ResponseEntity<List<AccommodationDTO>> getAllUnits(){
		User agent = agentService.getUser();
		List<AccommodationDTO> accDTO = service.getAllUnits(agent.getUserId());
		logger.info("NP_EVENT VSM {}", agentService.getUser().getUsername());
		return new ResponseEntity<>(accDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllTypes")
	public ResponseEntity<List<AccommodationType>> getAllTypes(){
		logger.info("NP_EVENT VST {}", agentService.getUser().getUsername());
		return new ResponseEntity<>(service.getAllTypes(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllServices")
	public ResponseEntity<List<agent.agent.model.AccommodationService>> getAllServices(){
		logger.info("NP_EVENT VSS {}", agentService.getUser().getUsername());
		return new ResponseEntity<>(service.getAllServices(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/getServicesByUnit", consumes = "application/json")
	public ResponseEntity<List<agent.agent.model.AccommodationService>> getServicesByUnit(@RequestBody Accommodation acc){
		logger.info("NP_EVENT VSSK {}", agentService.getUser().getUsername());
		return new ResponseEntity<>(service.getServicesByUnit(acc.getAccommodationId()),HttpStatus.OK);
	}
	
	@PostMapping(value="/reserveAccUnit", consumes="application/json")
	public ResponseEntity<List<AccommodationDTO>> reserveAccUnit(@RequestBody Accommodation acc){
		service.reserveAcc(acc.getAccommodationId());
		User agent = agentService.getUser();
		List<AccommodationDTO> accDTO = service.getAllUnits(agent.getUserId());
		logger.info("NP_EVENT RSM {}", agentService.getUser().getUsername());
		return new ResponseEntity<>(accDTO, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value="/getUsers")
	public ResponseEntity getUsers() {
		agentService.getUsers();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//dodati na frontu zahtev za sinhronizaciju
	@SuppressWarnings("rawtypes")
	@GetMapping(value="/syncAll")
	public ResponseEntity syncAll() {
		service.saveAllServices();
		service.saveAllTypes();
		return new ResponseEntity(HttpStatus.OK);
	}
}
