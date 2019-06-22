package agent.agent.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import agent.agent.model.Accommodation;
import agent.agent.model.Image;
import agent.agent.repository.AccommodationRepository;
import agent.agent.repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	ImageRepository repository;
	
	@Autowired
	AccommodationRepository accRepository;

	public void uploadImages(MultipartFile[] images, long accId) throws IOException {
		
		Accommodation accUnit = accRepository.findOneByAccommodationId(accId);
		
		ArrayList<Image> imagesModel = new ArrayList<>();
		for (MultipartFile image  : images) {
			Image imageModel = new Image();
			imageModel.setCode(image.getBytes());
			imageModel.setAccommodation(accUnit);
			imagesModel.add(imageModel);
		}
		repository.saveAll(imagesModel);	
	}
	
	public byte[] getImageById(long id){
		Image image = repository.getOne(id);
		return image.getCode();
	}
	
	public List<Long> getImagesIdByAccomodationUnit(long accId){
		return repository.getImagesId(accId);
	}
}
