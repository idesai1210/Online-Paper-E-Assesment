<%-- 
    Document   : index
    Created on : Apr 2, 2014, 12:19:14 PM
    Author     : HP I5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<u:if test="${id==null}">
    <u:redirect url="Login.jsp"></u:redirect>
</u:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Answer Sheet List</title>
        <link href="${pageContext.request.contextPath}/cssClient/templatemo_style.css" rel="stylesheet" type="text/css" />
        <script>
            function openCheck(studid,pprid)
            {
//                alert("Here is:"+studid);
                document.f1.student_id.value=studid;
                document.f1.pprid.value=pprid;

                document.f1.action="${pageContext.request.contextPath}/OpenPicServlet";
                
                f1.submit();
            }
            </script>
    </head>
    <body>
        <%@include  file="headerClient.jsp" %>
        <form name="f1" method="post" action="OpenPicServlet">
            <input type="hidden" name="student_id" id="student_id" />
            <input type="hidden" name="pprid" id="pprid" />
         <div class="borderdiv">
                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                    
                    <tr align="center">
                        <th><h3>Answer Sheet Id</h3></th>
                    <th><h3>Student Id</h3></th>
                    <th><h3>Paper Id</h3></th>
                    <th>
                    <h3> Open Answer Sheet </h3>
                    </th>
                    </tr>
                    <tr>
                        <th colspan="6"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>




                    <c:forEach var="anslist" items="${anslist}">
                <tr>
                    <td align="center">
                        ${anslist.answersheetid}
                        
                    </td>
                    <td align="center">
                        <a href="#">${anslist.student_id}</a>
                        
                    </td>
                     <td align="center">
                        ${anslist.pprid}
                        
                    </td>
                    <td align="center">
<!--                        <a onclick=""> Open</a>-->
                        <input type="button" name="open" value="Open"  onclick="openCheck(${anslist.student_id},${anslist.pprid});"/>
                        </Button>
                    </td>
                </tr>
            </c:forEach>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
            <table>
                <tr>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
        <%@include file="footerClient.jsp" %>
    </body>
</html>
