package com.example.bezbednost.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Certificates")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="idNadSertifikata")
	private Long idNadSertifikata;
	
	@Column(name="datumIzdavanja", nullable = false)
	private Date datumIzdavanja;
	
	@Column(name="datumIsteka", nullable = false)
	private Date datumIsteka;
	
	@Column(name="povucen")
	private boolean revoked;
	
	@Column(name="korenski")
	private boolean root;
	
	@Column(name="dozvolaZaIzdavanje")
	private boolean authority;
	
	
	public Certificate() {
		super();
	}

	public Certificate(Long id, Long idNadSertifikata, Date datumIzdavanja, Date datumIsteka, boolean revoked,
			boolean root, boolean authority) {
		super();
		this.id = id;
		this.idNadSertifikata = idNadSertifikata;
		this.datumIzdavanja = datumIzdavanja;
		this.datumIsteka = datumIsteka;
		this.revoked = revoked;
		this.root = root;
		this.authority = authority;
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

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public boolean isAuthority() {
		return authority;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}
}
