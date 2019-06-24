package xml.reservation_service.dto;

import java.util.Date;

import com.eureka.model.eurekamodel.model.Reservation;
import com.eureka.model.eurekamodel.model.ReservationStatus;

public class ReservationDTO {

	private long id;
	private String accommodationName;
	private long accommodationId;
	private Date fromDate;
	private Date toDate;
	private ReservationStatus status;
	
	public ReservationDTO() {}
	
	public ReservationDTO(Reservation r) {
		this.id = r.getId();
		this.accommodationName = r.getAccommodation().getName();
		this.accommodationId = r.getAccommodation().getAccommodationId();
		this.fromDate = r.getFromDate();
		this.toDate = r.getToDate();
		this.status = r.getStatus();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public long getAccommodationId() {
		return accommodationId;
	}

	public void setAccommodationId(long accommodationId) {
		this.accommodationId = accommodationId;
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

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
	
	
}
