/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.servlet;

import com.hotel.contriller.customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sdilshan
 */
public class CustomerLogin extends HttpServlet {

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
            String username = request.getParameter("uemail");
            String password = request.getParameter("upw");
            
            String url = null;
            String p = customerLogin(username, password);
            //System.out.println(p);
            String[] userDetails = p.split("%");
            if(userDetails[0].equals("false")){
                url = "CustomerLogin.jsp";
            }
            else if(userDetails[0].equals("true")){
                customer cs = new customer();
                cs.setId(Integer.parseInt(userDetails[1]));
                cs.setFirstName(userDetails[2]);
                cs.setLastName(userDetails[3]);
                cs.setMobile(userDetails[4]);
                cs.setEmail(userDetails[5]);
                cs.setUsername(userDetails[6]);
                cs.setPassword(userDetails[7]);
                
                HttpSession mysession = request.getSession(true);
                mysession.setAttribute("customerId", cs.getId());
                mysession.setAttribute("FirstName", cs.getFirstName());
                mysession.setAttribute("LastName", cs.getLastName());
                mysession.setAttribute("Mobile", cs.getMobile());
                mysession.setAttribute("Email", cs.getEmail());
                mysession.setAttribute("Username", cs.getUsername());
                mysession.setAttribute("Password", cs.getPassword());
                
                url = "ViewHotels2.jsp";
            }
            if(url != null){
                response.sendRedirect(url);
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

    private static String customerLogin(java.lang.String username, java.lang.String password) {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.customerLogin(username, password);
    }

}
