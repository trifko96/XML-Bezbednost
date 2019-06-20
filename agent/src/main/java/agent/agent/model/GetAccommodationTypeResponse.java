package agent.agent.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"accommodationType"
})
@XmlRootElement(name = "get_accommodation_type_response")
public class GetAccommodationTypeResponse {

	@XmlElement(required = true)
	private ArrayList<AccommodationType> accommodationType;
	
	
	public GetAccommodationTypeResponse() {
		
	}


	public ArrayList<AccommodationType> getAccommodationType() {
		return accommodationType;
	}


	public void setAccommodationType(ArrayList<AccommodationType> accommodationType) {
		this.accommodationType = accommodationType;
	}
	
	
	
}
