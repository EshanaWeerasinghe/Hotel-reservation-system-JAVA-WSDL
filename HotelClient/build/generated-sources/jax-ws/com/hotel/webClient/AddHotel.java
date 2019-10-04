
package com.hotel.webClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddHotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="No_Of_Single_Rooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="No_Of_Double_Rooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="No_Of_Family_Rooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddHotel", propOrder = {
    "name",
    "location",
    "noOfSingleRooms",
    "noOfDoubleRooms",
    "noOfFamilyRooms"
})
public class AddHotel {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "No_Of_Single_Rooms")
    protected int noOfSingleRooms;
    @XmlElement(name = "No_Of_Double_Rooms")
    protected int noOfDoubleRooms;
    @XmlElement(name = "No_Of_Family_Rooms")
    protected int noOfFamilyRooms;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the noOfSingleRooms property.
     * 
     */
    public int getNoOfSingleRooms() {
        return noOfSingleRooms;
    }

    /**
     * Sets the value of the noOfSingleRooms property.
     * 
     */
    public void setNoOfSingleRooms(int value) {
        this.noOfSingleRooms = value;
    }

    /**
     * Gets the value of the noOfDoubleRooms property.
     * 
     */
    public int getNoOfDoubleRooms() {
        return noOfDoubleRooms;
    }

    /**
     * Sets the value of the noOfDoubleRooms property.
     * 
     */
    public void setNoOfDoubleRooms(int value) {
        this.noOfDoubleRooms = value;
    }

    /**
     * Gets the value of the noOfFamilyRooms property.
     * 
     */
    public int getNoOfFamilyRooms() {
        return noOfFamilyRooms;
    }

    /**
     * Sets the value of the noOfFamilyRooms property.
     * 
     */
    public void setNoOfFamilyRooms(int value) {
        this.noOfFamilyRooms = value;
    }

}
