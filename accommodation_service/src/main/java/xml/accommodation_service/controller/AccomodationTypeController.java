package xml.accommodation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.model.eurekamodel.model.AccommodationService;
import com.eureka.model.eurekamodel.model.AccommodationType;

import xml.accommodation_service.service.AccomodationTypeService;

@RestController
@RequestMapping("/accType")
public class AccomodationTypeController {
	
	@Autowired
	AccomodationTypeService service;

	@PostMapping(value = "/addNewAccType", consumes = "application/json")
	public ResponseEntity<List<AccommodationType>> addNewAccType(@RequestBody AccommodationType acc){
		AccommodationType accType = service.findByName(acc);
		if(accType != null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			service.save(acc);
			return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		}
			
	}
	
	@PostMapping(value = "/removeAccType", consumes = "application/json")
	public ResponseEntity<List<AccommodationType>> removeAccType(@RequestBody AccommodationType accType){
		//provera
		List<AccommodationType> accTypes = service.delete(accType);
		return new ResponseEntity<>(accTypes, HttpStatus.OK);
	}
}
