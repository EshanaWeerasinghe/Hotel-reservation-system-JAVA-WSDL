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
public class CustomerRegistration extends HttpServlet {

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
            String firstName = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            int k = 0;
            k = addNewCustomer(firstName, lname, mobile, email, uname, pwd);
            StringBuffer mybf = new StringBuffer("<a>");
            if(k == 1){
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

    private static Integer addNewCustomer(java.lang.String firstName, java.lang.String lastName, java.lang.String mobile, java.lang.String email, java.lang.String userName, java.lang.String passWord) {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.addNewCustomer(firstName, lastName, mobile, email, userName, passWord);
    }

}
