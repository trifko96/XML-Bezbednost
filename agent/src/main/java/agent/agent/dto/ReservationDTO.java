package agent.agent.dto;

import java.util.Date;

import agent.agent.model.Reservation;
import agent.agent.model.ReservationStatus;

public class ReservationDTO {

	private long id;
	private String accName;
	private String username;
	private Date fromDate;
	private Date toDate;
	private ReservationStatus status;
	
	public ReservationDTO() {}
	
	public ReservationDTO(Reservation r) {
		this.id = r.getId();
		this.accName = r.getAccommodation().getName();
		this.username = r.getUser().getUsername();
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

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
