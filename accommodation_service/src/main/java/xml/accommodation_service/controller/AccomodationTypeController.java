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

import com.eureka.model.eurekamodel.model.AccommodationService;
import com.eureka.model.eurekamodel.model.AccommodationType;

import xml.accommodation_service.service.AccomodationTypeService;
import xml.accommodation_service.service.UserService;

@RestController
@RequestMapping("/accType")
public class AccomodationTypeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AccomodationTypeService service;

	@Autowired
	UserService userService;
	
	@PostMapping(value = "/admin/addNewAccType", consumes = "application/json")
	public ResponseEntity<List<AccommodationType>> addNewAccType(@RequestBody AccommodationType acc){
		AccommodationType accType = service.findByName(acc);
		if(accType != null) {
			logger.warn("NP_EVENT DT {} {} F", userService.getCurrentUsername(), acc.getId());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			service.save(acc);
			logger.info("NP_EVENT DT {} {} T", userService.getCurrentUsername(), acc.getId());
			return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		}
			
	}
	
	@PostMapping(value = "/admin/removeAccType", consumes = "application/json")
	public ResponseEntity<List<AccommodationType>> removeAccType(@RequestBody AccommodationType accType){
		//provera
		List<AccommodationType> accTypes = service.delete(accType);
		logger.info("NP_EVENT BT {} {}", userService.getCurrentUsername(), accType.getId());
		return new ResponseEntity<>(accTypes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all/getTypes")
	public ResponseEntity<List<AccommodationType>> getServices(){
		logger.info("NP_EVENT VT {}",userService.getCurrentUsername());
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
}
