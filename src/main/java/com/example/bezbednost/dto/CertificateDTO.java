package com.example.bezbednost.dto;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;

import com.example.bezbednost.model.Certificate;
import com.example.bezbednost.model.CertificateAplication;
import com.example.bezbednost.model.CertificateEquipment;
import com.example.bezbednost.model.CertificateOrganization;
import com.example.bezbednost.model.CertificatePerson;
import com.example.bezbednost.model.CertificateRoot;
import com.example.bezbednost.model.CertificateType;

public class CertificateDTO {
	
	private Long id;
	
	//private X500Name naziv;
	private Long nadSertifikatId;
	private PublicKey publicKey;
	private Date datumIzdavanja;
	private Date datumIsteka;
	private boolean revoked;
	private boolean root;
	private boolean authority;
	private CertificateType tip;
	private String nazivOrganizacije;
	
	//Root
	//...
	
	//Person
	private String ime;
	private String prezime;
	private String drzava;
	private String email;
	
	//Organization
	//private String drzava;
	private String PTT;
	private String adresa;
	
	//Aplication
	private String nazivAplikacije;
	private String verzija;
	
	//Equipment
	private String MAC;
	private String nazivOpreme;
	//private String drzava;
	private String idOpreme;
	
	public CertificateDTO() {
		
	}	
	
	public CertificateDTO(Certificate c) {
		this.id = c.getId();
		//this.naziv = c.getNaziv();
		//this.nadSertifikat = c.getNadSertifikat();
		this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
	}

	public CertificateDTO(CertificateRoot c) {
		this.id = c.getId();
		//this.naziv = c.getNaziv();
		//this.nadSertifikat = c.getNadSertifikat();
		this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
		
		this.nazivOrganizacije = c.getNazivOrganizacije();
	}
	
	public CertificateDTO(CertificatePerson c) {
		this.id = c.getId();
		//this.naziv = c.getNaziv();
		//this.nadSertifikat = c.getNadSertifikat();
		this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
		
		this.ime = c.getIme();
		this.prezime = c.getPrezime();
		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.email = c.getEmail();
	}
	
	public CertificateDTO(CertificateOrganization c) {
		this.id = c.getId();
		//this.naziv = c.getNaziv();
		//this.nadSertifikat = c.getNadSertifikat();
		this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();

		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.PTT = c.getPTT();
		this.adresa = c.getAdresa();
	}
	
	public CertificateDTO(CertificateAplication c) {
		this.id = c.getId();
		//this.naziv = c.getNaziv();
		//this.nadSertifikat = c.getNadSertifikat();
		this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();

		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.nazivAplikacije = c.getNazivAplikacije();
		this.verzija = c.getVerzija();
	}
	
	public CertificateDTO(CertificateEquipment c) {
		super();
		this.id = c.getId();
		//this.naziv = c.getNaziv();
		//this.nadSertifikat = c.getNadSertifikat();
		this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
		
		this.MAC = c.getMAC();
		this.nazivOpreme = c.getNazivOpreme();
		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.idOpreme = c.getIdOpreme();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNadSertifikatId() {
		return nadSertifikatId;
	}
	public void setNadSertifikatId(Long nadSertifikatId) {
		this.nadSertifikatId = nadSertifikatId;
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

//	public X500Name getNaziv() {
//		return naziv;
//	}
//
//	public void setNaziv(X500Name naziv) {
//		this.naziv = naziv;
//	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
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

	public CertificateType getTip() {
		return tip;
	}

	public void setTip(CertificateType tip) {
		this.tip = tip;
	}

	public String getNazivOrganizacije() {
		return nazivOrganizacije;
	}

	public void setNazivOrganizacije(String nazivOrganizacije) {
		this.nazivOrganizacije = nazivOrganizacije;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNazivAplikacije() {
		return nazivAplikacije;
	}

	public void setNazivAplikacije(String nazivAplikacije) {
		this.nazivAplikacije = nazivAplikacije;
	}

	public String getVerzija() {
		return verzija;
	}

	public void setVerzija(String verzija) {
		this.verzija = verzija;
	}

	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}

	public String getNazivOpreme() {
		return nazivOpreme;
	}

	public void setNazivOpreme(String nazivOpreme) {
		this.nazivOpreme = nazivOpreme;
	}

	public String getIdOpreme() {
		return idOpreme;
	}

	public void setIdOpreme(String idOpreme) {
		this.idOpreme = idOpreme;
	}
	
}
