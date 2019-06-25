package xml.accommodation_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Price;

import xml.accommodation_service.dto.PriceDTO;
import xml.accommodation_service.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	PriceRepository repository;
	
	public void save(Price price) {
		repository.save(price);
	}
	
	public List<PriceDTO> getPrice(long id) {
		List<Price> price = repository.getPrice(id);
		List<PriceDTO> priceDTO = new ArrayList<>();
		for(Price p : price) {
			priceDTO.add(new PriceDTO(p));
		}
		return priceDTO;
	}
}
