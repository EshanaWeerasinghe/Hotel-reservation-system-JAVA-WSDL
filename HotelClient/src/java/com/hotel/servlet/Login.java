/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.servlet;

import com.hotel.contriller.employee;
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
public class Login extends HttpServlet {

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
            String p = login(username,password);
            StringBuffer mybf = new StringBuffer("<a>");
            String[] userDetails = p.split("%");
            if(userDetails[0].equals("false")){
                url = "Login.jsp";
            }
            else if(userDetails[0].equals("true")){
                mybf.append("<login>"+"1"+"</login>");
                employee em = new employee();
                em.setId(Integer.parseInt(userDetails[1]));
                em.setFirst_name(userDetails[2]);
                em.setLast_name(userDetails[3]);
                em.setNic(userDetails[4]);
                em.setAddressl1(userDetails[5]);
                em.setAddressl2(userDetails[6]);
                em.setAddresscity(userDetails[7]);
                em.setAddressPC(userDetails[8]);
                em.setMobile(userDetails[9]);
                em.setUsername(userDetails[10]);
                em.setPassword(userDetails[11]);
                em.setEmp_category_id(Integer.parseInt(userDetails[12]));
                em.setHotel_id(Integer.parseInt(userDetails[13]));
                
                HttpSession session = request.getSession(true);
                session.setAttribute("empId", em.getId());
                session.setAttribute("firstName", em.getFirst_name());
                session.setAttribute("lastName", em.getLast_name());
                session.setAttribute("Nic", em.getNic());
                session.setAttribute("Addressl1", em.getAddressl1());
                session.setAttribute("Addressl2", em.getAddressl2());
                session.setAttribute("AddressCity", em.getAddresscity());
                session.setAttribute("AddressPC", em.getAddressPC());
                session.setAttribute("Mobile", em.getMobile());
                session.setAttribute("Username", em.getUsername());
                session.setAttribute("Password", em.getPassword());
                session.setAttribute("emp_category_id", em.getEmp_category_id());
                session.setAttribute("hotel_id", em.getHotel_id());
                
                int emp_category = em.getEmp_category_id();
                //1 -> global Admin
                //2 -> Manager
                //3 -> Supervisor
                //4 -> Reception
                if(emp_category == 1){
                    url = "AdminPage.jsp";
                }
                else{
                    int emp_category_id = em.getEmp_category_id();
                    if(emp_category_id == 2){
                        url = "ManagerHomepage.jsp";
                    }
                    else if(emp_category_id == 3){
                        url = "SupervisorHomepage.jsp";
                    }
                    else if(emp_category_id == 4){
                        url = "ReceptionHomepage.jsp";
                    }
                }
            }
            if(url != null){
                response.sendRedirect(url);
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

    private static String login(java.lang.String username, java.lang.String password) {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.login(username, password);
    }

    

}
