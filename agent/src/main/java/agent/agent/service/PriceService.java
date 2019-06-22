package agent.agent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.agent.dto.PriceDTO;
import agent.agent.model.Accommodation;
import agent.agent.model.Price;
import agent.agent.repository.AccommodationRepository;
import agent.agent.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	PriceRepository repository;
	
	@Autowired
	AccommodationRepository accRepository;
	
	public List<PriceDTO> getPrice(long id) {
		List<Price> price = repository.getPrice(id);
		List<PriceDTO> priceDTO = new ArrayList<>();
		for(Price p : price) {
			priceDTO.add(new PriceDTO(p));
		}
		return priceDTO;
	}
	
	public void savePrice(PriceDTO p) {
		Accommodation acc = accRepository.findOneByAccommodationId(p.getAccId());
		
		Price price = new Price();
		price.setOneNightPrice(p.getOneNightPrice());
		price.setFromDate(p.getFromDate());
		price.setToDate(p.getToDate());
		price.setAccommodation(acc);
		
		repository.save(price);
	}
}
