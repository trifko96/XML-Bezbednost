package agent.agent.dto;

import agent.agent.model.Messagge;

public class MessaggeDTO {

	private long id;
	private String content;
	private String userName;
	private String agentName;
	
	public MessaggeDTO() {
	
	}
	
	public MessaggeDTO(Messagge m) {
		this.id = m.getId();
		this.content = m.getContent();
		this.userName = m.getSend().getUsername();
		this.agentName = m.getReceive().getUsername();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	
}
