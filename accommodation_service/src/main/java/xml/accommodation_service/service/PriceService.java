package xml.accommodation_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Price;

import xml.accommodation_service.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	PriceRepository repository;
	
	public void save(Price price) {
		repository.save(price);
	}
}
