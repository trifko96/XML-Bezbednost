package agent.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.agent.dto.PriceDTO;
import agent.agent.service.PriceService;

@RestController
@RequestMapping(value="/price")
public class PriceController {

	@Autowired
	PriceService service;
	
	@PostMapping(value="/getPrice")
	public ResponseEntity<List<PriceDTO>> getPrice(@RequestBody long id){
		List<PriceDTO> priceDTO = service.getPrice(id);
		return new ResponseEntity<>(priceDTO, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value="/addNewPrice", consumes="application/json")
	public ResponseEntity addNewPrice(@RequestBody PriceDTO p){
		service.savePrice(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
