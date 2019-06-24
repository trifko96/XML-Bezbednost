package xml.reservation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.reservation_service.dto.ReservationDTO;
import xml.reservation_service.service.ReservationService;

@RestController
@RequestMapping("/res")
public class ReservationController {

	@Autowired
	ReservationService service;
	
	@GetMapping(value="/getReservations")
	public ResponseEntity<List<ReservationDTO>> getReservations(){
		String tmp = service.getUser();
		List<ReservationDTO> resDTO = service.getReservationsByUser(tmp);
		return new ResponseEntity<>(resDTO, HttpStatus.OK);
	}
}
