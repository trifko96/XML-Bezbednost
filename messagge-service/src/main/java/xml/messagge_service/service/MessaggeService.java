package xml.messagge_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Accommodation;
import com.eureka.model.eurekamodel.model.Messagge;
import com.eureka.model.eurekamodel.model.User;

import xml.messagge_service.dto.MessaggeDTO;
import xml.messagge_service.repository.AccommodationRepository;
import xml.messagge_service.repository.MessaggeRepository;
import xml.messagge_service.repository.UserRepository;

@Service
public class MessaggeService {

	@Autowired
	MessaggeRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccommodationRepository accRepository;
	
	public List<MessaggeDTO> getSentMessagges(String tmp){
		List<Messagge> messagges = repository.getSentMessagges(tmp);
		List<MessaggeDTO> mesDTO = new ArrayList<>();
		for(Messagge m : messagges) {
			mesDTO.add(new MessaggeDTO(m));
		}
		return mesDTO;
	}
	
	public List<MessaggeDTO> getReceivedMessagges(String tmp){
		List<Messagge> messagges = repository.getReceivedMessagges(tmp);
		List<MessaggeDTO> mesDTO = new ArrayList<>();
		for(Messagge m : messagges) {
			mesDTO.add(new MessaggeDTO(m));
		}
		return mesDTO;
	}
	
	public List<MessaggeDTO> newMessagge(String tmp, MessaggeDTO mDTO){
		Messagge m = new Messagge();
		m.setContent(mDTO.getContent());
		User u = userRepository.findByUsername(tmp);
		Accommodation a = accRepository.findByName(mDTO.getAccommodationName()); 
		m.setSend(u);
		m.setReceive(a.getAgent());
		repository.save(m);
		return getSentMessagges(tmp);
	}
	
	public List<Messagge> getAllMessagges(){
		return repository.findAll();
	}
	
	public void save(Messagge m) {
		repository.save(m);
	}
}
