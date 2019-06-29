package xml.reservation_service.controller;

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

import xml.reservation_service.dto.ReservationDTO;
import xml.reservation_service.service.ReservationService;
import xml.reservation_service.service.UserService;

@RestController
@RequestMapping("/res")
public class ReservationController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReservationService service;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/getReservations")
	public ResponseEntity<List<ReservationDTO>> getReservations(){
		String tmp = userService.getUser();
		List<ReservationDTO> resDTO = service.getReservationsByUser(tmp);
		logger.info("NP_EVENT VRE {}", userService.getUser());
		return new ResponseEntity<>(resDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/cancelReservation", consumes="application/json")
	public ResponseEntity<List<ReservationDTO>> cancelReservation(@RequestBody ReservationDTO resDTO){
		String tmp = userService.getUser();
		List<ReservationDTO> res = service.cancelReservation(tmp, resDTO.getId());
		logger.info("NP_EVENT OR {} {}", userService.getUser(), resDTO.getId());
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@PostMapping(value="/newReservation", consumes="application/json")
	public ResponseEntity<List<ReservationDTO>> newReservation(@RequestBody ReservationDTO resDTO){
		String tmp = userService.getUser();
		List<ReservationDTO> retVal = service.addNewReservation(tmp, resDTO);
		logger.info("NP_EVENT NRE {} {}", userService.getUser(), resDTO.getId());
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	
}
