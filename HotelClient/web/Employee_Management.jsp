<%-- 
    Document   : Employee_Management
    Created on : May 11, 2016, 12:11:34 PM
    Author     : Sdilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin | Employee Management</title>
        <%@include file="importHeader.jsp" %>
        <script src="ajax/Employee_Management.js"></script>
    </head>
    <body onload="loadTable()">
        <%@include file="header.jsp" %>
        <div id="main" style="margin-left: 12%;margin-right: 12%">
            <div class="container-fluid">
                <div class="page-header">
                    <div class="pull-left">
                        <h1>Employee Management</h1>
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
                            <a href="Employee_Management.jsp">Employee Management</a>
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
                        <strong>Employee Save Successfully</strong>
                    </div>
                </div>
                <div class="modal" id="AddEmployee" style="display: none">
                    <div class="modal-header">
                        <button type="reset" class="close" onclick="$('#AddEmployee').slideUp('slow');$('#form1')[0].reset();">×</button>
                        <h4>Employee Details</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" id="form1" onsubmit="AddEmployee();return false">
                            <div class="row-fluid">
                                <div class="span2"><center><label>Name</label></center></div>
                                <div class="span5"><center><input type="text" class="input-medium" id="fname" placeholder="First Name" required="true"></center></div>
                                <div class="span5"><center><input type="text" class="input-medium" id="lname" placeholder="Last Name" required="true"></center></div>
                            </div>
                            <br/>
                            <div class="row-fluid">
                                <div class="span12"><center><label>Address</label></center></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span6"><center><input type="text" class="input-large" placeholder="Line 1" id="addressl1" required="true"></center></div>
                                <div class="span6"><center><input type="text" class="input-large" placeholder="Line 2" id="addressl2" required="true"></center></div>
                            </div>
                            <div class="row-fluid">
                                <div class="span6"><center><input type="text" class="input-large" placeholder="City" id="addresscity" required="true"></center></div>
                                <div class="span6"><center><input type="text" class="input-large" placeholder="Postal Code" id="addresspc" required="true"></center></div>
                            </div>
                            <br/>
                            <div class="row-fluid">
                                <div class="span2"><center><label>Mobile</label></center></div>
                                <div class="span4"><center><input type="text" id="mobile" class="input-medium" placeholder="Mobile" required="true"></center></div>
                                <div class="span2"><center><label>NIC</label></center></div>
                                <div class="span4"><center><input type="text" id="nic" class="input-medium" placeholder="NIC" required="true"></center></div>
                            </div>
                            <br/>
                            <div class="row-fluid">
                                <div class="span2"><center><label>Emp category</label></center></div>
                                <div class="span4">
                                    <center>
                                        <select class="input-medium" id="empCategory" required="true">
                                            <option value="">Select</option>
                                            <%        try {
                                                    com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
                                                    com.hotel.webClient.Hotel port = service.getHotelPort();
                                                    // TODO process result here
                                                    java.lang.String result = port.getEmployeeCategoryWithId();
                                                    //out.println("Result = "+result);
                                                    String rows[] = result.split("~");
                                                    for (int i = 0; i < rows.length; i++) {
                                                        String[] columns = rows[i].split(",");
                                            %>
                                            <option value="<%=columns[0]%>"><%=columns[1]%></option>
                                            <%
                                                    }
                                                } catch (Exception ex) {
                                                    ex.printStackTrace();
                                                    // TODO handle custom exceptions here
                                                }
                                            %>

                                        </select>
                                    </center>
                                </div>
                                <div class="span2"><center><label>Hotel</label></center></div>
                                <div class="span4">
                                    <center>
                                        <select class="input-medium" id="hotel" required="true">
                                            <option value="">Select</option>
                                            <%
                                                try {
                                                    com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
                                                    com.hotel.webClient.Hotel port = service.getHotelPort();
                                                    // TODO process result here
                                                    java.lang.String result = port.getHotelsWithId();
                                                    //out.println("Result = "+result);
                                                    String rows[] = result.split("~");
                                                    for (int i = 0; i < rows.length; i++) {
                                                        String[] columns = rows[i].split(",");
                                            %>
                                            <option value="<%=columns[0]%>"><%=columns[1]%></option>
                                            <%
                                                    }
                                                } catch (Exception ex) {
                                                    ex.printStackTrace();
                                                    // TODO handle custom exceptions here
                                                }
                                            %>
                                        </select>
                                    </center>
                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span2"><center><label>Username</label></center></div>
                                <div class="span4"><center><input type="text" class="input-medium" id="userName" placeholder="User Name" required="true"></center></div>
                                <div class="span2"><center><label>Password</label></center></div>
                                <div class="span4"><center><input type="password" class="input-medium" id="passWord" required="true"></center></div>
                            </div>
                            <div class="form-actions">
                                <button class="btn btn-success" type="submit">Save</button>
                                <button class="btn btn-primary" type="reset" onclick="$('#AddEmployee').slideUp('slow')">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="row-fluid">
                    <div class="span12">
                        <div class="box box-bordered">
                            <div class="box-title">
                                <h3>Employee Management</h3>
                                <button style="margin-left: 60%" class="btn btn-primary" onclick="$('#AddEmployee').slideDown('slow')">Add Employee</button>
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
