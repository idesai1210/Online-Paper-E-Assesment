<%-- 
    Document   : index
    Created on : Apr 2, 2014, 12:19:14 PM
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
        <link href="${pageContext.request.contextPath}/cssClient/templatemo_style.css" rel="stylesheet" type="text/css" />
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/EvaluationAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>
        
 
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script> 
            function path(){
                f1.action="${pageContext.request.contextPath}/AnswerSheetUpServlet/File";
                f1.submit();
            }
            var loadCollege = function(data) {
                dwr.util.removeAllOptions('college_id');
                dwr.util.addOptions('college_id', data, 'collId', 'collName');
            }
            var loadDpt = function(data) {
                dwr.util.removeAllOptions('department');
                dwr.util.addOptions('department', data, 'dptId', 'dptName');
            }
            var loadDeg = function(data) {
                dwr.util.removeAllOptions('degree_id');
                dwr.util.addOptions('degree_id', data, 'degId', 'degName');
            }
            
            var loadSub = function(data) {
                dwr.util.removeAllOptions('subject');
                dwr.util.addOptions('subject', data, 'subId', 'subName');
            }
            var loadPpr = function(data) {
                dwr.util.removeAllOptions('paper');
                dwr.util.addOptions('paper', data, 'pprId', 'pprName');
            }
            </script>
    </head>
    <body onload="EvaluationAjax.collegeList(loadCollege)">
        <%@include  file="headerClient.jsp" %>
        
         <table border="0" align="center" style="width: 80%; height: 80%;">
            <tr>
                <td class="borderdiv">
                    <div >
                            <form name="f1" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/FileUploadServlet">
                                <table  border="0">
                                    
                                    <tr align="center">
                                        <th colspan="2"><h2>Select Your Credentials</h2></th>
                                    </tr>
                                      <tr>
                                        <td>College:</td>
                                        <td>
                                            <select class="inpsel" name="college_id" id="college_id" onchange="EvaluationAjax.dptList(this.value,loadDpt)">
<!--                                                <option value="">-- College --</option>-->
                                                <option value='-1'></option>  
                                            </select>
                                        </td>   
                                    </tr>
                                    <tr>
                                        <td>Department:</td>
                                        <td><select class="inpsel" name="department" id="department" onchange="EvaluationAjax.degreeList(this.value,loadDeg)">
                                                <option value='-1'></option> 
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Degree:</td>
                                        <td>
                                            <select class="inpsel" name="degree_id" id="degree_id" onchange="EvaluationAjax.subList(this.value,loadSub)">
                                                <option value='-1'></option> 
                                            </select>
                                        </td>   
                                    </tr>
                                    <tr>
                                        <td>Subject:</td>
                                        <td><select class="inpsel" name="subject" id="subject" onchange="EvaluationAjax.pprList(this.value,loadPpr)">
                                                
                                                <option value='-1'></option> 
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Paper:</td>
                                        <td><select class="inpsel" name="paper" id="paper">
                                                
                                                <option value='-1'></option> 
                                            </select></td>   
                                    </tr>
                                    <tr>
                                        <td>Enrollment Id:</td>
                                        <td>
                                        <input type="text" id="enrollid" name="enrollid"/>
                                        </td>
                                    </tr>
                                    
                                    <tr align="center">
                                        <td>
                                            <input type="file" name="file" multiple/>
                                        </td>
                                        <td>
                                            <input type="button" name="setpath" value="Setpath" onclick="path();"
                                        </td>
                                        <td colspan="2">
                                            <input type="submit" name="upload" value="Upload" class="clkbtn">
                                            </td>
                                    </tr>
                                    <tr>
                                        <% 
                                            if(request.getAttribute("path1")!=null)
                                            {   
                                                out.println("The path selected is:"+request.getAttribute("path1"));
                                            }
                                            %>
                                    </tr>
                                     <tr>
                                        <% 
                                            
                                            if(request.getAttribute("mk")!=null)
                                            {   
                                                out.println(request.getAttribute("mk"));
                                            }
                                            %>
                                    </tr>
                                    
                                </table>
                            </form>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>   
                        </div>
                </td>
            </tr>
         </table>
        <%@include file="footerClient.jsp" %>
    </body>
</html>
