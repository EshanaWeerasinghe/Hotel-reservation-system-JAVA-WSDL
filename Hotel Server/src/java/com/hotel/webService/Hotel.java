/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.webService;

import com.hotel.controller.LoginController;
import com.hotel.dao.customerdao;
import com.hotel.dao.employeedao;
import com.hotel.dao.hoteldao;
import com.hotel.pogo.customer;
import com.hotel.pogo.employee;
import com.hotel.pogo.hotel;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sdilshan
 */
@WebService(serviceName = "Hotel")
public class Hotel {
    @WebMethod(operationName = "Login")
    public String Login(@WebParam(name = "Username") String Username, @WebParam(name = "Password") String Password) {
        String returnvalue = "";
        LoginController lc = new LoginController();
        returnvalue = lc.getLogin(Username, Password);
        return returnvalue;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetHotelDetails")
    public String GetHotelDetails(@WebParam(name = "hotel_id") int hotel_id) {
        String returnValue = "";
        hoteldao hd = new hoteldao();
        returnValue = hd.GetHotelDetails(hotel_id);
        return returnValue;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddHotel")
    public Integer AddHotel(@WebParam(name = "Name") String Name, @WebParam(name = "Location") String Location, @WebParam(name = "No_Of_Single_Rooms") int No_Of_Single_Rooms, @WebParam(name = "No_Of_Double_Rooms") int No_Of_Double_Rooms, @WebParam(name = "No_Of_Family_Rooms") int No_Of_Family_Rooms) {
        int k = 0;
        hotel ht = new hotel();
        ht.setName(Name);
        ht.setLocation(Location);
        ht.setNo_of_single_rooms(No_Of_Single_Rooms);
        ht.setNo_of_double_rooms(No_Of_Double_Rooms);
        ht.setNo_of_family_rooms(No_Of_Family_Rooms);
        hoteldao hd = new hoteldao();
        k = hd.addHotel(ht);
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetAllHotels")
    public String GetAllHotels() {
        String returnValue = null;
        hoteldao hd = new hoteldao();
        returnValue = hd.getAllHotels();
        return returnValue;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetHotelsWithId")
    public String GetHotelsWithId() {
        String returnValue = null;
        hoteldao hd = new hoteldao();
        returnValue = hd.getHotelsWithId();
        return returnValue;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetEmployeeCategoryWithId")
    public String GetEmployeeCategoryWithId() {
        String returnValue = null;
        employeedao ed = new employeedao();
        returnValue = ed.getEmployeeCategoryWithid();
        return returnValue;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetEmployees")
    public String GetEmployees() {
        String returnValue = null;
        employeedao ed = new employeedao();
        returnValue = ed.GetEmployees();
        return returnValue;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddEmployee")
    public Integer AddEmployee(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "AddressL1") String AddressL1, @WebParam(name = "AddressL2") String AddressL2, @WebParam(name = "AddressCity") String AddressCity, @WebParam(name = "AddressPC") String AddressPC, @WebParam(name = "Nic") String Nic, @WebParam(name = "Mobile") String Mobile, @WebParam(name = "Emp_Category_id") int Emp_Category_id, @WebParam(name = "Hotel_Id") int Hotel_Id, @WebParam(name = "UserName") String UserName, @WebParam(name = "Password") String Password) {
        int k = 0;
        
        employee em = new employee();
        em.setFirst_name(firstName);
        em.setLast_name(lastName);
        em.setAddressl1(AddressL1);
        em.setAddressl2(AddressL2);
        em.setAddresscity(AddressCity);
        em.setAddressPC(AddressPC);
        em.setEmp_category_id(Emp_Category_id);
        em.setHotel_id(Hotel_Id);
        em.setUsername(UserName);
        em.setPassword(Password);
        em.setMobile(Mobile);
        em.setNic(Nic);
        
        employeedao ed = new employeedao();
        k = ed.AddEmployee(em);
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CustomerLogin")
    public String CustomerLogin(@WebParam(name = "Username") String Username, @WebParam(name = "Password") String Password) {
        String returnValue = null;
        LoginController lc = new LoginController();
        returnValue = lc.customerLogin(Username, Password);
        return returnValue;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddNewCustomer")
    public Integer AddNewCustomer(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "mobile") String mobile, @WebParam(name = "email") String email, @WebParam(name = "userName") String userName, @WebParam(name = "passWord") String passWord) {
        int k = 0;
        customer cs = new customer();
        customerdao cd = new customerdao();
        cs.setFirstName(firstName);
        cs.setLastName(lastName);
        cs.setMobile(mobile);
        cs.setEmail(email);
        cs.setUsername(userName);
        cs.setPassword(passWord);
        k = cd.AddCustomer(cs);
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetHotelRoomsAvailability")
    public Integer GetHotelRoomsAvailability(@WebParam(name = "hotel_id") int hotel_id, @WebParam(name = "rooms_category_id") int rooms_category_id) {
        int k = 0;
        hoteldao hd = new hoteldao();
        k = hd.getHotelRoomsAvailability(hotel_id, rooms_category_id);
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BooksRooms")
    public Integer BooksRooms(@WebParam(name = "hotel_id") int hotel_id, @WebParam(name = "customer_id") int customer_id, @WebParam(name = "rooms_category_id") int rooms_category_id, @WebParam(name = "no_of_rooms") int no_of_rooms, @WebParam(name = "from_date") String from_date, @WebParam(name = "to_date") String to_date) {
        int k = 0;
        hoteldao hd = new hoteldao();
        k = hd.BookRooms(hotel_id, customer_id, rooms_category_id, no_of_rooms, from_date, to_date);
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getRoomsOrders")
    public String getRoomsOrders(@WebParam(name = "hotel_id") int hotel_id) {
        String returnValue = null;
        hoteldao hd = new hoteldao();
        returnValue = hd.getRoomsOrders(hotel_id);
        return returnValue;
    }

}
