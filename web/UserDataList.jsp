<%-- 
    Document   : UserList
    Created on : Mar 22, 2014, 12:59:15 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="u"%>
<u:if test="${id==null}">
    <u:redirect url="Login.jsp"></u:redirect>
</u:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />
        <script>
            function callAssign(){
                userDisp.action="${pageContext.request.contextPath}/AssignExamServlet/InsertServlet";
                userDisp.submit();
            }
            function callShowList(){
                userDisp.action="${pageContext.request.contextPath}/AssignExamServlet/ShowServlet";
                userDisp.submit();
            }
            function callExamBlockTxt(){
                document.getElementById("txtExamBlockDiv").style.display="block";
                
            }
        </script>
    </head>
    <body>
        <%@include file="headerClient.jsp" %>
        <form action="" name="userDisp" method="post">
            <u:if test="${ulist==null}">
                <u:redirect url="/AssignExamServlet/ShowUserDataServlet" ></u:redirect>
            </u:if>

            <input type="hidden" name="hid"/>
            <div class="borderdiv">
                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                    <tr>
                        <td class="tdexam" colspan="6">Assign Type:

                            <u:forEach items="${paperAssignList}" var="pal">
                                <input type="radio" name="assign" value="${pal.paperAssignId}" <u:if test="${pal.paperAssignId==2}"> onclick="callExamBlockTxt()" </u:if>>${pal.paperAssignType}
                            </u:forEach>
                                
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            
                            Select Subject:
                            <select class="inpsel" name="subject">
                                <option align="center">---Subject---</option>
                                <u:forEach items="${subjectList}" var="sl">
                                    <option value="${sl.subjectid}">${sl.subjectname}</option>
                                </u:forEach>
                            </select>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td class="tdexam" colspan="6">
                            <div id="txtExamBlockDiv" name="txtdiv" style="display: none">
                                Enter Exam Block:
                                <input type="text" name="eBlock" class="inptxt"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                    <th><h3>No.</h3></th>
                    <th><h3>Full Name</h3></th>
                    <th><h3>College Name</h3></th>
                    <th><h3>Department Name</h3></th>
                    <th><h3>Degree Name</h3></th>
                    <th><h3>Experience</h3></th>
                    </tr>
                    <tr>
                        <th colspan="6"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>

                    <u:forEach var="ul" items="${ulist}">
                        <tr align="center">
                            <td><input type="checkbox" name="userId" value="${ul.user_id}"/></td>
                            <td>${ul.fname} &nbsp; ${ul.mname} &nbsp; ${ul.lname}</td>
                            <td>${ul.collegeName}</td>
                            <td>${ul.departmentName}</td>
                            <td>${ul.degreeName}</td>
                            <td>${ul.experience}</td>
                        </tr>
                    </u:forEach>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr align="center">
                        <td colspan="6"><input type="submit" name="submit" value="Assign" class="clkbtn" onclick="callAssign();"/>
                            <input type="submit" name="submit" value="Show List" class="clkbtn" onclick="callShowList();"/></td>
                    </tr>
                </table>
            </div>
            <br>
        </form>

        <%@include file="footerClient.jsp" %>

    </body>
</html>
