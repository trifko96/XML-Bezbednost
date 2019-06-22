package agent.agent.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location", propOrder= {
	"id",
	"longitude",
	"lattitude",
	"name"
})
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private long id;
	
	@XmlElement(required = true)
	private float longitude;
	
	@XmlElement(required = true)
	private float lattitude;
	
	@XmlElement(required = true)
	private String name;
	
	
	public Location() {
		
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLattitude() {
		return lattitude;
	}

	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
