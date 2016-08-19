<%-- 
    Document   : QuestionDisplay
    Created on : Apr 3, 2014, 10:00:18 AM
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
        <title>JSP Page</title>

        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />


        <script>
            function upd(id) {
                document.questionDisplay.hid.value = id;
                questionDisplay.action = "${pageContext.request.contextPath}/QuestionServlet/FetchServlet";
                questionDisplay.submit();
            }
            function del(id) {
                document.questionDisplay.hid.value = id;
                alert('Question Has Been Deleted');
                questionDisplay.action = "${pageContext.request.contextPath}/QuestionServlet/DeleteServlet";
                questionDisplay.submit();
            }
        </script>
    </head>
    <body>
        <%@include file="headerClient.jsp" %>
        <form name="questionDisplay" method="post">

            <u:if test="${questionList==null}">
                <u:redirect url="QuestionServlet/ShowServlet"></u:redirect>
            </u:if>
            <input type="hidden" name="hid"/>
            <div class="borderdiv">
                <table width="100%" align="center" border="0">

                    <tr align="center">
                        <th><h3>No. Of Question</h3></th>
                    <th><h3>Question Description</h3></th>
                    <th><h3>Topic Name</h3></th>
                    <th><h3>Chapter Name</h3></th>
                    <th><h3>Unit Name</h3></th>
                    <th><h3>Subject Name</h3></th>
                    <th><h3>Question Type</h3></th>
                    <th><h3>Question Marks</h3></th>
                    <th><h3>Option For Mcq</h3></th>
                    <th colspan="2"><h3>Action</h3></th>
                    </tr>
                    <tr>
                        <th colspan="11"><h3><hr color="#c0c0c0"></h3></th>
                    </tr>

                    <u:forEach items="${questionList}" var="ql" varStatus="varcount">
                        <tr align="center">
                            <td>${varcount.count}</td>
                            <td>${ql.question}</td>
                            <td>${ql.topicName}</td>
                            <td>${ql.chapterName}</td>
                            <td>${ql.unitName}</td>
                            <td>${ql.subjectName}</td>
                            <td>${ql.questionTypeName}</td>
                            <td>${ql.defaultMark}</td>
                            <td>${ql.option1}</td>
                            <td><input type="submit" name="delete" value="Delete" onclick="del(${ql.questionId})" class="clkbtn"/>
                            </td>
                        </tr>
                    </u:forEach>
                    <tr>
                        <td></td>
                    </tr>
                    <tr align="right">
                        <td colspan="11"><a  href="${pageContext.request.contextPath}/QuestionInsert.jsp">Back To Insert Question</a></td>
                    </tr>
                </table>
            </div>
            <br>

        </form>
        <%@include  file="footerClient.jsp" %>
    </body>
</html>
