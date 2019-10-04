/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.dao;

import com.hotel.db.ConnectionPool;
import com.hotel.pogo.family_rooms;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Sdilshan
 */
public class family_rooms_dao {
    private Connection conn;
    private PreparedStatement pStmt;
    
    public family_rooms_dao(){
        conn = ConnectionPool.getConnection();
    }
    
    public int AddFamilyRoom(family_rooms fr){
        int k = 0;
        String insertQuery = "INSERT INTO `family_rooms`(`name`,`hotel_id`) VALUES(?,?)";
        try {
            pStmt = conn.prepareStatement(insertQuery);
            pStmt.setString(1, fr.getName());
            pStmt.setInt(2, fr.getHotel_id());
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
    
    public int DeleteRoomsOfHotel(int hotel_id){
        int k = 0;
        String deleteQuery = "DELETE FROM `family_rooms` WHERE `hotel_id` = ?";
        try {
            pStmt = conn.prepareStatement(deleteQuery);
            pStmt.setInt(1, hotel_id);
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}