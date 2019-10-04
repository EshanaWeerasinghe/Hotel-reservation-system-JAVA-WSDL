<%
    int id = 0;
    String first_name = null;
    String last_name = null;
    String nic = null;
    String addressl1 = null;
    String addressl2 = null;
    String addresscity = null;
    String addressPC = null;
    String mobile = null;
    String username = null;
    String password = null;
    int emp_category_id = 0;
    int hotel_id = 0;
    String pageResponse = null;
    String welcome = null;

    String hotelName = null;
    String hotelLocation = null;

    try {
        username = (String) session.getAttribute("Username");
        if (username == null) {
            pageResponse = "Login.jsp";
        } else {
            id = Integer.parseInt(session.getAttribute("empId").toString());
            first_name = session.getAttribute("firstName").toString();
            last_name = session.getAttribute("lastName").toString();
            nic = session.getAttribute("Nic").toString();
            addressl1 = session.getAttribute("Addressl1").toString();
            addressl2 = session.getAttribute("Addressl2").toString();
            addresscity = session.getAttribute("AddressCity").toString();
            addressPC = session.getAttribute("AddressPC").toString();
            mobile = session.getAttribute("Mobile").toString();
            username = session.getAttribute("Username").toString();
            password = session.getAttribute("Password").toString();
            emp_category_id = Integer.parseInt(session.getAttribute("emp_category_id").toString());
            hotel_id = Integer.parseInt(session.getAttribute("hotel_id").toString());
            welcome = "Hello Welcome "+first_name+" "+last_name;
            try {
                com.hotel.webClient.Hotel_Service service = new com.hotel.webClient.Hotel_Service();
                com.hotel.webClient.Hotel port = service.getHotelPort();
                // TODO initialize WS operation arguments here
                int hotelId = hotel_id;
                // TODO process result here
                java.lang.String result = port.getHotelDetails(hotelId);
                //out.println("Result = "+result);
                String[] hn = result.split("%");
                hotelName = "Hotel " + hn[0];
                hotelLocation = hn[1];

            } catch (Exception ex) {
                ex.printStackTrace();
                // TODO handle custom exceptions here
            }
        }
    } catch (NullPointerException e) {
        pageResponse = "Login.jsp";
    }
    if (pageResponse != null) {
        response.sendRedirect(pageResponse);
    }
%>

<div id="navigation">
    <div class="container-fluid">
        <a href="#" id="brand"><%=hotelName%>, <%=hotelLocation%></a>
        <ul class='main-nav'>
            <li>
                <a href="index.jsp">
                    <i class="icon-home"></i>
                    <span>Home</span>
                </a>
            </li>
            <li>
                <a href="Login.jsp">
                    <i class="icon-edit"></i>
                    <span>Employee Login</span>
                </a>
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
