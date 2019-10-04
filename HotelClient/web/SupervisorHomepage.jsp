<%-- 
    Document   : SupervisorHomepage
    Created on : May 12, 2016, 3:21:33 AM
    Author     : Sdilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supervisor Home</title>
        <%@include file="importHeader.jsp" %>
    </head>
    <body onload="$('#dataTable').DataTable()">
        <%@include file="header.jsp" %>
        <div id="main" style="margin-left: 12%;margin-right: 12%">
            <div class="container-fluid">
                <div class="page-header">
                    <div class="pull-left">
                        <h1>Supervisor Dashboard</h1>
                    </div>
                </div>
                <div class="breadcrumbs">
                    <ul>
                        <li>
                            <a href="index.jsp">Home</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="Login.jsp">Login</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="SupervisorHomepage.jsp">Supervisor Dashboard</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <div class="close-bread">
                            <a href="#"><i class="icon-remove"></i></a>
                        </div>
                    </ul>
                </div>
                <div class="row-fluid">
                    <div class="span10">
                        <div class="box box-bordered">
                            <div class="box-title">
                                <h3>Orders</h3>
                            </div>
                            <div class="box-content">
                                <table id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>Room Type</th>
                                            <th>Rooms Name</th>
                                            <th>From Date</th>
                                            <th>To Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                                            try {
                                                com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
                                                com.hotel.webClient.Hotel port = service.getHotelPort();
                                                // TODO initialize WS operation arguments here
                                                int hotelId = id;
                                                // TODO process result here
                                                java.lang.String result = port.getRoomsOrders(hotelId);
                                                String[] rows = result.split("~");
                                                for(int i = 0; i < rows.length; i++){
                                                    String[] columns = rows[i].split(",");
                                                    %>
                                                    <tr>
                                                        <td><%=columns[0]%></td>
                                                        <td><%=columns[1]%></td>
                                                        <td><%=columns[2]%></td>
                                                        <td><%=columns[3]%></td>
                                                    </tr>
                                                    <%
                                                }
                                                //out.println("Result = " + result);
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                                // TODO handle custom exceptions here
                                            }
                                        %>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
