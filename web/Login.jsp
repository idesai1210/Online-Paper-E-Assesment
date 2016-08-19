<%-- 
    Document   : login
    Created on : 29-Jan-2014, 10:39:49
    Author     : KLINGON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/cssClient/forlogin/login.css" />
        <link rel="stylesheet" type="text/css" href="cssClient/forlogin/anime.css" />
        <script>
            function registerform()
            {
                loginForm.action="Register.jsp";
                loginForm.submit();
               
            }
            
            
        </script>

    </head>
    <body>
        <div id="wrapper">
            <form name="loginForm" method="post" action="${pageContext.request.contextPath}/LoginServlet" class="login">
                <div class="header">
                    <h1>Login Form</h1>
                    <span>Fill out the form below to login.</span>
                </div>

                <div class="content">
                    <input name="username" id="username" type="text" class="input username" placeholder="Username" />
                    <div class="user-icon"></div>
                    <input name="password" id="password" class="input password" placeholder="Password" type="password" />
                    <div class="pass-icon"></div>		
                </div>

                <div class="footer">
                    <input type="submit" name="login" id="login" value="Login" class="button" />
                    <input type="submit" name="register" id="register" value="Register Here" class="register" onclick="registerform();" /><br><br><br>

                </div>
                <div class="invalid">
                    <table>
                        <tr>
                            <td>
                                <span>
                                    <%
                                        if (request.getAttribute("msg") != null) {
                                            out.println(request.getAttribute("msg"));
                                        }
                                    %>
                                </span>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
            <ul id="progress">
                <li>
                    <div id="layer1" class="ball"></div> <!-- layer1 control delay animation / ball is effect -->
                    <div id="layer7" class="pulse"></div> <!-- layer7 control delay animation / pulse is effect  -->
                </li>
                <li>
                    <div id="layer2" class="ball"></div>
                    <div id="layer8" class="pulse"></div>
                </li>
                <li>
                    <div id="layer3" class="ball"></div>
                    <div id="layer9" class="pulse"></div>
                </li>
                <li>
                    <div id="layer4" class="ball"></div>
                    <div id="layer10" class="pulse"></div>
                </li>
                <li>
                    <div id="layer5" class="ball"></div>
                    <div id="layer11" class="pulse"></div>
                </li>
            </ul>
        </div>
    </body>
</html>
