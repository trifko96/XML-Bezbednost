package agent.agent.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"messagge"
})
@XmlRootElement(name = "get_message_response")
public class GetMessaggeResponse {

	@XmlElement(required = true)
	private List<Messagge> messagge;
	
	public GetMessaggeResponse () {
		
	}

	public List<Messagge> getMessagge() {
		return messagge;
	}

	public void setMessagge(List<Messagge> messagge) {
		this.messagge = messagge;
	}
	
	
	
}
