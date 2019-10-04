<%-- 
    Document   : BookRooms
    Created on : May 11, 2016, 10:41:57 PM
    Author     : Sdilshan
--%>
<%
    int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
    String hotel_name = null;
    try {
        com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
        com.hotel.webClient.Hotel port = service.getHotelPort();
        // TODO initialize WS operation arguments here
        int hotelId = hotel_id;
        // TODO process result here
        java.lang.String result = port.getHotelDetails(hotelId);
        String[] p = result.split("%");
        hotel_name = p[0];
        //out.println("Result = "+result);
    } catch (Exception ex) {
        ex.printStackTrace();
        // TODO handle custom exceptions here
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Rooms</title>
        <%@include file="importHeader.jsp" %>
        <script src="ajax/BookRooms.js"></script>
    </head>
    <body onload="whenBodyOnLoad()">
        <%@include file="HeaderCustomer.jsp" %>
        <div class="modal alert alert-success" id="successAlert" style="display: none">
            <div class="modal-header">
                <h3>Success</h3>
                <button type="reset" class="close" onclick="$('#successAlert').slideUp('slow')">×</button>
            </div>
            <div class="modal-body">
                <strong>Rooms Booking Successfully</strong>
            </div>
        </div>
        <div id="main" style="margin-left: 12%;margin-right: 12%">
            <div class="container-fluid">
                <div class="page-header">
                    <div class="pull-left">
                        <h1>Book Rooms</h1>
                    </div>
                </div>
                <div class="breadcrumbs">
                    <ul>
                        <li>
                            <a href="index.jsp">Home</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="ViewHotels2.jsp">View Hotels</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="BookRooms.jsp">Book Rooms</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <div class="close-bread">
                            <a href="#"><i class="icon-remove"></i></a>
                        </div>
                    </ul>
                </div>
                <input type="hidden" id="hotel_id" value="<%=hotel_id%>">
                <input type="hidden" id="customer_id" value="<%=id%>">
                <div class="row-fluid">
                    <div class="span10">
                        <form class="form-horizontal" id="form1" onsubmit="getDate();return false">
                            <div class="control-group">
                                <label class="control-label" for="fname">Name :</label>
                                <div class="controls">
                                    <label>Hotel <%=hotel_name%></label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="fname">Room Type</label>
                                <div class="controls">
                                    <select class="input-large" id="roomsCategory" onchange="getAvailableRooms()" required="true">
                                        <option value="" selected>Select</option>
                                        <option value="1">Single Room</option>
                                        <option value="2">Double Room</option>
                                        <option value="3">Family Room</option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="fname">No. of Rooms</label>
                                <div class="controls">
                                    <select class="input-large" id="NoRooms">

                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="fname">From Date</label>
                                <div class="controls">
                                    <input type="date" class="input-large" id="fdate" required="true" onchange="setDate()">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="fname">To Date</label>
                                <div class="controls">
                                    <input type="date" class="input-large" id="tdate" required="true">
                                </div>
                            </div>
                            <div class="form-actions">
                                <button class="btn btn-success" type="submit">Book</button>
                                <button class="btn btn-primary" type="reset">Clear</button>
                            </div>
                        </form>
                    </div>
                </div>
                </body>
                </html>
