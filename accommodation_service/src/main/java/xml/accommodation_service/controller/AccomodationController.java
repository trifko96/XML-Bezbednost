package xml.accommodation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.model.eurekamodel.model.Accommodation;

import xml.accommodation_service.dto.AccomodationDTO;
import xml.accommodation_service.service.AccomodationUnitService;

@RestController
@RequestMapping("/acc")
public class AccomodationController {

	@Autowired
	AccomodationUnitService service;
	
	@GetMapping(value="/getAccommodations")
	public ResponseEntity<List<AccomodationDTO>> getAccommodations(){
		List<AccomodationDTO> accs = service.getAll();
		return new ResponseEntity<>(accs, HttpStatus.OK);
	}
}
