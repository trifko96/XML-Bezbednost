package xml.messagge_service.dto;

import com.eureka.model.eurekamodel.model.Messagge;

public class MessaggeDTO {

	private long id;
	private String content;
	private String accommodationName;
	private String agentS;
	private String agentR;
	
	public MessaggeDTO() {}
	
	public MessaggeDTO(Messagge m) {
		this.id = m.getId();
		this.content = m.getContent();
		this.agentS = m.getSend().getUsername();
		this.agentR = m.getReceive().getUsername();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public String getAgentS() {
		return agentS;
	}

	public void setAgentS(String agentS) {
		this.agentS = agentS;
	}

	public String getAgentR() {
		return agentR;
	}

	public void setAgentR(String agentR) {
		this.agentR = agentR;
	}
	
	
}
