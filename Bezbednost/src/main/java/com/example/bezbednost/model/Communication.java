package com.example.bezbednost.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Communication {

	@Id
	@GeneratedValue
	private Long id;
	private Long certificate1;
	private Long certificate2;
	
	public Communication() {
		
	}

	public Communication(Long certificate1, Long certificate2) {
		super();
		this.certificate1 = certificate1;
		this.certificate2 = certificate2;
	}

	public Long getCertificate1() {
		return certificate1;
	}

	public void setCertificate1(Long certificate1) {
		this.certificate1 = certificate1;
	}

	public Long getCertificate2() {
		return certificate2;
	}

	public void setCertificate2(Long certificate2) {
		this.certificate2 = certificate2;
	}
	
	
}
