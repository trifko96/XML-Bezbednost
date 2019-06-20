package agent.agent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"status",
	"accommodationId"
})

@XmlRootElement(name = "add_accommodation_response")
public class AddAccommodationResponse {

	@XmlElement(required = true)
	private SoapStatus status;
	
	@XmlElement(required = true)
	private long accommodationId;
	
	
	public AddAccommodationResponse() {
		
	}
	
	
	public SoapStatus getStatus() {
		return status;
	}
	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	public long getAccommodationId() {
		return accommodationId;
	}
	public void setAccommodationId(long accommodationId) {
		this.accommodationId = accommodationId;
	}
	
	
}
