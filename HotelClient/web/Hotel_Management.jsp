<%-- 
    Document   : Hotel_Management
    Created on : May 10, 2016, 6:22:39 PM
    Author     : Sdilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin | Hotel Management</title>
        <%@include file="importHeader.jsp" %>
        <script src="ajax/Hotel_Management.js"></script>
    </head>
    <body onload="loadTable()">
        <%@include file="header.jsp" %>
        <div id="main" style="margin-left: 12%;margin-right: 12%">
            <div class="container-fluid">
                <div class="page-header">
                    <div class="pull-left">
                        <h1>Hotel Management</h1>
                    </div>
                </div>
                <div class="breadcrumbs">
                    <ul>
                        <li>
                            <a href="index.jsp">Home</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="AdminHome.jsp">Dashboard</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="Hotel_Management.jsp">Hotel Management</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <div class="close-bread">
                            <a href="#"><i class="icon-remove"></i></a>
                        </div>
                    </ul>
                </div>
                <div class="modal alert alert-success" id="successAlert" style="display: none">
                    <div class="modal-header">
                        <h3>Success</h3>
                        <button type="reset" class="close" onclick="$('#successAlert').slideUp('slow')">×</button>
                    </div>
                    <div class="modal-body">
                        <strong>Hotel Save Successfully</strong>
                    </div>
                </div>
                <div class="modal" id="AddHotel" style="display: none">
                    <div class="modal-header">
                        <button type="reset" class="close" onclick="$('#AddHotel').slideUp('slow');$('#form1')[0].reset();">×</button>
                        <h4>Hotel Details</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="form1" onsubmit="SaveHotel();return false">
                            <div class="control-group">
                                <label class="control-label" for="hotelName">Name</label>
                                <div class="controls">
                                    <input type="text" id="hotelName" class="input-large" required="true">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="hotelLocation">Location</label>
                                <div class="controls">
                                    <input type="text" id="hotelLocation" class="input-large" required="true">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="SRooms">Single Rooms</label>
                                <div class="controls">
                                    <input type="number" id="SRooms" class="input-small" min="0" step="1" required="true">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="DRooms">Double Rooms </label>
                                <div class="controls">
                                    <input type="number" id="DRooms" class="input-small" min="0" step="1" required="true">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="FRooms">Family Rooms</label>
                                <div class="controls">
                                    <input type="number" id="FRooms" class="input-small" min="0" step="1" required="true">
                                </div>
                            </div>
                            <div class="form-actions">
                                <button class="btn btn-success" type="submit">Save</button>
                                <button class="btn btn-primary" type="reset" onclick="$('#AddHotel').slideUp('slow')">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <div class="box box-bordered">
                            <div class="box-title">
                                <h3>Hotel Management</h3>
                                <button style="margin-left: 60%" class="btn btn-primary" onclick="$('#AddHotel').slideDown('slow')">Add Hotel</button>
                            </div>
                            <div class="box-content" id="divTable">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
