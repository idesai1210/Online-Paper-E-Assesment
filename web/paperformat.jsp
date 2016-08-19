<%-- 
    Document   : paperformat
    Created on : Apr 29, 2014, 11:39:08 AM
    Author     : HP I5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>

<u:if test="${id==null}">
    <u:redirect url="Login.jsp"></u:redirect>
</u:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paper Formate Jsp</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />
        <script>
            function ins(){
                alert('@..Data Inserted Successfully..@');
                paperformat.action="${pageContext.request.contextPath}/PaperFormatServlet/InsertServlet";
                paperformat.submit();
            }
            function sel(){
                paperformat.action="${pageContext.request.contextPath}/PaperFormatServlet/ShowServlet";
                paperformat.submit();
            }
        </script>
    </head>
    <body bgcolor="Grey">
        <%@include  file="headerClient.jsp"%>

        <table border="0" align="center" style="width: 80%; height: 80%;">
            <tr>
                <td class="borderdiv">
                    <form name="paperformat" method="post" action="">
                        <u:if test="${subjectList==null}">
                            <u:redirect url="PaperFormatServlet/SubjectDataServlet"></u:redirect>
                        </u:if>

                        <table  border="0" align="center">

                            <tr align="center">
                                <th colspan="2"><h2>Paper Format Detail</h2></th>
                            </tr>
                            <tr>
                                <td>Subject:</td>
                                <td><select name="subjectName" class="inpsel">
                                        <option>--- none ---</option>
                                        <u:forEach items="${subjectList}" var="sl">
                                            <option value="${sl.subId}">${sl.subject}</option>
                                        </u:forEach>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Exam Type:</td>
                                <td><select class="inpsel" name="examType">
                                        <option>--- none ---</option>
                                        <option value="1">Internal</option>
                                        <option value="2">External</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Paper Name/Code:</td>
                                <td><input type="text" name="paperName" class="inptxt"/></td>
                            </tr>
                            <tr>
                                <td>Exam Date:</td>
                                <td><input type="text" name="examDate" class="inptxt"/></td>
                            </tr>
                            <tr>
                                <td>Exam Duration:</td>
                                <td><input type="text" name="examtime" class="inptxt"/></td>
                            </tr>
                            <tr>
                                <td>Paper Generated Date:</td>
                                <td><input type="text" name="paperGDate" class="inptxt"/></td>
                            </tr>
                            <tr>
                                <td>Paper Related Note:</td>
                                <td><input type="text" name="notes" class="inptxt"/></td>
                            </tr>
                            <tr align="center">
                                <td colspan="4"><input type="submit" name="insert" value="Submit" onclick="ins()"/>
                                    <%  int uid = Integer.parseInt(session.getAttribute("id").toString());
                                             if (uid == 2) {%>
                                             <input type="submit" name="select" value="Show Paper List" onclick="sel();"/>
                                    <%}%>
                                </td>
                            </tr>

                        </table>
                    </form>
                </td>
            </tr>

        </table>

        <br>
        <%@include  file="footerClient.jsp" %>
    </body>
</html>
