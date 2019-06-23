package agent.agent.soap_clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import agent.agent.model.GetAccommodationServiceRequest;
import agent.agent.model.GetAccommodationServiceResponse;
import agent.agent.model.GetAccommodationTypeRequest;
import agent.agent.model.GetAccommodationTypeResponse;

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
}
