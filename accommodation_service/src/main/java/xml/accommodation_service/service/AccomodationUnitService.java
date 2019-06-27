package xml.accommodation_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Accommodation;
import com.eureka.model.eurekamodel.model.AccommodationService;
import com.eureka.model.eurekamodel.model.Reservation;

import xml.accommodation_service.dto.AccomodationDTO;
import xml.accommodation_service.repository.AccomodationUnitRepository;
import xml.accommodation_service.repository.ReservationRepository;

@Service
public class AccomodationUnitService {

	@Autowired
	AccomodationUnitRepository repository;
	
	@Autowired
	ReservationRepository resRepository;
	
	public void save(Accommodation acc) {
		repository.save(acc);
	}
	
	public List<AccomodationDTO> getAll() {
		List<Accommodation> accs =  repository.findAll();
		List<AccomodationDTO> accDTO = new ArrayList<>();
		for(Accommodation a : accs) {
			accDTO.add(new AccomodationDTO(a));
		}
		
		return accDTO;
	}
	
	public List<AccomodationDTO> searchAcc(AccomodationDTO a) {
		List<Accommodation> currentAcc = new ArrayList<>();
		List<Accommodation> a1 = new ArrayList<>();
		List<Accommodation> a2 = new ArrayList<>();
		List<Accommodation> a3 = new ArrayList<>();
		List<Accommodation> a4 = new ArrayList<>();
		List<Accommodation> a5 = new ArrayList<>();
		List<Accommodation> a6 = new ArrayList<>();
		int count = a.getAccommodationService().size();
		
		currentAcc = repository.findAll();
		
		if(a.getLocation().getName().equals("")) {
			a1 = currentAcc;
		} else {
			for(Accommodation acc : currentAcc) {
				if(acc.getLocation().getName().toLowerCase().contains(a.getLocation().getName().toLowerCase())) {
					a1.add(acc);
				}
			}
		}
		
		if(a.getCapacity() == 0) {
			a2 = a1;
		} else {
			for(Accommodation acc : a1) {
				if(acc.getCapacity() == a.getCapacity()) {
					a2.add(acc);
				}
			}
		}
		
		if(a.getAccommodationType() == null) {
			a3 = a2;
		} else {
			for(Accommodation acc : a2) {
				if(acc.getAccommodationType().getName().equals(a.getAccommodationType().getName())) {
					a3.add(acc);
				}
			}
		}
		
		if(a.getCategory() == 0) {
			a4 = a3;
		} else {
			for(Accommodation acc : a3) {
				if(acc.getCategory() == a.getCategory()) {
					a4.add(acc);
				}
			}
		}
		
		if(a.getFromDate() == null) {
			a6 = a4;
		} else {
			for(Accommodation acc : a4) {
				List<Reservation> res = resRepository.getReservations(acc.getName());
				boolean tmp = true;
				for(Reservation r : res) {
					if(!(a.getFromDate().after(r.getToDate())) && !(a.getToDate().before(r.getFromDate()))) {
						tmp = false;
					}
				}
				if(tmp) {
					a6.add(acc);
				}
			}
		}
		
		List<AccomodationDTO> accDTO = new ArrayList<>();
		for(Accommodation accomodation : a6) {
			accDTO.add(new AccomodationDTO(accomodation));
		}
		
		return accDTO;
		
	}
}
