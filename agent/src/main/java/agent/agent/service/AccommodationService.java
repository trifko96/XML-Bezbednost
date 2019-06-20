package agent.agent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.agent.dto.AccommodationDTO;
import agent.agent.model.Accommodation;
import agent.agent.model.AccommodationType;
import agent.agent.repository.AccommodationRepository;
import agent.agent.repository.AccommodationServiceRepository;
import agent.agent.repository.AccommodationTypeRepository;

@Service
public class AccommodationService {

	@Autowired
	AccommodationRepository repository;
	
	@Autowired
	AccommodationTypeRepository typeRepository;
	
	@Autowired
	AccommodationServiceRepository serviceRepository;
	
	public AccommodationDTO addNewAcc(Accommodation acc) {
		Accommodation a = repository.findAccommodationByName(acc.getName());
		if(a != null) {
			return null;
		} else {
			repository.save(acc);
			AccommodationDTO accDTO = new AccommodationDTO(acc);
			return accDTO;
		}
	}
	
	public List<AccommodationDTO> getAllUnits(long id){
		List<Accommodation> accs = repository.getAllAccommodations(id);
		List<AccommodationDTO> accDTO = new ArrayList<>();
		for(Accommodation a : accs) {
			accDTO.add(new AccommodationDTO(a));
		}
		return accDTO;
	}
	
	public List<AccommodationType> getAllTypes(){
		return typeRepository.findAll();
	}
	
	public List<agent.agent.model.AccommodationService> getAllServices(){
		return serviceRepository.findAll();
	}
}
