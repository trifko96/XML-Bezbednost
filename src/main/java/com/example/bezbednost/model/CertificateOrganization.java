package com.example.bezbednost.model;

public class CertificateOrganization extends Certificate{
	
	private String drzava;
	private String nazivOrganizacije;
	private String PTT;
	private String adresa;
	
	public CertificateOrganization() {
		super();
	}
	
	public CertificateOrganization(String drzava, String nazivOrganizacije, String pTT, String adresa) {
		super();
		this.drzava = drzava;
		this.nazivOrganizacije = nazivOrganizacije;
		PTT = pTT;
		this.adresa = adresa;
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
	public String getPTT() {
		return PTT;
	}
	public void setPTT(String pTT) {
		PTT = pTT;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
}
