/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hotel.register.hotel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sdilshan
 */
public class Hotel_Management extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action.equals("List")) {
                String hotelArray = getAllHotels();
                String[] rows = hotelArray.split("~");
                List<hotel> hotels = new ArrayList<hotel>();
                for (int i = 0; i < rows.length; i++) {
                    hotel ht = new hotel();
                    String[] columns = rows[i].split(",");
                    ht.setId(Integer.parseInt(columns[0]));
                    ht.setName(columns[1]);
                    ht.setLocation(columns[2]);
                    ht.setNo_of_single_rooms(Integer.parseInt(columns[3]));
                    ht.setNo_of_double_rooms(Integer.parseInt(columns[4]));
                    ht.setNo_of_family_rooms(Integer.parseInt(columns[5]));
                    hotels.add(ht);
                }

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                response.setContentType("application/json");
                String jsonArray = gson.toJson(hotels);
                response.getWriter().print(jsonArray);
                //System.out.println(jsonArray);
            }
            if(action.equals("save")){
                StringBuffer mybf = new StringBuffer("<a>");
                String name = request.getParameter("name");
                String location = request.getParameter("location");
                String srooms = request.getParameter("srooms");
                String drooms = request.getParameter("drooms");
                String frooms = request.getParameter("frooms");
                int k = addHotel(name,location,Integer.parseInt(srooms),Integer.parseInt(drooms),Integer.parseInt(frooms));
                if(k>0){
                    mybf.append("<result>"+"1"+"</result>");
                }
                else{
                    mybf.append("<result>"+"0"+"</result>");
                }
                mybf.append("</a>");
                response.setContentType("text/xml");
                response.getWriter().write(mybf.toString());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static String getAllHotels() {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.getAllHotels();
    }

    private static Integer addHotel(java.lang.String name, java.lang.String location, int noOfSingleRooms, int noOfDoubleRooms, int noOfFamilyRooms) {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.addHotel(name, location, noOfSingleRooms, noOfDoubleRooms, noOfFamilyRooms);
    }

}
