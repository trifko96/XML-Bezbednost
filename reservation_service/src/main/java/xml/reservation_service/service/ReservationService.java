package xml.reservation_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Reservation;
import com.eureka.model.eurekamodel.model.User;

import xml.reservation_service.dto.ReservationDTO;
import xml.reservation_service.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository repository;
	
	public List<ReservationDTO> getReservationsByUser(String username){
		List<Reservation> res = repository.getReservationsByUser(username);
		List<ReservationDTO> resDTO = new ArrayList<>();
		for(Reservation r : res) {
			resDTO.add(new ReservationDTO(r));
		}
		return resDTO;
		
	}
	
	public String getUser() {
		String tmp = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		return tmp;
	} 
}
