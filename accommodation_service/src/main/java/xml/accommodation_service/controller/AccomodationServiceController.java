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

import xml.accommodation_service.service.AccomodationServiceService;
import xml.accommodation_service.service.UserService;

import com.eureka.model.eurekamodel.model.AccommodationService;

@RestController
@RequestMapping("/accService")
public class AccomodationServiceController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AccomodationServiceService service;
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/admin/addNewAccService", consumes = "application/json")
	public ResponseEntity<List<AccommodationService>> addNewAccService(@RequestBody AccommodationService acc){
		AccommodationService accService = service.findByName(acc);
		if(accService != null) {
			logger.warn("NP_EVENT DNS {} {} F", userService.getCurrentUsername(), acc.getAccommodationServiceId());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			service.save(acc);
			logger.info("NP_EVENT DNS {} {} T", userService.getCurrentUsername(), acc.getAccommodationServiceId());
			return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		}
			
	}
	
	@PostMapping(value = "/admin/removeAccService", consumes = "application/json")
	public ResponseEntity<List<AccommodationService>> removeAccService(@RequestBody AccommodationService accService){
		//provera
		List<AccommodationService> accServices = service.delete(accService);
		logger.info("NP_EVENT BSE {} {}", userService.getCurrentUsername(), accService.getAccommodationServiceId());
		return new ResponseEntity<>(accServices, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all/getServices")
	public ResponseEntity<List<AccommodationService>> getServices(){
		logger.info("NP_EVENT VSE {}", userService.getCurrentUsername());
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
}
