package xml.accommodation_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.accommodation_service.dto.PriceDTO;
import xml.accommodation_service.service.PriceService;
import xml.accommodation_service.service.UserService;

@RestController
@RequestMapping("/price")
public class PriceController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PriceService service;
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/getPrice")
	public ResponseEntity<List<PriceDTO>> getPrice(@RequestBody long id){
		List<PriceDTO> priceDTO = service.getPrice(id);
		logger.info("NP_EVENT VC {}", userService.getCurrentUsername());
		return new ResponseEntity<>(priceDTO, HttpStatus.OK);
	}
}
