/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.controller;

import com.hotel.db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Sdilshan
 */
public class LoginController {

    private Connection conn;
    private PreparedStatement pStmt;

    public LoginController() {
        conn = ConnectionPool.getConnection();
    }

    public String getLogin(String username, String password) {
        String returnValue = "";
        String selectQuery = "SELECT `idemployee`,`first_name`,`last_name`,`nic`,`address_line1`,`address_line2`,`address_city`,`address_postalcode`,`mobile`,`user_name`,`password`,`emp_category_id`,`hotel_id` FROM `employee` WHERE `user_name` = ? AND `password` = ?";
        try {
            pStmt = conn.prepareStatement(selectQuery);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                //authentication:empId:firstName:lastName:nic:addressl1:addressl2:addressCity:addressPC:mobile:userName:passWord:emp_category_id:hotel_id
                returnValue = "true"+"%"+String.valueOf(rs.getInt("idemployee"))+"%"+rs.getString("first_name")+"%"+rs.getString("last_name")+"%"+rs.getString("nic")+"%"+rs.getString("address_line1")+"%"+rs.getString("address_line2")+"%"+rs.getString("address_city")+"%"+rs.getString("address_postalcode")+"%"+rs.getString("mobile")+"%"+rs.getString("user_name")+"%"+rs.getString("password")+"%"+String.valueOf(rs.getInt("emp_category_id"))+"%"+String.valueOf(rs.getInt("hotel_id"));
            } else {
                returnValue = "false"+"%"+"null";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public String customerLogin(String userName, String passWord){
        String returnValue = null;
        String SelectQuery = "SELECT `id`,`first_name`,`last_name`,`mobile`,`email`,`username`,`password` FROM `customer` WHERE `username` = ? AND `password` = ?";
        try {
            pStmt = conn.prepareStatement(SelectQuery);
            pStmt.setString(1, userName);
            pStmt.setString(2, passWord);
            ResultSet rs = pStmt.executeQuery();
            if(rs.next()){
                returnValue = "true%"+rs.getInt("id")+"%"+rs.getString("first_name")+"%"+rs.getString("last_name")+"%"+rs.getString("mobile")+"%"+rs.getString("email")+"%"+rs.getString("username")+"%"+rs.getString("password");
            }
            else{
                returnValue = "false%null";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
