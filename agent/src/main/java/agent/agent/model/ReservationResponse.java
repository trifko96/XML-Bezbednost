package agent.agent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"reservationId",
	"status"
})
@XmlRootElement(name = "reservation_response")
public class ReservationResponse {
	@XmlElement(required = true)
	private long reservationId;
	@XmlElement(required = true)
	private SoapStatus status;
	
	
	public ReservationResponse() {
		
	}


	public long getReservationId() {
		return reservationId;
	}


	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}


	public SoapStatus getStatus() {
		return status;
	}


	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	
	
	

}
