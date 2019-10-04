/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sdilshan
 */
public class BookRooms extends HttpServlet {

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
            if(action.equals("getAvailable")){
                String hotelId = request.getParameter("hotel_id");
                String rooms_category_id = request.getParameter("room_type_id");
                int available = getHotelRoomsAvailability(Integer.parseInt(hotelId), Integer.parseInt(rooms_category_id));
                StringBuffer mybf = new StringBuffer("<a>");
                mybf.append("<result>"+available+"</result>");
                mybf.append("</a>");
                response.setContentType("text/xml");
                response.getWriter().write(mybf.toString());
            }
            if(action.equals("save")){
                String hotel_id = request.getParameter("hotel_id");
                String customer_id = request.getParameter("customer_id");
                String room_category_id = request.getParameter("room_category_id");
                String no_of_rooms = request.getParameter("no_of_rooms");
                String from_date = request.getParameter("from_date");
                String to_date = request.getParameter("to_date");
                int k = 0;
                k = booksRooms(Integer.parseInt(hotel_id), Integer.parseInt(customer_id), Integer.parseInt(room_category_id), Integer.parseInt(no_of_rooms), from_date, to_date);
                StringBuffer mybf = new StringBuffer("<a>");
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

    private static Integer getHotelRoomsAvailability(int hotelId, int roomsCategoryId) {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.getHotelRoomsAvailability(hotelId, roomsCategoryId);
    }

    private static Integer booksRooms(int hotelId, int customerId, int roomsCategoryId, int noOfRooms, java.lang.String fromDate, java.lang.String toDate) {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.booksRooms(hotelId, customerId, roomsCategoryId, noOfRooms, fromDate, toDate);
    }

}
