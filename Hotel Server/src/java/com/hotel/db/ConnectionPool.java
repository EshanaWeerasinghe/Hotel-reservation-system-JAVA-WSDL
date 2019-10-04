/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sdilshan
 */
public class ConnectionPool {

    private static Connection conn = null;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/hotel_ms";
    private static String USER = "root";
    private static String PASS = "1234";

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
