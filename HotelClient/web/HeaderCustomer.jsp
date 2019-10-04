<%-- 
    Document   : HeaderCustomer
    Created on : May 11, 2016, 5:52:00 PM
    Author     : Sdilshan
--%>

<%
    int id = 0;
    String firstName = null;
    String lastName = null;
    String mobile = null;
    String email = null;
    String username = null;
    String password = null;
    String pageResponse = null;
    String welcome = null;
    
    try{
        HttpSession mysession = request.getSession();
        username = mysession.getAttribute("Username").toString();
        if(username == null){
            pageResponse = "CustomerLogin.jsp";
        }
        else{
            id = Integer.parseInt(mysession.getAttribute("customerId").toString());
            firstName = mysession.getAttribute("FirstName").toString();
            lastName = mysession.getAttribute("LastName").toString();
            mobile = mysession.getAttribute("Mobile").toString();
            email = mysession.getAttribute("Email").toString();
            password = mysession.getAttribute("Password").toString();
            welcome = "Hello Welcome "+firstName+" "+lastName;
        }
    }
    catch(NullPointerException e){
        pageResponse = "CustomerLogin.jsp";
    }
    
    if (pageResponse != null) {
        response.sendRedirect(pageResponse);
    }
%>

<div id="navigation">
    <div class="container-fluid">
        <a href="#" id="brand">Hotel Management System</a>
        <ul class='main-nav'>
            <li>
                <a href="index.html">
                    <i class="icon-home"></i>
                    <span>Dashboard</span>
                </a>
            </li>
            <li>
                <a href="#" data-toggle="dropdown" class='dropdown-toggle'>
                    <i class="icon-edit"></i>
                    <span>Accounts</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="CustomerAccounts.jsp">Accounts</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#" data-toggle="dropdown" class='dropdown-toggle'>
                    <i class="icon-th-large"></i>
                    <span>Loans</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="Loans.jsp">View Loans</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#" data-toggle="dropdown" class='dropdown-toggle'>
                    <i class="icon-th-large"></i>
                    <span>Inquiries</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="Inquiries.jsp">Make Inquiry</a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="user" style="float: right">
            <div class="dropdown">
                <a href="#" class='dropdown-toggle' data-toggle="dropdown"><%=welcome%><img src="img/demo/user-avatar.jpg" alt=""></a>
                <ul class="dropdown-menu pull-right">
                    <li>
                        <a href="Logout.jsp">Sign out</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>