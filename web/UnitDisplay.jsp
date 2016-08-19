<%-- 
    Document   : UnitDisplay
    Created on : Apr 1, 2014, 1:53:54 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u" %>
<u:if test="${id==null}">
    <u:redirect url="Login.jsp"></u:redirect>
</u:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unit Data Display</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />

        <script>
            function upd(id) {
                document.unitDisplay.hid.value = id;
                unitDisplay.action = "${pageContext.request.contextPath}/UnitQuestionServlet/FetchServlet";
                unitDisplay.submit();
            }
            function del(id) {
                document.unitDisplay.hid.value = id;
                alert('Unit Has Been Deleted');
                unitDisplay.action = "${pageContext.request.contextPath}/UnitQuestionServlet/DeleteServlet";
                unitDisplay.submit();
            }
        </script>
    </head>
    <body bgcolor="Grey">
        <%@include  file="headerClient.jsp" %>

        <form name="unitDisplay" method="post">

            <u:if test="${unitList==null}">
                <u:redirect url="UnitQuestionServlet/ShowServlet"></u:redirect>
            </u:if>
            <input type="hidden" name="hid"/>
            <div class="borderdiv">
                <table width="100%" align="center" border="0">

                    <tr align="center">
                        <th><h3>Unit Name</h3></th>
                    <th><h3>Subject Name</h3></th>
                    <th colspan="2"><h3>Action</h3></th>
                    </tr>
                    <tr>
                        <th colspan="6"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>
                    <u:forEach items="${unitList}" var="ul">
                        <tr align="center">

                            <td>${ul.unitQuestionName}</td>
                            <td>${ul.subjectName}</td> 
                            <td><input type="submit" name="delete" value="Delete" onclick="del(${ul.unitQuestionId})" class="clkbtn"/>
                                <input type="submit" name="update" value="Edit" onclick="upd(${ul.unitQuestionId})" class="clkbtn"/></td>
                        </tr>
                    </u:forEach>
                    <tr>
                        <td> </td>
                    </tr>
                    <tr align="right">
                        <td colspan="4"><a  href="${pageContext.request.contextPath}/QuestionInsert.jsp">Back To Insert Question</a></td>
                    </tr>
                </table>
            </div>
            <br>
        </form>

        <%@include  file="footerClient.jsp" %>
    </body>
</html>
