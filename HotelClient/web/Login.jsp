<%-- 
    Document   : Login
    Created on : May 7, 2016, 8:51:05 PM
    Author     : Sdilshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel | Login</title>
        <%@include file="importHeader.jsp" %>
    </head>
    <body class='login'>
        <div class="wrapper" style="margin-bottom: 5%;margin-top: 10%">
            <h1><a href="index.html"><img src="img/logo.png" alt="" class='retina-ready' width="59" height="49">Employee Login</a></h1>
            <div class="login-body">
                <h2>SIGN IN</h2>
                <form action="Login" method="POST">
                    <div class="email">
                        <input type="text" id='uemail' name='uemail' placeholder="User Name" class='input-block-level' required="true">
                    </div>
                    <div class="pw">
                        <input type="password" id="upw" name="upw" placeholder="Password" class='input-block-level' required="true">
                    </div>
                    <div class="submit">
                        <input type="submit" value="Sign me in" class='btn btn-primary'>
                    </div>
                </form>
            </div>
        </div>
        <script type="text/javascript">

            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-38620714-4']);
            _gaq.push(['_trackPageview']);

            (function () {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();

        </script>
    </body>
</html>
