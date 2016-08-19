<%-- 
    Document   : TopicDisplay
    Created on : Apr 1, 2014, 2:33:15 PM
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
        <title>Topic Data Display</title>

        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />

        <script>
            function upd(id) {
                document.topicDisplay.hid.value = id;
                topicDisplay.action = "${pageContext.request.contextPath}/TopicQuestionServlet/FetchServlet";
                topicDisplay.submit();
            }
            function del(id) {
                document.topicDisplay.hid.value = id;
                alert('Topic Has Been Deleted');
                topicDisplay.action = "${pageContext.request.contextPath}/TopicQuestionServlet/DeleteServlet";
                topicDisplay.submit();
            }
        </script>
    </head>
    <body bgcolor="Grey">
        <%@include file="headerClient.jsp" %>
        <form name="topicDisplay" method="post">

            <u:if test="${topicList==null}">
                <u:redirect url="TopicQuestionServlet/ShowServlet"></u:redirect>
            </u:if>
            <input type="hidden" name="hid"/>
            <div class="borderdiv">
                <table width="100%" align="center" border="0">

                    <tr align="center">
                        <th><h3>Topic Name</h3></th>
                    <th><h3>Chapter Name</h3></th>
                    <th><h3>Unit Name</h3></th>
                    <th><h3>Subject Name</h3></th>
                    <th colspan="2"><h3>Action</h3></th>
                    </tr>
                    <tr>
                        <th colspan="6"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>

                    <u:forEach items="${topicList}" var="tl">
                        <tr align="center">
                            <td>${tl.topicName}</td>
                            <td>${tl.chapterName}</td>
                            <td>${tl.unitName}</td>
                            <td>${tl.subjectName}</td> 
                            <td><input type="submit" name="delete" value="Delete" onclick="del(${tl.topicId})" class="clkbtn"/>
                                <input type="submit" name="update" value="Edit" onclick="upd(${tl.topicId})" class="clkbtn"/></td>
                        </tr>
                    </u:forEach>
                    <tr>
                        <td></td>
                    </tr>
                    <tr align="right">
                        <td colspan="6"><a  href="${pageContext.request.contextPath}/QuestionInsert.jsp">Back To Insert Question</a></td>
                    </tr>
                </table>
            </div>
            <br>
        </form>
        <%@include  file="footerClient.jsp" %>
    </body>
</html>
