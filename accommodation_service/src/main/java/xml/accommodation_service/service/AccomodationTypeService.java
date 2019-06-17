package xml.accommodation_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.AccommodationService;
import com.eureka.model.eurekamodel.model.AccommodationType;

import xml.accommodation_service.repository.AccomodationTypeRepository;

@Service
public class AccomodationTypeService {

	@Autowired
	AccomodationTypeRepository repository;
	
	public AccommodationType findByName(AccommodationType acc) {
		 return repository.findAccommodationTypeByName(acc.getName());
	}
	
	public void save(AccommodationType service) {
		repository.save(service);
	}
	
	public List<AccommodationType> getAll() {
		return repository.findAll();
	}
	
	public List<AccommodationType> delete(AccommodationType acc){
		repository.delete(acc.getId());
		return repository.findAll();
	}
}
