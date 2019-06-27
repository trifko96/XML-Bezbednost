//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.27 at 07:05:16 PM CEST 
//


package agent.agent.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recensionStatus" type="{http://www.ftn.uns.ac.rs/megatravel}recension_status"/>
 *         &lt;element name="user" type="{http://www.ftn.uns.ac.rs/megatravel}user"/>
 *         &lt;element name="accommodation" type="{http://www.ftn.uns.ac.rs/megatravel}accommodation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recension", propOrder = {
    "id",
    "value",
    "recensionStatus",
    "user",
    "accommodation"
})
public class Recension {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    
    @XmlElement(required = true)
    protected String value;
    
    @XmlElement(required = true)
    protected RecensionStatus recensionStatus;
    
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUser", referencedColumnName="userId")
    @XmlElement(required = true)
    protected User user;
    
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAccommodation", referencedColumnName="accommodationId")
    @XmlElement(required = true)
    protected Accommodation accommodation;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the recensionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RecensionStatus }
     *     
     */
    public RecensionStatus getRecensionStatus() {
        return recensionStatus;
    }

    /**
     * Sets the value of the recensionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecensionStatus }
     *     
     */
    public void setRecensionStatus(RecensionStatus value) {
        this.recensionStatus = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the accommodation property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation }
     *     
     */
    public Accommodation getAccommodation() {
        return accommodation;
    }

    /**
     * Sets the value of the accommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation }
     *     
     */
    public void setAccommodation(Accommodation value) {
        this.accommodation = value;
    }

}
