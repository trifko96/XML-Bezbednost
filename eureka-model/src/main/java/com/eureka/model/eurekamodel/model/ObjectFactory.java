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
}
