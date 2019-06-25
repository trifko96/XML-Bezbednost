package xml.accommodation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.accommodation_service.dto.PriceDTO;
import xml.accommodation_service.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	PriceService service;
	
	@PostMapping(value="/getPrice")
	public ResponseEntity<List<PriceDTO>> getPrice(@RequestBody long id){
		List<PriceDTO> priceDTO = service.getPrice(id);
		return new ResponseEntity<>(priceDTO, HttpStatus.OK);
	}
}
