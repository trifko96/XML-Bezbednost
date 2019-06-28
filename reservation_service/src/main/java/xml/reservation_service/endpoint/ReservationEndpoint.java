package xml.reservation_service.endpoint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eureka.model.eurekamodel.model.ApproveReservationRequest;
import com.eureka.model.eurekamodel.model.ApproveReservationResponse;
import com.eureka.model.eurekamodel.model.GetReservationRequest;
import com.eureka.model.eurekamodel.model.GetReservationResponse;
import com.eureka.model.eurekamodel.model.Reservation;
import com.eureka.model.eurekamodel.model.ReservationRequest;
import com.eureka.model.eurekamodel.model.ReservationResponse;
import com.eureka.model.eurekamodel.model.ReservationStatus;
import com.eureka.model.eurekamodel.model.SoapStatus;

import xml.reservation_service.service.ReservationService;

@Endpoint
public class ReservationEndpoint {

	@Autowired
	ReservationService service;
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "get_reservation_request")
	public GetReservationResponse getReservations(@RequestPayload GetReservationRequest request) {
		ArrayList<Reservation> reservations = (ArrayList<Reservation>) service.getReservations();
		GetReservationResponse response = new GetReservationResponse();
		response.setReservation(reservations);
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/megatravel", localPart = "approve_reservation_request")
	public ApproveReservationResponse approveReservation(@RequestPayload ApproveReservationRequest request) {
		Reservation r = service.getResById(request.getReservationId());
		r.setStatus(ReservationStatus.APPROVED);
		service.save(r);
		ApproveReservationResponse response = new ApproveReservationResponse();
		response.setStatus(SoapStatus.SUCCESS);
		return response;
		
	}
}
