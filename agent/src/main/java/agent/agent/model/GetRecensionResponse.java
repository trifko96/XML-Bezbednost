package agent.agent.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"recension"
})

@XmlRootElement(name = "get_recension_response")
public class GetRecensionResponse {
	
	@XmlElement(required = true)
	private List<Recension> recension;
	
	public GetRecensionResponse () {
		
	}

	public List<Recension> getRecension() {
		return recension;
	}

	public void setRecension(List<Recension> recension) {
		this.recension = recension;
	}
	
	

}
