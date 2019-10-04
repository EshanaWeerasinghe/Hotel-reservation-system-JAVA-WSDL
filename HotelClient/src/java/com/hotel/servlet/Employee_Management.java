/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hotel.register.custom_employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sdilshan
 */
public class Employee_Management extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            if (action.equals("List")) {
                String employees = getEmployees();
                String[] rows = employees.split("~");
                List<custom_employee> employeesss = new ArrayList<custom_employee>();
                for(int i = 0; i < rows.length; i++){
                    custom_employee ce = new custom_employee();
                    String columns[] = rows[i].split(",");
                    ce.setId(Integer.parseInt(columns[0]));
                    ce.setName(columns[1]);
                    ce.setEmp_category(columns[2]);
                    ce.setHotel(columns[3]);
                    ce.setMobile(columns[4]);
                    employeesss.add(ce);
                }
                
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                response.setContentType("application/json");
                String jsonArray = gson.toJson(employeesss);
                response.getWriter().print(jsonArray);
                System.out.println(jsonArray);
            }
            if(action.equals("save")){
                StringBuffer mybf = new StringBuffer("<a>");
                String firstName = request.getParameter("fname");
                String LastName = request.getParameter("lname");
                String Addressl1 = request.getParameter("addressl1");
                String Addressl2 = request.getParameter("addressl2");
                String AddressCity = request.getParameter("addresscity");
                String AddressPC = request.getParameter("addresspc");
                String Mobile = request.getParameter("mobile");
                String Nic = request.getParameter("nic");
                String EmpCategoryId = request.getParameter("emp_category_id");
                String HotelId = request.getParameter("hotel_id");
                String UserName = request.getParameter("username");
                String Password = request.getParameter("password");
                int k = 0;
                k = addEmployee(firstName, LastName, Addressl1, Addressl2, AddressCity, AddressPC, Nic, Mobile, Integer.parseInt(EmpCategoryId), Integer.parseInt(HotelId), UserName, Password);
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

    private static String getEmployees() {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.getEmployees();
    }

    private static Integer addEmployee(java.lang.String firstName, java.lang.String lastName, java.lang.String addressL1, java.lang.String addressL2, java.lang.String addressCity, java.lang.String addressPC, java.lang.String nic, java.lang.String mobile, int empCategoryId, int hotelId, java.lang.String userName, java.lang.String password) {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        return port.addEmployee(firstName, lastName, addressL1, addressL2, addressCity, addressPC, nic, mobile, empCategoryId, hotelId, userName, password);
    }

    
}
