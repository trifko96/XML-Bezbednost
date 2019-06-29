package xml.reservation_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Accommodation;
import com.eureka.model.eurekamodel.model.Reservation;
import com.eureka.model.eurekamodel.model.ReservationStatus;
import com.eureka.model.eurekamodel.model.User;

import xml.reservation_service.dto.ReservationDTO;
import xml.reservation_service.repository.AccommodationRepository;
import xml.reservation_service.repository.ReservationRepository;
import xml.reservation_service.repository.UserRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccommodationRepository accRepository;
	
	public List<ReservationDTO> getReservationsByUser(String username){
		List<Reservation> res = repository.getReservationsByUser(username);
		List<ReservationDTO> resDTO = new ArrayList<>();
		for(Reservation r : res) {
			resDTO.add(new ReservationDTO(r));
		}
		return resDTO;
		
	}
	
	public List<ReservationDTO> cancelReservation(String username, long id) {
		repository.deleteReservation(id);
		return getReservationsByUser(username);
	}
	
	public List<ReservationDTO> addNewReservation(String tmp, ReservationDTO res){
		User u = userRepository.findUserByUsername(tmp);
		Accommodation a = accRepository.findAccommodationById(res.getAccommodationId());
		Reservation r = new Reservation();
		r.setFromDate(res.getFromDate());
		r.setToDate(res.getToDate());
		
		r.setStatus(ReservationStatus.PENDING);
		r.setUser(u);
		r.setAccommodation(a);
		repository.save(r);
		return getReservationsByUser(tmp);
		
	}
	
	public List<Reservation> getReservations() {
		List<Reservation> res = repository.findAll();
		return res;
	}
	
	public void save(Reservation r) {
		repository.save(r);
	}
	
	public Reservation getResById(long id) {
		return repository.getReservationById(id);
	}
}
