/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.pogo;

/**
 *
 * @author Sdilshan
 */
public class hotel_rooms {
    private int id;
    private int hotel_id;
    private int rooms_category_id;
    private int no_of_rooms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRooms_category_id() {
        return rooms_category_id;
    }

    public void setRooms_category_id(int hotel_category_id) {
        this.rooms_category_id = hotel_category_id;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }
}
