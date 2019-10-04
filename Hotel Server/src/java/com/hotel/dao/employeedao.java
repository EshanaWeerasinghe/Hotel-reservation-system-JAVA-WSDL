/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.dao;

import com.hotel.db.ConnectionPool;
import com.hotel.pogo.employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sdilshan
 */
public class employeedao {
    
    private Connection conn;
    private PreparedStatement pStmt;
    
    public employeedao() {
        conn = ConnectionPool.getConnection();
    }
    
    public int AddEmployee(employee em) {
        int k = 0;
        String InsertQuery = "INSERT INTO `employee`(`first_name`,`last_name`,`nic`,`address_line1`,`address_line2`,`address_city`,`address_postalcode`,`mobile`,`user_name`,`password`,`emp_category_id`,`hotel_id`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pStmt = conn.prepareStatement(InsertQuery);
            pStmt.setString(1, em.getFirst_name());
            pStmt.setString(2, em.getLast_name());
            pStmt.setString(3, em.getNic());
            pStmt.setString(4, em.getAddressl1());
            pStmt.setString(5, em.getAddressl2());
            pStmt.setString(6, em.getAddresscity());
            pStmt.setString(7, em.getAddressPC());
            pStmt.setString(8, em.getMobile());
            pStmt.setString(9, em.getUsername());
            pStmt.setString(10, em.getPassword());
            pStmt.setInt(11, em.getEmp_category_id());
            pStmt.setInt(12, em.getHotel_id());
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
    
    public int UpdateEmployee(employee em) {
        int k = 0;
        String UpdateQuery = "UPDATE `employee` SET `first_name` = ?, `last_name` = ?, `nic` = ?, `address_line1` = ?, `address_line2` = ?, `address_city` = ?, `address_postalcode` = ?, `mobile` = ?, `user_name` = ?, `password` = ?, `emp_category_id` = ?, `hotel_id` = ? WHERE `idemployee` = ?";
        try {
            pStmt = conn.prepareStatement(UpdateQuery);
            pStmt.setString(1, em.getFirst_name());
            pStmt.setString(2, em.getLast_name());
            pStmt.setString(3, em.getNic());
            pStmt.setString(4, em.getAddressl1());
            pStmt.setString(5, em.getAddressl2());
            pStmt.setString(6, em.getAddresscity());
            pStmt.setString(7, em.getAddressPC());
            pStmt.setString(8, em.getMobile());
            pStmt.setString(9, em.getUsername());
            pStmt.setString(10, em.getPassword());
            pStmt.setInt(11, em.getEmp_category_id());
            pStmt.setInt(12, em.getHotel_id());
            pStmt.setInt(13, em.getId());
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
    
    public List<employee> getEmployeeByHotel(int hotel_id) {
        List<employee> employees = new ArrayList<employee>();
        String selectQuery = "SELECT `idemployee`,`first_name`,`last_name`,`nic`,`address_line1`,`address_line2`,`address_city`,`address_postalcode`,`mobile`,`user_name`,`password`,`emp_category_id` FROM `employee` WHERE `hotel_id` = ?";
        try {
            pStmt = conn.prepareStatement(selectQuery);
            pStmt.setInt(1, hotel_id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                employee em = new employee();
                em.setId(rs.getInt("idemployee"));
                em.setFirst_name(rs.getString("first_name"));
                em.setLast_name(rs.getString("last_name"));
                em.setNic(rs.getString("nic"));
                em.setAddressl1(rs.getString("address_line1"));
                em.setAddressl2(rs.getString("address_line2"));
                em.setAddresscity(rs.getString("address_city"));
                em.setAddressPC(rs.getString("address_postalcode"));
                em.setMobile(rs.getString("mobile"));
                em.setUsername(rs.getString("user_name"));
                em.setPassword(rs.getString("password"));
                em.setEmp_category_id(rs.getInt("emp_category_id"));
                em.setHotel_id(hotel_id);
                employees.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    public List<employee> getEmployeeByEmpCategory(int emp_category_id) {
        List<employee> employees = new ArrayList<employee>();
        String selectQuery = "SELECT `idemployee``first_name``last_name``nic``address_line1``address_line2``address_city``address_postalcode``mobile``password``hotel_id` FROM `employee` WHERE `emp_category_id` = ?";
        try {
            pStmt = conn.prepareStatement(selectQuery);
            pStmt.setInt(1, emp_category_id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                employee em = new employee();
                em.setId(rs.getInt("idemployee"));
                em.setFirst_name(rs.getString("first_name"));
                em.setLast_name(rs.getString("last_name"));
                em.setNic(rs.getString("nic"));
                em.setAddressl1(rs.getString("address_line1"));
                em.setAddressl2(rs.getString("address_line2"));
                em.setAddresscity(rs.getString("address_city"));
                em.setAddressPC(rs.getString("address_postalcode"));
                em.setMobile(rs.getString("mobile"));
                em.setUsername(rs.getString("user_name"));
                em.setPassword(rs.getString("password"));
                em.setHotel_id(rs.getInt("hotel_id"));
                em.setEmp_category_id(emp_category_id);
                employees.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    public String getEmployeeCategoryWithid(){
        String returnValue = "";
        String SelectQuery = "SELECT `idemployee_category`,`category_name` FROM `employee_category`";
        try {
            pStmt = conn.prepareStatement(SelectQuery);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                returnValue = returnValue+rs.getInt("idemployee_category")+","+rs.getString("category_name")+"~";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(returnValue);
        return returnValue;
    }
    
    public String GetEmployees(){
        String returnValue = "";
        String SelectQuery = "SELECT employee.`idemployee`, employee.`first_name`, employee.`last_name`, employee_category.`category_name`, hotel.`hotel_Name`, employee.`mobile` FROM `employee_category` INNER JOIN `employee` ON employee_category.`idemployee_category` = employee.`emp_category_id` INNER JOIN `hotel` ON employee.`hotel_id` = hotel.`idhotel`";
        try {
            pStmt = conn.prepareStatement(SelectQuery);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                returnValue = returnValue+rs.getInt("idemployee")+","+rs.getString("first_name")+" "+rs.getString("last_name")+","+rs.getString("category_name")+","+rs.getString("hotel_Name")+","+rs.getString("mobile")+"~";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(returnValue);
        return returnValue;
    }
    
    public int ChangePassword(int emp_id,String password){
        int k = 0;
        String updateQuery = "UPDATE `employee` SET `password` = ? WHERE `idemployee` = ?";
        try {
            pStmt = conn.prepareStatement(updateQuery);
            pStmt.setString(1, password);
            pStmt.setInt(2, emp_id);
            k = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
