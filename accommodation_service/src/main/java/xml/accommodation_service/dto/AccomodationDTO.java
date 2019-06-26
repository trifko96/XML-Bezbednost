package xml.accommodation_service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eureka.model.eurekamodel.model.Accommodation;
import com.eureka.model.eurekamodel.model.AccommodationService;
import com.eureka.model.eurekamodel.model.AccommodationType;
import com.eureka.model.eurekamodel.model.Location;

public class AccomodationDTO {

	private AccommodationType accommodationType;
	private String description;
	private List<AccommodationService> accommodationService;
	private int category;
	private Location location;
	private long accommodationId;
	private int capacity;
	private String name;
	private Date fromDate;
	private Date toDate;
	private int cancelingPeriod;
	
	public AccomodationDTO() {}
	
	public AccomodationDTO(Accommodation acc) {
		this.accommodationType = acc.getAccommodationType();
		this.description = acc.getDescription();
		this.category = acc.getCategory();
		this.location = acc.getLocation();
		this.accommodationId = acc.getAccommodationId();
		this.capacity = acc.getCapacity();
		this.name = acc.getName();
		this.cancelingPeriod = acc.getCancelingPeriod();
		this.accommodationService = new ArrayList<>();
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

	public List<AccommodationService> getAccommodationService() {
		return accommodationService;
	}

	public void setAccommodationService(List<AccommodationService> accommodationService) {
		this.accommodationService = accommodationService;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
}
