<%-- 
    Document   : AdminPage
    Created on : May 10, 2016, 4:02:08 PM
    Author     : Sdilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <%@include file="importHeader.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div id="main" style="margin-left: 12%;margin-right: 12%">
            <div class="container-fluid">
                <div class="page-header">
                    <div class="pull-left">
                        <h1>Admin Dashboard</h1>
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
                        <div class="close-bread">
                            <a href="#"><i class="icon-remove"></i></a>
                        </div>
                    </ul>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                        <div class="box box-bordered">
                            <div class="box-title">
                                <h3>Admin Dashboard</h3>
                            </div>
                            <div class="box-content">
                                <div class="row-fluid" style="margin-top: 5%;margin-bottom: 2.5%">
                                    <center>
                                        <div class="span4">
                                        </div>
                                    </center>
                                    <center>
                                        <div class="span4">
                                            <button class="btn btn-primary" style="width: 100%;height: 100px;font-size: 20px">Hotel Management</button>
                                        </div>
                                    </center>
                                </div>
                                <div class="row-fluid" style="margin-top: 2.5%;margin-bottom: 5%">
                                    <center>
                                        <div class="span4">
                                        </div>
                                    </center>
                                    <center>
                                        <div class="span4">
                                            <button class="btn btn-primary" style="width: 100%;height: 100px;font-size: 20px">Employee Management</button>
                                        </div>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
