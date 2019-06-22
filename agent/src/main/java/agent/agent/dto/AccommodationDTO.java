package agent.agent.dto;

import java.util.ArrayList;

import agent.agent.model.Accommodation;
import agent.agent.model.AccommodationStatus;
import agent.agent.model.AccommodationType;
import agent.agent.model.Location;

public class AccommodationDTO {

	private AccommodationType accommodationType;
	private String description;
	private int category;
	private Location location;
	private long accommodationId;
	private int capacity;
	private String name;
	private int cancelingPeriod;
	private ArrayList<String> images;
	private AccommodationStatus status;
	
	public AccommodationDTO() {}
	
	public AccommodationDTO(Accommodation acc) {
		this.accommodationType = acc.getAccommodationType();
		this.description = acc.getDescription();
		this.category = acc.getCategory();
		this.location = acc.getLocation();
		this.accommodationId = acc.getAccommodationId();
		this.capacity = acc.getCapacity();
		this.name = acc.getName();
		this.cancelingPeriod = acc.getCancelingPeriod();
		this.images = new ArrayList<>();
		this.status = acc.getStatus();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCancelingPeriod() {
		return cancelingPeriod;
	}

	public void setCancelingPeriod(int cancelingPeriod) {
		this.cancelingPeriod = cancelingPeriod;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public AccommodationStatus getStatus() {
		return status;
	}

	public void setStatus(AccommodationStatus status) {
		this.status = status;
	}
	
	
}
