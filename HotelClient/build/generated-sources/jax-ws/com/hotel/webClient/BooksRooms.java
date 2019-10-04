
package com.hotel.webClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BooksRooms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BooksRooms">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotel_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customer_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rooms_category_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="no_of_rooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="from_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="to_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BooksRooms", propOrder = {
    "hotelId",
    "customerId",
    "roomsCategoryId",
    "noOfRooms",
    "fromDate",
    "toDate"
})
public class BooksRooms {

    @XmlElement(name = "hotel_id")
    protected int hotelId;
    @XmlElement(name = "customer_id")
    protected int customerId;
    @XmlElement(name = "rooms_category_id")
    protected int roomsCategoryId;
    @XmlElement(name = "no_of_rooms")
    protected int noOfRooms;
    @XmlElement(name = "from_date")
    protected String fromDate;
    @XmlElement(name = "to_date")
    protected String toDate;

    /**
     * Gets the value of the hotelId property.
     * 
     */
    public int getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     */
    public void setHotelId(int value) {
        this.hotelId = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     */
    public void setCustomerId(int value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the roomsCategoryId property.
     * 
     */
    public int getRoomsCategoryId() {
        return roomsCategoryId;
    }

    /**
     * Sets the value of the roomsCategoryId property.
     * 
     */
    public void setRoomsCategoryId(int value) {
        this.roomsCategoryId = value;
    }

    /**
     * Gets the value of the noOfRooms property.
     * 
     */
    public int getNoOfRooms() {
        return noOfRooms;
    }

    /**
     * Sets the value of the noOfRooms property.
     * 
     */
    public void setNoOfRooms(int value) {
        this.noOfRooms = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDate(String value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDate(String value) {
        this.toDate = value;
    }

}
