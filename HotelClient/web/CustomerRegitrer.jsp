<%-- 
    Document   : CustomerRegitrer
    Created on : May 11, 2016, 6:11:51 PM
    Author     : Sdilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Sign Up</title>
        <%@include file="importHeader.jsp" %>
        <script src="ajax/CustomerRegitrer.js"></script>
    </head>
    <body>
        <div id="navigation">
            <div class="container-fluid">
                <center><a href="#" id="brand">Register And Login</a></center>

            </div>
        </div>
        <div class="modal alert alert-success" id="successAlert" style="display: none">
            <div class="modal-header">
                <center><h3>Success</h3></center>
            </div>
            <div class="modal-body">
                <strong>Your Registration Was Successfully !</strong>
                <br/>
                <strong>Click "OK" to Login</strong>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" onclick="window.location = 'CustomerLogin.jsp'">OK</button>
            </div>
        </div>
        <div id="main" style="margin-left: 12%;margin-right: 12%">
            <div class="container-fluid">
                <div class="page-header">
                    <div class="pull-left">
                        <h1>Customer Registration</h1>
                    </div>
                </div>
                <div class="breadcrumbs">
                    <ul>
                        <li>
                            <a href="index.jsp">Home</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>
                            <a href="CustomerRegitrer.jsp">Customer registration</a>
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
                                <h3>Customer Details</h3>
                            </div>
                            <div class="box-content">
                                <form class="form-horizontal" onsubmit="getDetails();return false">
                                    <div class="control-group">
                                        <label class="control-label" for="fname">First Name</label>
                                        <div class="controls">
                                            <input type="text" id="fname" class="input-large" placeholder="First Name" required="true">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="lname">Last Name</label>
                                        <div class="controls">
                                            <input type="text" id="lname" class="input-large" placeholder="Last Name" required="true">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="mobile">Mobile</label>
                                        <div class="controls">
                                            <input type="text" id="mobile" class="input-large" placeholder="Mobile" required="true">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="email">Email</label>
                                        <div class="controls">
                                            <input type="email" id="email" class="input-large" placeholder="Email" required="true">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="uname">User Name</label>
                                        <div class="controls">
                                            <input type="text" id="uname" class="input-large" placeholder="User Name" required="true">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="pwd">Password</label>
                                        <div class="controls">
                                            <input type="text" id="pwd" class="input-large" required="true">
                                        </div>
                                    </div>
                                    <div class="form-actions">
                                        <button class="btn btn-success" type="submit">Register</button>
                                        <button class="btn btn-primary" type="reset">Clear</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
