/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.dao;

import com.hotel.db.ConnectionPool;
import com.hotel.pogo.double_rooms;
import com.hotel.pogo.family_rooms;
import com.hotel.pogo.hotel;
import com.hotel.pogo.single_rooms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sdilshan
 */
public class hoteldao {

    private Connection conn;
    private PreparedStatement pStmt;

    public hoteldao() {
        conn = ConnectionPool.getConnection();
    }

    public String getAllHotels() {
        //List<hotel> hotels = new ArrayList<hotel>();
        String returnvalue = "";
        String selectQuery = "SELECT `idhotel`,`hotel_Name`,`location`,`single_rooms`,`double_rooms`,`family_rooms` FROM `hotel`";
        try {
            pStmt = conn.prepareStatement(selectQuery);
            ResultSet rs = pStmt.executeQuery();
            //id,name,location,singlerooms,doublerooms,familyrooms

            while (rs.next()) {
                String returnval = rs.getInt("idhotel") + "," + rs.getString("hotel_Name") + "," + rs.getString("location") + "," + rs.getInt("single_rooms") + "," + rs.getInt("double_rooms") + "," + rs.getInt("family_rooms") + "~";
                returnvalue = returnvalue + returnval;
                //hotel ht = new hotel();
//                ht.setId(rs.getInt("idhotel"));
//                ht.setName(rs.getString("hotel_Name"));
//                ht.setLocation(rs.getString("location"));
//                ht.setNo_of_single_rooms(rs.getInt("single_rooms"));
//                ht.setNo_of_double_rooms(rs.getInt("double_rooms"));
//                ht.setNo_of_family_rooms(rs.getInt("family_rooms"));
//                hotels.add(ht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(returnvalue);
        return returnvalue;
    }

    public int addHotel(hotel ht) {
        int k = 0;
        int hotel_id = 0;
        String insertQuery = "INSERT INTO `hotel`(`hotel_Name`,`location`,`single_rooms`,`double_rooms`,`family_rooms`) VALUES(?,?,?,?,?)";
        try {
            pStmt = conn.prepareStatement(insertQuery);
            pStmt.setString(1, ht.getName());
            pStmt.setString(2, ht.getLocation());
            pStmt.setInt(3, ht.getNo_of_single_rooms());
            pStmt.setInt(4, ht.getNo_of_double_rooms());
            pStmt.setInt(5, ht.getNo_of_family_rooms());
            k = pStmt.executeUpdate();

            //get Hotel id
            if (k == 1) {
                String sql = "SELECT `idhotel` FROM `hotel` WHERE `hotel_Name` = ? AND `location` = ?";
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, ht.getName());
                pStmt.setString(2, ht.getLocation());
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) {
                    hotel_id = rs.getInt("idhotel");
                }

                //Set Hotel Rooms
                //1.set Single Rooms
                int no_of_single_rooms = ht.getNo_of_single_rooms();
                if (no_of_single_rooms > 0) {

                    single_rooms_dao srd = new single_rooms_dao();
                    for (int i = 0; i < no_of_single_rooms; i++) {
                        String room_name = hotel_id + "/SR/" + (i + 1);
                        single_rooms sr = new single_rooms();
                        sr.setName(room_name);
                        sr.setHotel_id(hotel_id);
                        srd.AddSingleRoom(sr);
                    }
                }
                //2.set Double Rooms
                int no_of_double_rooms = ht.getNo_of_double_rooms();
                if (no_of_double_rooms > 0) {
                    double_rooms_dao drd = new double_rooms_dao();
                    for (int i = 0; i < no_of_double_rooms; i++) {
                        String room_name = hotel_id + "/DR/" + (i + 1);
                        double_rooms dr = new double_rooms();
                        dr.setName(room_name);
                        dr.setHotel_id(hotel_id);
                        drd.AddDoubleRoom(dr);
                    }
                }
                //3.set Family Rooms
                int no_of_family_rooms = ht.getNo_of_family_rooms();
                if (no_of_family_rooms > 0) {
                    family_rooms_dao frd = new family_rooms_dao();
                    for (int i = 0; i < no_of_family_rooms; i++) {
                        String room_name = hotel_id + "/FR/" + (i + 1);
                        family_rooms fr = new family_rooms();
                        fr.setName(room_name);
                        fr.setHotel_id(hotel_id);
                        frd.AddFamilyRoom(fr);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel_id;
    }

    public String GetHotelDetails(int hotel_id) {
        String hotel_details = "";
        String selectQuery = "SELECT `hotel_Name`,`location` FROM `hotel` WHERE `idhotel` = ?";
        try {
            pStmt = conn.prepareStatement(selectQuery);
            pStmt.setInt(1, hotel_id);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                //Hotel_name%Location
                hotel_details = rs.getString("hotel_Name") + "%" + rs.getString("location");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel_details;
    }

    public int getHotelRoomsAvailability(int hotel_id, int rooms_category_id) {
        int returnValue = 0;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        String today = df.format(dt);
        String[] dateArray = today.split("-");
        int todayValue = (Integer.parseInt(dateArray[0])*360)+(Integer.parseInt(dateArray[1])*30)+Integer.parseInt(dateArray[2]);
        String SelectQuery = null;
        if (rooms_category_id == 1) {
            SelectQuery = "SELECT COUNT(`idsingle_room`) FROM `single_rooms` WHERE `hotel_id` = ? AND `availability` = ?";
            try {
                pStmt = conn.prepareStatement(SelectQuery);
                pStmt.setInt(1, hotel_id);
                pStmt.setInt(2, 0);
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) {
                    returnValue = rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rooms_category_id == 2) {
            SelectQuery = "SELECT COUNT(`iddouble_rooms`) FROM `double_rooms` WHERE `hotel_id` = ? AND `availability` = ?";
            try {
                pStmt = conn.prepareStatement(SelectQuery);
                pStmt.setInt(1, hotel_id);
                pStmt.setInt(2, 0);
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) {
                    returnValue = rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rooms_category_id == 3) {
            SelectQuery = "SELECT COUNT(`idfamily_rooms`) FROM `family_rooms` WHERE `hotel_id` = ? AND `availability` = ?";
            try {
                pStmt = conn.prepareStatement(SelectQuery);
                pStmt.setInt(1, hotel_id);
                pStmt.setInt(2, 0);
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) {
                    returnValue = rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnValue;
    }

    public int BookRooms(int hotel_id, int costomer_id, int rooms_catrgory_id, int no_of_rooms, String fromDate, String toDate) {
        int k = 0;
        String selectQuery = null;
        String pp = "";
        if (rooms_catrgory_id == 1) {
            selectQuery = "SELECT `idsingle_room` FROM `single_rooms` WHERE `availability` = ? AND `hotel_id` = ? LIMIT ?";
            try {
                pStmt = conn.prepareStatement(selectQuery);
                pStmt.setInt(1, 0);
                pStmt.setInt(2, hotel_id);
                pStmt.setInt(3, no_of_rooms);
                ResultSet rs = pStmt.executeQuery();
                while (rs.next()) {
                    pp = pp + rs.getInt("idsingle_room") + ",";
                }
                System.out.println(pp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rooms_catrgory_id == 2) {
            selectQuery = "SELECT `iddouble_rooms` FROM `double_rooms` WHERE `availability` = ? AND `hotel_id` = ? LIMIT ?";
            try {
                pStmt = conn.prepareStatement(selectQuery);
                pStmt.setInt(1, 0);
                pStmt.setInt(2, hotel_id);
                pStmt.setInt(3, no_of_rooms);
                ResultSet rs = pStmt.executeQuery();
                while (rs.next()) {
                    pp = pp + rs.getInt("iddouble_rooms") + ",";
                }
                System.out.println(pp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rooms_catrgory_id == 3) {
            selectQuery = "SELECT `idfamily_rooms` FROM `family_rooms` WHERE `availability` = ? AND `hotel_id` = ? LIMIT ?";
            try {
                pStmt = conn.prepareStatement(selectQuery);
                pStmt.setInt(1, 0);
                pStmt.setInt(2, hotel_id);
                pStmt.setInt(3, no_of_rooms);
                ResultSet rs = pStmt.executeQuery();
                while (rs.next()) {
                    pp = pp + rs.getInt("idfamily_rooms") + ",";
                }
                System.out.println(pp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String[] rooms_id_array = pp.split(",");
        if (rooms_catrgory_id == 1) {
            for (int i = 0; i < rooms_id_array.length; i++) {
                String UpdateQiery = "UPDATE `single_rooms` SET `availability` = ?, `from_date` = ?, `to_date` = ?, `customer_id` = ? WHERE `idsingle_room` = ?";
                try {
                    pStmt = conn.prepareStatement(UpdateQiery);
                    pStmt.setInt(1, 1);
                    pStmt.setString(2, fromDate);
                    pStmt.setString(3, toDate);
                    pStmt.setInt(4, costomer_id);
                    pStmt.setInt(5, Integer.parseInt(rooms_id_array[i]));
                    k = pStmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (rooms_catrgory_id == 2) {
            for (int i = 0; i < rooms_id_array.length; i++) {
                String UpdateQiery = "UPDATE `double_rooms` SET `availability` = ?, `from_date` = ?, `to_date` = ?, `customet_id` = ? WHERE `iddouble_rooms` = ?";
                try {
                    pStmt = conn.prepareStatement(UpdateQiery);
                    pStmt.setInt(1, 1);
                    pStmt.setString(2, fromDate);
                    pStmt.setString(3, toDate);
                    pStmt.setInt(4, costomer_id);
                    pStmt.setInt(5, Integer.parseInt(rooms_id_array[i]));
                    k = pStmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (rooms_catrgory_id == 3) {
            for (int i = 0; i < rooms_id_array.length; i++) {
                String UpdateQiery = "UPDATE `family_rooms` SET `availability` = ?, `from_date` = ?, `to_date` = ?, `customer_id` = ? WHERE `idfamily_rooms` = ?";
                try {
                    pStmt = conn.prepareStatement(UpdateQiery);
                    pStmt.setInt(1, 1);
                    pStmt.setString(2, fromDate);
                    pStmt.setString(3, toDate);
                    pStmt.setInt(4, costomer_id);
                    pStmt.setInt(5, Integer.parseInt(rooms_id_array[i]));
                    k = pStmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return k;
    }
    
    public String getRoomsOrders(int hotel_id){
        String returnValue = "";
        String SelectQuery1 = "SELECT `name`,`from_date`,`to_date` FROM `single_rooms` WHERE `availability` = ? AND `hotel_id` = ?";
        String SelectQuery2 = "SELECT `name`,`from_date`,`to_date` FROM `double_rooms` WHERE `availability` = ? AND `hotel_id` = ?";
        String SelectQuery3 = "SELECT `name`,`from_date`,`to_date` FROM `family_rooms` WHERE `availability` = ? AND `hotel_id` = ?";
        try {
            pStmt = conn.prepareStatement(SelectQuery1);
            pStmt.setInt(1, 1);
            pStmt.setInt(2, hotel_id);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                returnValue = returnValue+"Single Room,"+rs.getString("name")+","+rs.getString("from_date")+","+rs.getString("to_date")+"~";
            }
            
            pStmt = conn.prepareStatement(SelectQuery2);
            pStmt.setInt(1, 1);
            pStmt.setInt(2, hotel_id);
            ResultSet rs2 = pStmt.executeQuery();
            while (rs2.next()) {                
                returnValue = returnValue+"Double Rooms,"+rs2.getString("name")+","+rs2.getString("from_date")+","+rs2.getString("to_date")+"~";
            }
            
            pStmt = conn.prepareStatement(SelectQuery3);
            pStmt.setInt(1, 1);
            pStmt.setInt(2, hotel_id);
            ResultSet rs3 = pStmt.executeQuery();
            while (rs3.next()) {                
                returnValue = returnValue+"Family Rooms,"+rs3.getString("name")+","+rs3.getString("from_date")+","+rs3.getString("to_date")+"~";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(returnValue);
        return returnValue;
    }

    public String getHotelsWithId() {
        String returnvalue = "";
        String SelectQuery = "SELECT `idhotel`,`hotel_Name` FROM `hotel`";
        try {
            pStmt = conn.prepareStatement(SelectQuery);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                returnvalue = returnvalue + rs.getInt("idhotel") + "," + rs.getString("hotel_Name") + "~";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(returnvalue);
        return returnvalue;
    }

    public int UpdateHotel(hotel ht) {
        int k = 0;

        return k;
    }
}
