<%-- 
    Document   : index
    Created on : May 11, 2016, 8:41:45 PM
    Author     : Sdilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <%@include file="importHeader.jsp" %>
    </head>
    <body>
        <div id="navigation">
            <div class="container-fluid">
                <center><a href="#" id="brand">Welcome Hotel ABC</a></center>
                <ul class='main-nav pull-right'>
                    <li>
                        <a href="Login.jsp">
                            <i class="icon-edit"></i>
                            <span>Employee Login</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div id="main" style="margin-left: 12%;margin-right: 12%;margin-top: 2%">
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <img src="img/hotel_img1.jpg" width="100%" height="100%">
                    </div>
                </div>
                <hr/>
                <div class="row-fluid">
                    <center>
                        <div class="span6">
                            <button class="btn btn-warning" onclick="window.location = 'ViewHotels.jsp'">View Hotels</button>
                        </div>
                    </center>
                </div>
            </div>
        </div>
    </body>
</html>
