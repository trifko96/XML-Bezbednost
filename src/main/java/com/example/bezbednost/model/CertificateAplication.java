package com.example.bezbednost.model;

public class CertificateAplication extends Certificate{
	
	private String nazivAplikacije;
	private String nazivOrganizacije;
	private String verzija;
	
	public CertificateAplication() {
		super();
	}
	
	public CertificateAplication(String nazivAplikacije, String nazivOrganizacije, String verzija) {
		super();
		this.nazivAplikacije = nazivAplikacije;
		this.nazivOrganizacije = nazivOrganizacije;
		this.verzija = verzija;
	}
	
	public String getNazivAplikacije() {
		return nazivAplikacije;
	}
	public void setNazivAplikacije(String nazivAplikacije) {
		this.nazivAplikacije = nazivAplikacije;
	}
	public String getNazivOrganizacije() {
		return nazivOrganizacije;
	}
	public void setNazivOrganizacije(String nazivOrganizacije) {
		this.nazivOrganizacije = nazivOrganizacije;
	}
	public String getVerzija() {
		return verzija;
	}
	public void setVerzija(String verzija) {
		this.verzija = verzija;
	}
	
}
