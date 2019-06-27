package xml.accommodation_service.controller;

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

import com.eureka.model.eurekamodel.model.Accommodation;

import xml.accommodation_service.dto.AccomodationDTO;
import xml.accommodation_service.service.AccomodationUnitService;
import xml.accommodation_service.service.UserService;

@RestController
@RequestMapping("/acc")
public class AccomodationController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AccomodationUnitService service;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/all/getAccommodations")
	public ResponseEntity<List<AccomodationDTO>> getAccommodations(){
		List<AccomodationDTO> accs = service.getAll();
		logger.info("NP_EVENT VS {}", userService.getCurrentUsername());
		return new ResponseEntity<>(accs, HttpStatus.OK);
	}
	
	@PostMapping(value="/all/searchAcc", consumes="application/json")
	public ResponseEntity<List<AccomodationDTO>> searchAcc(@RequestBody AccomodationDTO accDTO){
		List<AccomodationDTO> acDTO = service.searchAcc(accDTO);
		logger.info("NP_EVENT PRS {}", userService.getCurrentUsername());
		return new ResponseEntity<>(acDTO, HttpStatus.OK);
	}
}
