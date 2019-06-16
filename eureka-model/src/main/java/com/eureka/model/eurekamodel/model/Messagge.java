package com.eureka.model.eurekamodel.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Messagge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userSend", referencedColumnName="userId")
	private User send;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userReceive", referencedColumnName="userId")
	private User receive;
	
	private String content;
	
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
