package xml.accommodation_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Accommodation;

import xml.accommodation_service.dto.AccomodationDTO;
import xml.accommodation_service.repository.AccomodationUnitRepository;

@Service
public class AccomodationUnitService {

	@Autowired
	AccomodationUnitRepository repository;
	
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
}
