package com.eureka.model.eurekamodel.model;

public class ObjectFactory {

	public ObjectFactory () {
		
	}
	
	public Accommodation createAccommodation() {
		return new Accommodation();
	}
	
	public AccommodationType createAccommodationType() {
		return new AccommodationType();
	}
	
	public AccommodationService createAccommodationService() {
		return new AccommodationService();
	}
	
	public Location createLocation() {
		return new Location();
	}
	
	public Messagge createMessagge() {
		return new Messagge();
	}
	
	public Price createPrice() {
		return new Price();
	}
	
	public Rating createRating() {
		return new Rating();
	}
	
	public Recension createRecension() {
		return new Recension();
	}
	
	public Reservation createReservation() {
		return new Reservation();
	}
	
	public User createUser() {
		return new User();
	}
	
	public AddAccommodationRequest createAddAccommodationRequest() {
		return new AddAccommodationRequest();
	}
	
	public AddAccommodationResponse createAddAccommodationResponse() {
		return new AddAccommodationResponse();
	}
	
	public ApproveReservationRequest createApproveReservationRequest() {
		return new ApproveReservationRequest();
	}
		
	public ApproveReservationResponse createApproveReservationResponse() {
		return new ApproveReservationResponse();
	}
	
	public GetAccommodationServiceRequest createAccommodationServiceRequest() {
		return new GetAccommodationServiceRequest();
	}
	
	public GetAccommodationServiceResponse createAccommodationServiceResponse() {
		return new GetAccommodationServiceResponse();
	}
	
	public GetAccommodationTypeRequest createAccommodationTypeRequest() {
		return new GetAccommodationTypeRequest();
	}
	
	public GetAccommodationTypeResponse createGetAccommodationTypeResponse() {
		return new GetAccommodationTypeResponse();
	}
	
	public GetAgentRequest createAgentRequest() {
		return new GetAgentRequest();
	}
	
	public GetAgentResponse createAgentResponse() {
		return new GetAgentResponse();
	}
	
	public GetMessaggeRequest createGetMessaggeRequest() {
		return new GetMessaggeRequest();
	}
	
	public GetMessaggeResponse createGetMessaggeResponse() {
		return new GetMessaggeResponse();
	}
	
	public GetRecensionRequest createGetRecensionRequest() {
		return new GetRecensionRequest();
	}
	
	public GetRecensionResponse createGetRecensionResponse() {
		return new GetRecensionResponse();
	}
	
	public GetReservationRequest createGetReservationRequest() {
		return new GetReservationRequest();
	}
	
	public GetReservationResponse createGetReservationResponse() {
		return new GetReservationResponse();
	}
	
	public MessaggeRequest createMessaggeRequest() {
		return new MessaggeRequest();
	}
	
	public MessaggeResponse createMessaggeResponse() {
		return new MessaggeResponse();
	}
	
	public ReservationRequest createReservationRequest() {
		return new ReservationRequest();
	}
	
	public ReservationResponse createReservationResponse() {
		return new ReservationResponse();
	}
}
