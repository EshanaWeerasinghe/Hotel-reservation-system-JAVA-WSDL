/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.dao;

import com.hotel.db.ConnectionPool;
import com.hotel.pogo.double_rooms;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Sdilshan
 */
public class double_rooms_dao {
    private Connection conn;
    private PreparedStatement pStmt;
    
    public double_rooms_dao(){
        conn = ConnectionPool.getConnection();
    }
    
    public int AddDoubleRoom(double_rooms dr){
        int k = 0;
        String InsertQuery = "INSERT INTO `double_rooms`(`name`,`hotel_id`) VALUES(?,?)";
        try {
            pStmt = conn.prepareStatement(InsertQuery);
            pStmt.setString(1, dr.getName());
            pStmt.setInt(2, dr.getHotel_id());
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
    
    public int DeleteRoomsOfHotel(int hotel_id){
        int k = 0;
        String DeleteQuery = "DELETE FROM `double_rooms` WHERE `hotel_id` = ?";
        try {
            pStmt = conn.prepareStatement(DeleteQuery);
            pStmt.setInt(1, hotel_id);
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
