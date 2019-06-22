package agent.agent.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import agent.agent.dto.AccommodationDTO;
import agent.agent.service.ImageService;

@RestController
@RequestMapping("/")
public class ImageController {
	
	@Autowired
	ImageService service;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/uploadImages", produces =  MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity uploadImages(@RequestParam("file") MultipartFile[] images, @RequestParam("accId") long accId){
		try {
			service.uploadImages(images, accId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping(value = "/getImageIds")
	public List<Long> getImage(@RequestBody AccommodationDTO accUnit) {
		return service.getImagesIdByAccomodationUnit(accUnit.getAccommodationId());
	}
	
	@ResponseBody
	@PostMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@RequestBody long id) {
		byte[] binaryImage = service.getImageById(id);
		return binaryImage;
	}
}
