package com.eureka.model.eurekamodel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Accommodation {

	@OneToOne
	@JoinColumn(name = "accomodation_type_id")
	private AccommodationType accommodationType;
	
	private String description;

	@OneToMany(mappedBy = "accomodation", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<Rating> rating;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ACCOMMODATION_SERVICE", 
			joinColumns= {@JoinColumn(name="accommodationId")},
			inverseJoinColumns= {@JoinColumn(name="accommodationServiceId")})
	private List<AccommodationService> accommodationService;
	
	private int category;
	
	@OneToMany(mappedBy = "accommodation", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Recension> recension;
	

    @OneToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@OneToMany(mappedBy = "accommodation", orphanRemoval = true, cascade = CascadeType.ALL )
	private List<Price> price;
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accommodationId;
	
	private int capacity;
	
	public Accommodation() {
		
	}

	public AccommodationType getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(AccommodationType accommodationType) {
		this.accommodationType = accommodationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Rating> getRating() {
		if (rating == null) {
            rating = new ArrayList<Rating>();
        }
        return this.rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public List<AccommodationService> getAccommodationService() {
		if (accommodationService == null) {
            accommodationService = new ArrayList<AccommodationService>();
        }
        return this.accommodationService;
	}

	public void setAccommodationService(List<AccommodationService> accommodationService) {
		this.accommodationService = accommodationService;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public List<Recension> getRecension() {
		if (recension == null) {
            recension = new ArrayList<Recension>();
        }
        return this.recension;
	}

	public void setRecension(List<Recension> recension) {
		this.recension = recension;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Price> getPrice() {
		if (price == null) {
            price = new ArrayList<Price>();
        }
        return this.price;
	}

	public void setPrice(List<Price> price) {
		this.price = price;
	}

	public long getAccommodationId() {
		return accommodationId;
	}

	public void setAccommodationId(long accommodationId) {
		this.accommodationId = accommodationId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	

}
