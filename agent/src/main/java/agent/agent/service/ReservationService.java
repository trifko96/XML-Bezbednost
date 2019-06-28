package agent.agent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.agent.dto.ReservationDTO;
import agent.agent.model.Accommodation;
import agent.agent.model.Reservation;
import agent.agent.repository.AccommodationRepository;
import agent.agent.repository.ReservationRepository;
import agent.agent.soap_clients.ReservationServiceSoapClient;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository repository;
	
	@Autowired
	ReservationServiceSoapClient soapClient;
	
	public List<ReservationDTO> getReservations(long id) {
		List<Reservation> res = repository.getReservations(id);
		List<ReservationDTO> resDTO = new ArrayList<>();
		for(Reservation r : res) {
			resDTO.add(new ReservationDTO(r));
		}
		return resDTO;
	}
	
	public void approveRes(long id) {
		repository.approveRes(id);
		soapClient.approveReservation(id);
	}
	
	public void rejectRes(long id) {
		repository.rejectRes(id);
	}
	
	public void saveAllRes() {
		repository.saveAll(soapClient.getReservations().getReservation());
	}
}
