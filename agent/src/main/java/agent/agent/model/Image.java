package agent.agent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "image", propOrder = {
	"id",
	"name",
	"type",
	"code",
	"accommodation"
})
public class Image {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true)
    private long id;
	
	@XmlElement(required = true)
	private String name;
	
	@XmlElement(required = true)
	private String type;
	
	@Lob
	@XmlElement(required = true)
	private byte[] code;
	
	@ManyToOne
	@JoinColumn(name="accommodationId", referencedColumnName="accommodationId")
	@XmlElement(required = true)
	private Accommodation accommodation;
	
	public Image() {}
	
	public Image(long id, String name, String type, byte[] code) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.code = code;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getCode() {
		return code;
	}

	public void setCode(byte[] code) {
		this.code = code;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
	
	
}
