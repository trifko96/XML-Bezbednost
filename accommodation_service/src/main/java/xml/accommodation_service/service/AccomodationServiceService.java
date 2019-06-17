package xml.accommodation_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.AccommodationService;

import xml.accommodation_service.repository.AccomodationServiceRepository;

@Service
public class AccomodationServiceService {

	@Autowired
	AccomodationServiceRepository repository;
	
	public AccommodationService findByName(AccommodationService acc) {
		 return repository.findServiceByName(acc.getName());
	}
	
	public void save(AccommodationService service) {
		repository.save(service);
	}
	
	public List<AccommodationService> getAll() {
		return repository.findAll();
	}
	
	public List<AccommodationService> delete(AccommodationService acc){
		repository.delete(acc.getAccommodationServiceId());
		return repository.findAll();
	}
}
