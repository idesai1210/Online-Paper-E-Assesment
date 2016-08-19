<%-- 
    Document   : header
    Created on : Mar 23, 2014, 12:24:29 PM
    Author     : asnthvinayak
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header JSP</title>
        <link href="${pageContext.request.contextPath}/cssClient/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <div class="main">
            <div class="main_resize">
                <div class="header">
                    <div class="logo">
                        <h1><a href="#"><span>Online</span>Exam<small>E-Assessment & Paper Making</small></a></h1>

                    </div>
                    <div class="search">
                        <form method="get" id="search" action="#">
                          
                            <span>
                                <input type="text" value="Search..." name="s" id="s" />
                                <input name="searchsubmit" type="image" src="${pageContext.request.contextPath}/cssClient/images/search.gif" value="Go" id="searchsubmit" class="btn"  />
                            </span>
                        </form>
                        <!--/searchform -->
                        <div class="clr"></div>
                    </div>
                    <div class="clr"></div>
                    <div class="menu_nav">
                        <%  int id = Integer.parseInt(session.getAttribute("id").toString());
                            if (id == 3) {%>

                        <ul>
                            <li class="active"><a  href="#">Home</a></li>
                            <li><a href="#">Add Question</a></li>
                            <li><a href="#">Paper Creation</a></li>
                            <li><a href="#">Evaluation</a></li>
                            <li><a href="#"/>Assign Exam</a></li>
                            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
                        </ul>
                        <% } else if (id == 1) {%>

                        <ul>
                            <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/QuestionInsert.jsp">Add Question</a></li>
                            <li><a href="${pageContext.request.contextPath}/PaperCreaiton.jsp">Paper Creation</a></li>
                            <li><a href="${pageContext.request.contextPath}/Evaluation.jsp">Evaluation</a></li>

                            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
                        </ul>

                        <%  } else if (id == 2) {%>
                        <ul>
                            <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/QuestionInsert.jsp">Add Question</a></li>
                            <li><a href="${pageContext.request.contextPath}/paperformat.jsp">Paper Creation</a></li>
                            <li><a href="${pageContext.request.contextPath}/Evaluation.jsp"">Evaluation</a></li>
                            <li><a href="${pageContext.request.contextPath}/UserDataList.jsp"/>Assign Exam</a></li>
                            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
                        </ul>


                        <%                              }%>
                        <div class="clr"></div>
                    </div>
                    <div class="hbg"><img src="${pageContext.request.contextPath}/cssClient/images/header_images.jpg" width="923" height="350" style="border-radius:20px;"/></div>
                </div>

                </body>
                </html>
