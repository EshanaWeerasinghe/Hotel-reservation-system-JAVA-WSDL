/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.dao;

import com.hotel.db.ConnectionPool;
import com.hotel.pogo.customer;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Sdilshan
 */
public class customerdao {
    private Connection conn;
    private PreparedStatement pStmt;
    
    public customerdao(){
        conn = ConnectionPool.getConnection();
    }
    
    public int AddCustomer(customer cs){
        int k = 0;
        String InsertQuery = "INSERT INTO `customer`(`first_name`,`last_name`,`mobile`,`email`,`username`,`password`) VALUES(?,?,?,?,?,?)";
        try {
            pStmt = conn.prepareStatement(InsertQuery);
            pStmt.setString(1, cs.getFirstName());
            pStmt.setString(2, cs.getLastName());
            pStmt.setString(3, cs.getMobile());
            pStmt.setString(4, cs.getEmail());
            pStmt.setString(5, cs.getUsername());
            pStmt.setString(6, cs.getPassword());
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
