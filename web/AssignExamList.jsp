<%-- 
    Document   : AssignExamList
    Created on : Apr 26, 2014, 8:35:48 PM
    Author     : HP I5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assign Exam List Page</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />
        <script>
            function del(id){
                document.assignExamDisplay.hid.value=id;
                assignExamDisplay.action="${pageContext.request.contextPath}/AssignExamServlet/DeleteServlet";
                assignExamDisplay.submit();
            }
        </script>
    </head>
    <body>
        <%@include file="headerClient.jsp" %>
        <form name="assignExamDisplay" method="post">

            <u:if test="${assignExamList==null}">
                <u:redirect url="AssignExamServlet/ShowServlet"></u:redirect>
            </u:if>
            <input type="hidden" name="hid"/>
            <div class="borderdiv">
                <table width="100%" align="center" border="0">

                    <tr>
                        <th><h3>No.</h3></th>
                    <th><h3>Full Name</h3></th>
                    <th><h3>Subject Name</h3></th>
                    <th><h3>Assign Type</h3></th>
                    <th><h3>Action</h3></th>
                    </tr>
                    <tr>
                        <th colspan="5"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>

                    <u:forEach var="al" items="${assignExamList}" varStatus="varcount">
                        <tr align="center">
                            <td>${varcount.count}</td>
                            <td>${al.firstName} &nbsp; ${al.middleName} &nbsp; ${al.lastName}</td>
                            <td>${al.subjectName}</td>
                            <td>${al.paperAssignType}</td>
                            <td><input type="submit" name="Delete" value="Delete" onclick="del(${al.assignId});" class="clkbtn"/> </td>
                        </tr>
                    </u:forEach>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr align="right">
                        <td colspan="5"><a  href="${pageContext.request.contextPath}/UserDataList.jsp">Go Back</a></td>
                    </tr>
                </table>
            </div>
            <br>

        </form>
        <%@include  file="footerClient.jsp" %>
    </body>
</html>
