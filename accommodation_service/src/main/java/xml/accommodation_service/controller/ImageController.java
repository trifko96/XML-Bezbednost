package xml.accommodation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xml.accommodation_service.dto.AccomodationDTO;
import xml.accommodation_service.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	ImageService service;
	
	@ResponseBody
	@PostMapping(value = "/getImageIds")
	public List<Long> getImage(@RequestBody AccomodationDTO accUnit) {
		return service.getImagesIdByAccomodationUnit(accUnit.getAccommodationId());
	}
	
	@ResponseBody
	@PostMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@RequestBody long id) {
		byte[] binaryImage = service.getImageById(id);
		return binaryImage;
	}
}
