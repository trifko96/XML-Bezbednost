package com.example.bezbednost.model;

import com.example.bezbednost.dto.CertificateDTO;

public class CertificateEquipment extends Certificate{
	
	private String mac;
	private String nazivOpreme;
	private String drzava;
	private String nazivOrganizacije;
	private String idOpreme;
	
	public CertificateEquipment() {
		super();
	}

	public CertificateEquipment(String mac, String nazivOpreme, String drzava, String nazivOrganizacije,
			String idOpreme) {
		super();
		this.nazivOpreme = nazivOpreme;
		this.drzava = drzava;
		this.nazivOrganizacije = nazivOrganizacije;
		this.idOpreme = idOpreme;
		this.mac = mac;
	}

	public CertificateEquipment(CertificateDTO c) {
		super(c.getId(), c.getNadSertifikatId(), c.getDatumIzdavanja(), c.getDatumIsteka(), c.isRevoked(), c.isRoot(), c.isAuthority(), c.getTip(), c.getNazivOrganizacije());
		this.nazivOpreme = c.getNazivOpreme();
		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.idOpreme = c.getIdOpreme();
		this.mac = c.getMac();
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getNazivOpreme() {
		return nazivOpreme;
	}
	public void setNazivOpreme(String nazivOpreme) {
		this.nazivOpreme = nazivOpreme;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getNazivOrganizacije() {
		return nazivOrganizacije;
	}
	public void setNazivOrganizacije(String nazivOrganizacije) {
		this.nazivOrganizacije = nazivOrganizacije;
	}
	public String getIdOpreme() {
		return idOpreme;
	}
	public void setIdOpreme(String idOpreme) {
		this.idOpreme = idOpreme;
	}
}
