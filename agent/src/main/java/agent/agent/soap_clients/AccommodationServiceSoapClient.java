package agent.agent.soap_clients;

import java.util.List;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import agent.agent.model.Accommodation;
import agent.agent.model.AddAccommodationRequest;
import agent.agent.model.AddAccommodationResponse;
import agent.agent.model.AddImagesRequest;
import agent.agent.model.AddImagesResponse;
import agent.agent.model.AddPriceRequest;
import agent.agent.model.AddPriceResponse;
import agent.agent.model.GetAccommodationServiceRequest;
import agent.agent.model.GetAccommodationServiceResponse;
import agent.agent.model.GetAccommodationTypeRequest;
import agent.agent.model.GetAccommodationTypeResponse;
import agent.agent.model.Image;
import agent.agent.model.Price;

public class AccommodationServiceSoapClient extends WebServiceGatewaySupport{

	private static final String SERVICE_URI = "http://localhost:8762/accomodation/soap";
	
	public GetAccommodationServiceResponse getAccServices() {
		GetAccommodationServiceRequest request = new GetAccommodationServiceRequest();
		GetAccommodationServiceResponse response = (GetAccommodationServiceResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
	
	public GetAccommodationTypeResponse getAccTypes() {
		GetAccommodationTypeRequest request = new GetAccommodationTypeRequest();
		GetAccommodationTypeResponse response = (GetAccommodationTypeResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
	
	public AddAccommodationResponse addAccUnit(Accommodation acc) {
		AddAccommodationRequest request = new AddAccommodationRequest();
		request.setAccommodation(acc);
		AddAccommodationResponse response = (AddAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
	
	public AddPriceResponse addPrice(Price price) {
		AddPriceRequest request = new AddPriceRequest();
		request.setPrice(price);
		AddPriceResponse response = (AddPriceResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
	
	public AddImagesResponse addImages(List<Image> images) {
		AddImagesRequest request = new AddImagesRequest();
		request.setImages(images);
		AddImagesResponse response = (AddImagesResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
}
