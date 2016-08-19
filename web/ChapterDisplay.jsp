<%-- 
    Document   : ChapterDisplay
    Created on : Apr 1, 2014, 2:28:44 PM
    Author     : asnthvinayak
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
        <title>Chapter Data Display</title>

        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />

        <script>
            function upd(id) {
                document.chapterDisplay.hid.value = id;
                chapterDisplay.action = "${pageContext.request.contextPath}/ChapterQuestionServlet/FetchServlet";
                chapterDisplay.submit();
            }
            function del(id) {
                document.chapterDisplay.hid.value = id;
                alert('Chapter Has Been Deleted');
                chapterDisplay.action = "${pageContext.request.contextPath}/ChapterQuestionServlet/DeleteServlet";
                chapterDisplay.submit();
            }
        </script>
    </head>
    <body bgcolor="Grey">
        <%@include file="headerClient.jsp" %>
        <form name="chapterDisplay" method="post">

            <u:if test="${chapterList==null}">
                <u:redirect url="ChapterQuestionServlet/ShowServlet"></u:redirect>
            </u:if>
            <input type="hidden" name="hid"/>
            <div class="borderdiv">
                <table width="100%" align="center" border="0">

                    <tr align="center">
                        <th><h3>Chapter Name</h3></th>&nbsp;&nbsp;
                    <th><h3>Unit Name</h3></th>&nbsp;&nbsp;
                    <th><h3>Subject Name</h3></th>&nbsp;&nbsp;
                    <th colspan="2"><h3>Action</h3></th>
                    </tr>
                    <tr>
                        <th colspan="6"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>
                    <u:forEach items="${chapterList}" var="cl">
                        <tr align="center">
                            <td>${cl.chapterName}</td>
                            <td>${cl.unitName}</td>
                            <td>${cl.subjectName}</td> 
                            <td><input type="submit" name="delete" value="Delete" onclick="del(${cl.chapterId})" class="clkbtn"/>
                                <input type="submit" name="update" value="Edit" onclick="upd(${cl.chapterId})" class="clkbtn"/></td>
                        </tr>
                    </u:forEach>
                    <tr>
                        <td></td>
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
