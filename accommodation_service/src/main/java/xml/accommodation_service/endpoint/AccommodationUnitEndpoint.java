package xml.accommodation_service.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eureka.model.eurekamodel.model.Accommodation;
import com.eureka.model.eurekamodel.model.AccommodationService;
import com.eureka.model.eurekamodel.model.AccommodationType;
import com.eureka.model.eurekamodel.model.AddAccommodationRequest;
import com.eureka.model.eurekamodel.model.AddAccommodationResponse;
import com.eureka.model.eurekamodel.model.AddImagesRequest;
import com.eureka.model.eurekamodel.model.AddImagesResponse;
import com.eureka.model.eurekamodel.model.AddPriceRequest;
import com.eureka.model.eurekamodel.model.AddPriceResponse;
import com.eureka.model.eurekamodel.model.GetAccommodationServiceRequest;
import com.eureka.model.eurekamodel.model.GetAccommodationServiceResponse;
import com.eureka.model.eurekamodel.model.GetAccommodationTypeRequest;
import com.eureka.model.eurekamodel.model.GetAccommodationTypeResponse;
import com.eureka.model.eurekamodel.model.Image;
import com.eureka.model.eurekamodel.model.Price;

import xml.accommodation_service.service.AccomodationServiceService;
import xml.accommodation_service.service.AccomodationTypeService;
import xml.accommodation_service.service.AccomodationUnitService;
import xml.accommodation_service.service.ImageService;
import xml.accommodation_service.service.PriceService;

@Endpoint
public class AccommodationUnitEndpoint {

	@Autowired
	AccomodationServiceService service;
	
	@Autowired
	AccomodationTypeService typeService;
	
	@Autowired
	AccomodationUnitService accService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	PriceService priceService;
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "get_accommodation_service_request")
	public GetAccommodationServiceResponse getAccServices(@RequestPayload GetAccommodationServiceRequest request) {
		ArrayList<AccommodationService> services = (ArrayList<AccommodationService>) service.getAll();
		GetAccommodationServiceResponse response = new GetAccommodationServiceResponse();
		response.setAccommodationService(services);
		
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "get_accommodation_type_request")
	public GetAccommodationTypeResponse getAccTypes(@RequestPayload GetAccommodationTypeRequest request) {
		ArrayList<AccommodationType> types = (ArrayList<AccommodationType>) typeService.getAll();
		GetAccommodationTypeResponse response = new GetAccommodationTypeResponse();
		response.setAccommodationType(types);
		
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "add_accommodation_request")
	public AddAccommodationResponse addAccUnit(@RequestPayload AddAccommodationRequest request) {
		Accommodation acc = request.getAccommodation();
		accService.save(acc);
		
		AddAccommodationResponse response = new AddAccommodationResponse();
		response.setAccommodationId(acc.getAccommodationId());
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "add_images_request")
	public AddImagesResponse addImage(@RequestPayload AddImagesRequest request) {
		List<Image> images = request.getImages();
		imageService.save(images);
		
		AddImagesResponse response = new AddImagesResponse();
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "add_price_request")
	public AddPriceResponse addPrice(@RequestPayload AddPriceRequest request) {
		Price price = request.getPrice();
		priceService.save(price);
		AddPriceResponse response = new AddPriceResponse();
		return response;
	}
}
