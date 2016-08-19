<%-- 
    Document   : openpic
    Created on : 17-Apr-2014, 14:39:58
    Author     : KLINGON
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${id==null}">
    <c:redirect url="Login.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function Next(){
            document.f01.action="${pageContext.request.contextPath}/NextServlet";
            f01.submit();
            
          }
        </script>
    </head>
    <body>
        <form name="f01" >
            
            <c:if test="${ imgList==null }">
                
                <c:redirect url="OpenPicServlet"/>
                </c:if>
            <table>
                <% for(int i=1;i<=Integer.parseInt(session.getAttribute("size").toString());i++){ %>
            <c:forEach var="imgList" items="${imgList}">
                <tr>
                ${imgList.ppath}<h5>/<%=i%></h5>
                   <img src="image/${imgList.ppath}/<%=i%>.jpg"/>
                   <input type="submit" value="Next" onclick="Next();"/>
                </tr>
                
            </c:forEach>
                <%}%>
                
            </table>
        </form>
    </body>
</html>
