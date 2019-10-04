/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.register;

/**
 *
 * @author Sdilshan
 */
public class hotel {
    private int id;
    private String name;
    private String location;
    private int no_of_single_rooms;
    private int no_of_double_rooms;
    private int no_of_family_rooms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNo_of_single_rooms() {
        return no_of_single_rooms;
    }

    public void setNo_of_single_rooms(int no_of_single_rooms) {
        this.no_of_single_rooms = no_of_single_rooms;
    }

    public int getNo_of_double_rooms() {
        return no_of_double_rooms;
    }

    public void setNo_of_double_rooms(int no_of_double_rooms) {
        this.no_of_double_rooms = no_of_double_rooms;
    }

    public int getNo_of_family_rooms() {
        return no_of_family_rooms;
    }

    public void setNo_of_family_rooms(int no_of_family_rooms) {
        this.no_of_family_rooms = no_of_family_rooms;
    }
}
