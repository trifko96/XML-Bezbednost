package xml.accommodation_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.model.eurekamodel.model.Image;

import xml.accommodation_service.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	ImageRepository repository;
	
	public void save(List<Image> images) {
		repository.saveAll(images);
	}
	
	public byte[] getImageById(long id){
		Image image = repository.getOne(id);
		return image.getCode();
	}
	
	public List<Long> getImagesIdByAccomodationUnit(long accId){
		return repository.getImagesId(accId);
	}
}
