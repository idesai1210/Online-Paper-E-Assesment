<%-- 
   Document   : UnitQuestionInsert
   Created on : Mar 27, 2014, 10:47:31 PM
   Author     : Bhumi
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
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/QuestionAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>

        <script>
            var LoadSubject=function(data){
                dwr.util.removeAllOptions('Subject');
                dwr.util.addOptions('Subject',data,'subjectId','subjectName');
            }
            var LoadUnitChapter=function(data)
            {
                dwr.util.removeAllOptions('UnitChapter');
                dwr.util.addOptions('UnitChapter',data,'unitId','unitName');
            }
            var LoadUnitTopic=function(data)
            {
                dwr.util.removeAllOptions('UnitTopic');
                dwr.util.addOptions('UnitTopic',data,'unitId','unitName');
            }
            var LoadUnitQuestion=function(data)
            {
                dwr.util.removeAllOptions('UnitQuestion');
                dwr.util.addOptions('UnitQuestion',data,'unitId','unitName');
            }
            var LoadChapterTopic=function(data)
            {
                dwr.util.removeAllOptions('ChapterTopic');
                dwr.util.addOptions('ChapterTopic',data,'chapterId','chapterName');
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
            function callShowUnit(){
                unitinsert.action="${pageContext.request.contextPath}/UnitQuestionServlet/ShowServlet";
                unitinsert.submit();
            }
            function callInsertUnit(){
                
                if(document.unitinsert.unitName.value==="")
                {
                    alert("Please Enter Value");
                }
                else
                {
                   
                unitinsert.action="${pageContext.request.contextPath}/UnitQuestionServlet/InsertServlet";
                unitinsert.submit();
                }
            }
            function callUpdateUnit(){
                alert('Unit Data Has Been Updated');
                unitUpdate.action="${pageContext.request.contextPath}/UnitQuestionServlet/UpdateServlet";
                unitUpdate.submit();
            }
            function callShowChapter(){
                chapterinsert.action="${pageContext.request.contextPath}/ChapterQuestionServlet/ShowServlet";
                chapterinsert.submit();
            }
            function callInsertChapter(){
                if(document.chapterinsert.chapterName.value==="")
                {
                    alert("Please Enter Value");
                }
                else{
                
                chapterinsert.action="${pageContext.request.contextPath}/ChapterQuestionServlet/InsertServlet";
                chapterinsert.submit();
            }
            }
            function callUpdateChapter(){
                alert('Chapter Data Has Been Updated');
                chapterupdate.action="${pageContext.request.contextPath}/ChapterQuestionServlet/UpdateServlet";
                chapterupdate.submit();
            }
            function callShowTopic(){
                topicinsert.action="${pageContext.request.contextPath}/TopicQuestionServlet/ShowServlet";
                topicinsert.submit();
            }
            function callInsertTopic(){
                if(document.topicinsert.topicName.value==="")
                {
                    alert("Please Enter Value");
                }
                    else{
                
                topicinsert.action="${pageContext.request.contextPath}/TopicQuestionServlet/InsertServlet";
                topicinsert.submit();
            }
            }
            function callUpdateTopic(){
                alert('Topic Data Has Been Updated');
                topicupdate.action="${pageContext.request.contextPath}/TopicQuestionServlet/UpdateServlet";
                topicupdate.submit();
            }
            function callShowQuestion(){
                queInsert.action="${pageContext.request.contextPath}/QuestionServlet/ShowServlet";
                queInsert.submit();
            }
            function callInsertQuestion(){
                if(document.queInsert.question.value==="")
                {
                    alert("Please Enter Value");
                }
                else{
                
                queInsert.action="${pageContext.request.contextPath}/QuestionServlet/InsertServlet";
                queInsert.submit();
            }
            }
            function callMcqTxt(){
                document.getElementById("txtMcqDiv").style.display="block";
                
            }
        </script>
    </head>
    <body bgcolor="Grey">
        <%@include  file="headerClient.jsp"%>
        <table border="0" align="center" style="width: 80%; height: 80%;">
            <tr>
                <td class="borderdiv">

                    <u:if test="${unitUpdateList==null}">
                        <div >
                            <form name="unitinsert" method="post" action="">
                                <table  border="0">
                                    <u:if test="${questionTypeList==null}">
                                        <u:redirect url="TopicQuestionServlet/CallChapterServlet"></u:redirect>
                                    </u:if>
                                    <tr align="center">
                                        <th colspan="2"><h2>Insert Unit</h2></th>
                                    </tr>
                                    
                                    <tr>
                                        <td>Subject:</td>
                                        <td><select class="inpsel" name="subjectName">
                                                <option>---Subject---</option>
                                                <u:forEach items="${subjectList}" var="sl">
                                                    <option value="${sl.subjectid}">  ${sl.subjectname} </option>
                                                </u:forEach>
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Enter Unit Name:</td>
                                        <td><input type="text" class="inptxt" name="unitName"></td>
                                    </tr>
                                    <tr></tr>
                                    <tr align="center">
                                        <td colspan="2"><input type="submit" name="Insert" value="Insert" class="clkbtn" onclick="callInsertUnit();">
                                            <input type="submit" name="display" value="Show Data" onclick="callShowUnit()" class="clkbtn"></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </u:if>
                    <u:if test="${unitUpdateList!=null}">
                        <div>
                            <form name="unitUpdate" method="post" action="">
                                <u:forEach items="${unitUpdateList}" var="ul">
                                    <input type="hidden" name="hid" value="${ul.unitQuestionId}"/>

                                    <table  border="0">
                                        <tr align="center">
                                            <th colspan="2"><h2>Update Unit</h2></th>
                                        </tr>
                                        <tr>
                                            <td>Subject:</td>
                                            <td><select class="inpsel" name="subjectName">
                                                    <option>---Subject---</option>
                                                    <u:forEach items="${subjectList}" var="sl">
                                                        <option value="${sl.subjectid}" <u:if test="${sl.subjectid==ul.subjectid}">selected</u:if> > ${sl.subjectname} </option>
                                                    </u:forEach>

                                                </select></td>   
                                        </tr>
                                        <tr>
                                            <td>Enter Unit Name:</td>
                                            <td><input type="text" class="inptxt" name="unitName" value="${ul.unitQuestionName}"></td>
                                            </u:forEach>
                                    </tr>
                                    <tr></tr>
                                    <tr align="center">
                                        <td colspan="2"><input type="submit" name="update" value="Update" class="clkbtn" onclick="callUpdateUnit();"></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </u:if>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td class="borderdiv">
                    <u:if test="${chapterUpdateList==null}">
                        <div>
                            <form name="chapterinsert"  method="post" action="">
                                <table  border="0">
                                    <tr align="center">
                                        <th colspan="2"><h2>Insert Chapter</h2></th>
                                    </tr>
                                    <tr>
                                        <td>Subject:</td>
                                        <td><select name="subjectName" class="inpsel" onchange="QuestionAjax.dispUnit(this.value,LoadUnitChapter)">
                                                <option value="-1">---Subject---</option>
                                                <u:forEach items="${subjectList}" var="sl">
                                                    <option value="${sl.subjectid}">  ${sl.subjectname} </option>
                                                </u:forEach>
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Select Unit:</td>
                                        <td><select name="unitName" id="UnitChapter" class="inpsel">
                                                <option value="-1">---Unit---</option>
                                                <u:forEach items="${unitList}" var="ul">
                                                    <option value="${ul.unitQuestionId}">  ${ul.unitQuestionName} </option>
                                                </u:forEach>
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Enter Chapter Of Unit:</td>
                                        <td><input type="text" name="chapterName" class="inptxt"></td>
                                    </tr>
                                    <tr align="center">
                                        <td colspan="2"><input type="submit" name="Insert" value="Insert" class="clkbtn" onclick="callInsertChapter();">
                                            <input type="submit" name="display" value="Show Data" onclick="callShowChapter()" class="clkbtn"></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </u:if>
                    <u:if test="${chapterUpdateList!=null}">
                        <div >
                            <form name="chapterupdate" method="post" action="">
                                <table  border="0">

                                    <u:forEach items="${chapterUpdateList}" var="cul">
                                        <input type="hidden" name="hid" value="${cul.chapterId}"/>


                                        <tr align="center">
                                            <th colspan="2"><h2>Update Chapter</h2></th>
                                        </tr>
                                        <tr>
                                            <td>Subject:</td>
                                            <td><select name="subjectName" class="inpsel">
                                                    <option>---Subject---</option>
                                                    <u:forEach items="${subjectList}" var="sl">
                                                        <option value="${sl.subjectid}" <u:if test="${sl.subjectid==cul.subjectId}">selected</u:if> >  ${sl.subjectname} </option>
                                                    </u:forEach>
                                                </select></td>   
                                        </tr>
                                        <tr>
                                            <td>Select Unit:</td>
                                            <td><select name="unitName" class="inpsel">
                                                    <option>---Unit---</option>
                                                    <u:forEach items="${unitList}" var="ul">
                                                        <option value="${ul.unitQuestionId}" <u:if test="${ul.unitQuestionId==cul.unitId}">selected</u:if> >  ${ul.unitQuestionName} </option>
                                                    </u:forEach>
                                                </select></td>   
                                        </tr>
                                        <tr>
                                            <td>Enter Chapter Of Unit:</td>
                                            <td><input type="text" name="chapterName" value="${cul.chapterName}" class="inptxt"></td>
                                            </u:forEach>
                                    </tr>
                                    <tr align="center">
                                        <td colspan="2"><input type="submit" name="update" value="Update" class="clkbtn" onclick="callUpdateChapter();"></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </u:if>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td  class="borderdiv">
                    <u:if test="${topicUpdateList==null}">
                        <div>
                            <form name="topicinsert" method="post" action="">
                                <table  border="0">
                                    <tr align="center">
                                        <th colspan="2"><h2> Insert Topic</h2></th>
                                    </tr>
                                   
                                    <tr>
                                        <td>Subject:</td>
                                        <td><select name="subjectName" class="inpsel" onchange="QuestionAjax.dispUnit(this.value,LoadUnitTopic)">
                                                <option>---Subject---</option>
                                                <u:forEach items="${subjectList}" var="sl">
                                                    <option value="${sl.subjectid}" >  ${sl.subjectname} </option>
                                                </u:forEach>
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Select Unit:</td>
                                        <td><select name="unitName" id="UnitTopic" class="inpsel" onchange="QuestionAjax.dispChapter(this.value,LoadChapterTopic)">
                                                <option value="-1">---Unit---</option>
                                                <u:forEach items="${unitList}" var="ul">
                                                    <option value="${ul.unitQuestionId}" >  ${ul.unitQuestionName} </option>
                                                </u:forEach>
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Select Chapter:</td>
                                        <td><select  name="chapterName" id="ChapterTopic" class="inpsel">
                                                <option value="-1">---Chapter---</option>
                                                <u:forEach items="${chapterList}" var="cl">
                                                    <option value="${cl.chapterId}" >  ${cl.chapterName} </option>
                                                </u:forEach>
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Enter Topic Of Chapter:</td>
                                        <td><input type="text" name="topicName" class="inptxt"></td>
                                    </tr>

                                    <tr align="center">
                                        <td colspan="2"><input type="submit" name="Insert" value="Insert" class="clkbtn" onclick="callInsertTopic();">
                                            <input type="submit" name="display" value="Show Data" onclick="callShowTopic()" class="clkbtn"></td>
                                    </tr>
                                     <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </u:if>
                    <u:if test="${topicUpdateList!=null}">
                        <div>
                            <form name="topicupdate" method="post" action="">
                                <u:forEach items="${topicUpdateList}" var="tul">
                                    <input type="hidden" name="hid" value="${tul.topicId}"/>

                                    <table  border="0">
                                        <tr align="center">
                                            <th colspan="2"><h2>Update Topic</h2></th>
                                        </tr>
                                        <tr>
                                            <td>Subject:</td>
                                            <td><select name="subjectName" class="inpsel">
                                                    <option>---Subject---</option>
                                                    <u:forEach items="${subjectList}" var="sl">
                                                        <option value="${sl.subjectid}"  <u:if test="${sl.subjectid==tul.subjectId}">selected</u:if> >  ${sl.subjectname} </option>
                                                    </u:forEach>
                                                </select></td>   
                                        </tr>
                                        <tr>
                                            <td>Select Unit:</td>
                                            <td><select name="unitName" class="inpsel">
                                                    <option>---Unit---</option>
                                                    <u:forEach items="${unitList}" var="ul">
                                                        <option value="${ul.unitQuestionId}" <u:if test="${ul.unitQuestionId==tul.unitId}">selected</u:if> >  ${ul.unitQuestionName} </option>
                                                    </u:forEach>
                                                </select></td>   
                                        </tr>
                                        <tr>
                                            <td>Select Chapter:</td>
                                            <td><select name="chapterName" class="inpsel">
                                                    <option>---Chapter---</option>
                                                    <u:forEach items="${chapterList}" var="cl">
                                                        <option value="${cl.chapterId}"  <u:if test="${cl.chapterId==tul.chapterId}">selected</u:if> >  ${cl.chapterName} </option>
                                                    </u:forEach>
                                                </select></td>   
                                        </tr>
                                        <tr>
                                            <td>Enter Topic Of Chapter:</td>
                                            <td><input type="text" name="topicName" value="${tul.topicName}" class="inptxt"></td>
                                            </u:forEach>
                                    </tr>

                                    <tr align="center">
                                        <td colspan="2"><input type="submit" name="update" value="Update" class="clkbtn" onclick="callUpdateTopic();"></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </u:if>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>
                    <div class="borderdiv">
                        <form name="queInsert" method="post" action="">
                            <table  border="0">
                                <tr align="center">
                                    <th colspan="2"><h2>Insert Question</h2></th>
                                </tr>
                                <tr>
                                    <td>Subject:</td>
                                    <td><select name="subjectName" class="inpsel" onchange="QuestionAjax.dispUnit(this.value,LoadUnitQuestion)">
                                            <option>---Subject---</option>
                                            <u:forEach items="${subjectList}" var="sl">
                                                <option value="${sl.subjectid}" >  ${sl.subjectname} </option>
                                            </u:forEach>
                                        </select></td>   
                                </tr>
                                <tr>
                                    <td>Select Unit:</td>
                                    <td><select name="unitName" class="inpsel" id="UnitQuestion" onchange="QuestionAjax.dispChapter(this.value,LoadChapterQuestion)">
                                            <option>---Unit---</option>
                                            <u:forEach items="${unitList}" var="ul">
                                                <option value="${ul.unitQuestionId}" >  ${ul.unitQuestionName} </option>
                                            </u:forEach>
                                        </select></td>   
                                </tr>
                                <tr>
                                    <td>Select Chapter:</td>
                                    <td><select name="chapterName" id="ChapterQuestion" class="inpsel" onchange="QuestionAjax.dispTopic(this.value,LoadTopicQuestion)">
                                            <option>---Chapter---</option>
                                            <u:forEach items="${chapterList}" var="cl">
                                                <option value="${cl.chapterId}" >  ${cl.chapterName} </option>
                                            </u:forEach>
                                        </select></td>   
                                </tr>
                                <tr>
                                    <td>Select Topic:</td>
                                    <td><select name="topicName" id="TopicQuestion"class="inpsel">
                                            <option>---Topic---</option>
                                            <u:forEach items="${topicList}" var="tl">
                                                <option value="${tl.topicId}" >  ${tl.topicName} </option>
                                            </u:forEach>
                                        </select></td>   
                                </tr>
                                <tr>
                                    <td>Enter Question:</td>
                                    <td><input type="text" name="question" class="inptxt"/></td>
                                </tr>
                                <tr>
                                    <td>Enter Marks Of Question:</td>
                                    <td><input type="text" name="mark" class="inptxt"/></td>
                                </tr>
                                <tr>
                                    <td>Type Of Question:</td>
                                    <td> 
                                        <u:forEach items="${questionTypeList}" var="tl">
                                            <input type="radio" name="questionType" value="${tl.questionTypeId}" <u:if test="${tl.questionTypeId==1}"> onclick="callMcqTxt()" </u:if> > ${tl.questionTypeName}
                                        </u:forEach>
                                    </td>
                                </tr>

                                <tr><td colspan="2">
                                        <div id="txtMcqDiv" name="txtdiv" style="display: none">
                                            <table>
                                                <tr>
                                                    <td style="width: 50%;">Enter Option1:</td>
                                                    <td><input type="text" name="option1" class="inptxt"/></td>
                                                </tr>
                                                <tr>
                                                    <td> Enter Option2:</td>
                                                    <td><input type="text" name="option2" class="inptxt"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Enter Option3:</td>
                                                    <td><input type="text" name="option3" class="inptxt"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Enter Option4:</td>
                                                    <td><input type="text" name="option4" class="inptxt"/></td>
                                                </tr>
                                            </table>
                                        </div>  
                                    </td></tr>

                                <tr align="center">
                                    <td colspan="2"><input type="submit" name="Insert" value="Insert" class="clkbtn" onclick="callInsertQuestion();">
                                        <input type="submit" name="display" value="Show Data" onclick="callShowQuestion()" class="clkbtn"></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
        </table>

        <%@include file="footerClient.jsp" %>
    </body>
</html>
