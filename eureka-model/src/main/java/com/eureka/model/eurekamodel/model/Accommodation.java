package com.eureka.model.eurekamodel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accommodation", propOrder = {
	"agent",
	"accommodationType",
	"description",
	"accommodationService",
	"category",
	"location",
	"accommodationId",
	"capacity"
})
public class Accommodation {
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAgent", referencedColumnName="userId")
	@XmlElement(required = true)
	private User agent;

	@OneToOne
	@JoinColumn(name = "accomodation_type_id")
	@XmlElement(required = true)
	private AccommodationType accommodationType;
	
	@XmlElement(required = true)
	private String description;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ACCOMMODATION_SERVICE_UNIT", 
			joinColumns= {@JoinColumn(name="accommodationId")},
			inverseJoinColumns= {@JoinColumn(name="accommodationServiceId")})
	@XmlElement(required = true)
	private List<AccommodationService> accommodationService;
	
	@XmlElement(required = true)
	private int category;
	

    @OneToOne
	@JoinColumn(name = "location_id")
    @XmlElement(required = true)
    private Location location;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true)
    private long accommodationId;
	
    @XmlElement(required = true)
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	public User getAgent() {
		return agent;
	}

	public void setAgent(User agent) {
		this.agent = agent;
	}
	
	
	

}
