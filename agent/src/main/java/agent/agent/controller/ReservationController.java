package agent.agent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.agent.dto.AccommodationDTO;
import agent.agent.dto.ReservationDTO;
import agent.agent.model.User;
import agent.agent.service.AccommodationService;
import agent.agent.service.AgentService;
import agent.agent.service.ReservationService;

@RestController
@RequestMapping(value="/res")
public class ReservationController {
	
	@Autowired
	ReservationService service;
	
	@Autowired
	AgentService agentService;
	
	@Autowired
	AccommodationService accService;

	@GetMapping(value="/getReservations")
	public ResponseEntity<List<ReservationDTO>> getReservations(){
		User agent = agentService.getUser();
		List<AccommodationDTO> accDTO = accService.getAllUnits(agent.getUserId());
		List<ReservationDTO> resDTO = new ArrayList<>();
		for(AccommodationDTO ac : accDTO) {
			List<ReservationDTO> tmp = service.getReservations(ac.getAccommodationId());
			for(ReservationDTO r : tmp) {
				resDTO.add(r);
			}
		}
		return new ResponseEntity<>(resDTO,HttpStatus.OK);
	}
	
	@PostMapping(value="/approveRes", consumes="application/json")
	public ResponseEntity<List<ReservationDTO>> approveRes(@RequestBody ReservationDTO r){
		service.approveRes(r.getId());
		User agent = agentService.getUser();
		List<AccommodationDTO> accDTO = accService.getAllUnits(agent.getUserId());
		List<ReservationDTO> resDTO = new ArrayList<>();
		for(AccommodationDTO ac : accDTO) {
			List<ReservationDTO> tmp = service.getReservations(ac.getAccommodationId());
			for(ReservationDTO res : tmp) {
				resDTO.add(res);
			}
		}
		return new ResponseEntity<>(resDTO,HttpStatus.OK);
	}
	
	@PostMapping(value="/rejectRes", consumes="application/json")
	public ResponseEntity<List<ReservationDTO>> rejectRes(@RequestBody ReservationDTO r){
		service.rejectRes(r.getId());
		User agent = agentService.getUser();
		List<AccommodationDTO> accDTO = accService.getAllUnits(agent.getUserId());
		List<ReservationDTO> resDTO = new ArrayList<>();
		for(AccommodationDTO ac : accDTO) {
			List<ReservationDTO> tmp = service.getReservations(ac.getAccommodationId());
			for(ReservationDTO res : tmp) {
				resDTO.add(res);
			}
		}
		return new ResponseEntity<>(resDTO,HttpStatus.OK);
	}
	
	
}
