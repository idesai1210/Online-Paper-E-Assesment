<%-- 
    Document   : PaperCreaiton
    Created on : May 1, 2014, 8:26:51 PM
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
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css" />
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/QuestionAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>

        <script>
            
            var LoadUnitQuestion=function(data)
            {
                dwr.util.removeAllOptions('UnitQuestion');
                dwr.util.addOptions('UnitQuestion',data,'unitId','unitName');
            }
           
            var LoadChapterQuestion=function(data)
            {
                dwr.util.removeAllOptions('ChapterQuestion');
                dwr.util.addOptions('ChapterQuestion',data,'chapterId','chapterName');
            }
            var LoadTopicQuestion=function(data)
            {
                dwr.util.removeAllOptions('TopicQuestion');
                dwr.util.addOptions('TopicQuestion',data,'topicId','topicName');
            }
        </script>

    </head>
    <body>
        <%@include  file="headerClient.jsp"%>

        <table border="0" align="center" style="width: 100%; height: 100%;">
            <tr>
                <td class="borderdiv">
                    <form name="QuestionType" method="post" action="">
                        <table  border="0">
                            <u:if test="${topicList==null}">
                                <u:redirect url="PaperCreationServlet"></u:redirect>
                            </u:if>
                            <tr align="center">
                                <th colspan="3"><h2>Select Question Type</h2></th>
                            </tr>
                            <tr>
                                <td>Select Subject:</td>
                                <td><select name="subjectName" class="inpsel" onchange="QuestionAjax.dispUnit(this.value,LoadUnitQuestion)">
                                        <option>---Subject---</option>
                                        <u:forEach items="${subjectList}" var="sl">
                                            <option value="${sl.subjectid}" >  ${sl.subjectname} </option>
                                        </u:forEach>
                                    </select></td>  
                                <td><input type="submit" name="ok" value="Click"/></td>
                            </tr>
                            <tr>
                                <td>Unit Wise Question:</td>
                                <td><select name="unitName" class="inpsel" id="UnitQuestion" onchange="QuestionAjax.dispChapter(this.value,LoadChapterQuestion)">
                                        <option>---Unit---</option>
                                        <u:forEach items="${unitList}" var="ul">
                                            <option value="${ul.unitQuestionId}" >  ${ul.unitQuestionName} </option>
                                        </u:forEach>
                                    </select></td>   
                                <td><input type="submit" name="ok" value="Click"/></td>
                            </tr>
                            <tr>
                                <td>Chapter: Wise Question:</td>
                                <td><select name="chapterName" id="ChapterQuestion" class="inpsel" onchange="QuestionAjax.dispTopic(this.value,LoadTopicQuestion)">
                                        <option>---Chapter---</option>
                                        <u:forEach items="${chapterList}" var="cl">
                                            <option value="${cl.chapterId}" >  ${cl.chapterName} </option>
                                        </u:forEach>
                                    </select></td>   
                                <td><input type="submit" name="ok" value="Click"/></td>
                            </tr>
                            <tr>
                                <td>Topic Wise Question:</td>
                                <td><select name="topicName" id="TopicQuestion"class="inpsel">
                                        <option>---Topic---</option>
                                        <u:forEach items="${topicList}" var="tl">
                                            <option value="${tl.topicId}" >  ${tl.topicName} </option>
                                        </u:forEach>
                                    </select></td>   
                                <td><input type="submit" name="ok" value="Click"/></td>
                            </tr>


                            <tr><td></td></tr>
                            <tr><td></td></tr>
                            <tr><td></td></tr>
                            <tr><td></td></tr>
                        </table>
                    </form>
                </td>
                <td>&nbsp;&nbsp;</td>
                <td class="borderdiv">
                    <form name="QuestionType" method="post" action="">
                        <table  border="0">
                            <tr align="left">
                                <th>Question List:</th>
                            </tr>
                            <tr>
                                <td><select multiple="multile" style="width: 500px; height: 300px;">
                                        <option>-- none --</option>
                                    </select></td>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>

            <tr>
                <td colspan="3" class="borderdiv"></td>
            </tr>
        </table>
        <br>
        <%@include file="footerClient.jsp" %>
    </body>
</html>
