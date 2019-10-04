
package com.hotel.webClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetHotelRoomsAvailability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetHotelRoomsAvailability">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotel_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rooms_category_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetHotelRoomsAvailability", propOrder = {
    "hotelId",
    "roomsCategoryId"
})
public class GetHotelRoomsAvailability {

    @XmlElement(name = "hotel_id")
    protected int hotelId;
    @XmlElement(name = "rooms_category_id")
    protected int roomsCategoryId;

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

}
