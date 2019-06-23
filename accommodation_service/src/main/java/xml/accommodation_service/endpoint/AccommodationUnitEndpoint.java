package xml.accommodation_service.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eureka.model.eurekamodel.model.AccommodationService;
import com.eureka.model.eurekamodel.model.AccommodationType;
import com.eureka.model.eurekamodel.model.GetAccommodationServiceRequest;
import com.eureka.model.eurekamodel.model.GetAccommodationServiceResponse;
import com.eureka.model.eurekamodel.model.GetAccommodationTypeRequest;
import com.eureka.model.eurekamodel.model.GetAccommodationTypeResponse;

import xml.accommodation_service.service.AccomodationServiceService;
import xml.accommodation_service.service.AccomodationTypeService;

@Endpoint
public class AccommodationUnitEndpoint {

	@Autowired
	AccomodationServiceService service;
	
	@Autowired
	AccomodationTypeService typeService;
	
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
	
	
}
