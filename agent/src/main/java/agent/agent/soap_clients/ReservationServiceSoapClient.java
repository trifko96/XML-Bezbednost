package agent.agent.soap_clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import agent.agent.model.ApproveReservationRequest;
import agent.agent.model.ApproveReservationResponse;
import agent.agent.model.GetReservationRequest;
import agent.agent.model.GetReservationResponse;
import agent.agent.model.SoapStatus;

public class ReservationServiceSoapClient extends WebServiceGatewaySupport{

	private static final String SERVICE_URI = "http://localhost:8762/reservation/soap";
	
	public GetReservationResponse getReservations() {
		GetReservationRequest request = new GetReservationRequest();
		GetReservationResponse response = (GetReservationResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
	
	public ApproveReservationResponse approveReservation(long id) {
		ApproveReservationRequest request = new ApproveReservationRequest();
		request.setReservationId(id);
		ApproveReservationResponse response = (ApproveReservationResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
		return response;
	}
}
