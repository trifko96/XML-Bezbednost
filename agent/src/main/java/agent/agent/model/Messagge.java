package agent.agent.model;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messagge", propOrder = {
	"id",
	"send",
	"receive",
	"content",
	"date"
})
public class Messagge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userSend", referencedColumnName="userId")
	@XmlElement(required = true)
	private User send;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userReceive", referencedColumnName="userId")
	@XmlElement(required = true)
	private User receive;
	
	@XmlElement(required = true)
	private String content;
	
	@XmlElement(required = true)
	private Date date; 
	
	public Messagge() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getSend() {
		return send;
	}

	public void setSend(User send) {
		this.send = send;
	}

	public User getReceive() {
		return receive;
	}

	public void setReceive(User receive) {
		this.receive = receive;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
