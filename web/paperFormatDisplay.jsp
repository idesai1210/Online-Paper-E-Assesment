<%-- 
    Document   : paperFormatDisplay
    Created on : May 1, 2014, 8:46:43 PM
    Author     : HP I5
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
        <title>Paper Detail</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />
        <script>
            function del(id) {
                document.paperformatdisp.hid.value = id;
               // alert('Chapter Has Been Deleted');
                paperformatdisp.action = "${pageContext.request.contextPath}/PaperFormatServlet/DeleteServlet";
                paperformatdisp.submit();
            }
        </script>
    </head>
    <body>
        <%@include  file="headerClient.jsp"%>
        <form name="paperformatdisp" method="post" action="">

            <u:if test="${allPaperList==null}">
                <u:redirect url="PaperFormatServlet/ShowServlet"></u:redirect>
            </u:if>
            <input type="hidden" name="hid"/>
            <div class="borderdiv">
                <table width="100%" align="center" border="0">

                    <tr align="center">
                        <th colspan="6"><h2>Exam Paper Detail</h2></th>
                    </tr>

                    <tr align="center">
                        <th><h3>Faculty Name</h3></th>&nbsp;&nbsp;
                    <th><h3>Paper Name</h3></th>&nbsp;&nbsp;
                    <th><h3>Subject</h3></th>&nbsp;&nbsp;
                    <th><h3>Degree</h3></th>&nbsp;&nbsp;
                    <th><h3>College</h3></th>&nbsp;&nbsp;
                    <th><h3>Action</h3></th>
                    </tr>

                    <tr>
                        <th colspan="6"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>

                    <u:forEach items="${allPaperList}" var="apl">
                        <tr align="center">
                            <td>${apl.firstName} &nbsp; ${apl.middleName} &nbsp; ${apl.lastName}</td>
                            <td>${apl.paperName}</td>
                            <td>${apl.subject}</td> 
                            <td>${apl.degreeName}</td>
                            <td>${apl.collegeName}</td>
                            <td><input type="submit" name="delete" value="Delete" onclick="del(${apl.paperId})" class="clkbtn"/></td>
                        </tr>
                    </u:forEach>
                    <tr>
                        <td></td>
                    </tr>
                    <tr align="right">
                        <td colspan="6"><a  href="${pageContext.request.contextPath}/paperformat.jsp">Go Back</a></td>
                    </tr>
                </table>
            </div>
            <br>

        </form>
        <%@include file="footerClient.jsp" %>
    </body>
</html>
