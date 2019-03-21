package com.example.bezbednost.dto;

import java.util.Date;

import com.example.bezbednost.model.Certificate;

public class CertificateDTO {
	
	private Long id;
	private Long idNadSertifikata;
	private Date datumIzdavanja;
	private Date datumIsteka;
	private boolean revoked;
	
	public CertificateDTO(Certificate c) {
		super();
		this.id = c.getId();
		this.idNadSertifikata = c.getIdNadSertifikata();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdNadSertifikata() {
		return idNadSertifikata;
	}
	public void setIdNadSertifikata(Long idNadSertifikata) {
		this.idNadSertifikata = idNadSertifikata;
	}
	public Date getDatumIzdavanja() {
		return datumIzdavanja;
	}
	public void setDatumIzdavanja(Date datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}
	public Date getDatumIsteka() {
		return datumIsteka;
	}
	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}
	public boolean isRevoked() {
		return revoked;
	}
	public void setRevoked(boolean revoked) {
		this.revoked = revoked;
	}
	
	
}
