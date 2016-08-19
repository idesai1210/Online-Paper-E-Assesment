<%-- 
    Document   : index
    Created on : Apr 2, 2014, 12:19:14 PM
    Author     : HP I5
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${id==null}">
    <c:redirect url="Login.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evaluation</title>
        <link href="${pageContext.request.contextPath}/cssClient/templatemo_style.css" rel="stylesheet" type="text/css" />
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/EvaluationAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>
        
 
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script>
           
            var loadUni = function(data) {
                dwr.util.removeAllOptions('university');
                dwr.util.addOptions('university', data, 'uId', 'uName');
                
            }
            
//            var loadStateString = function(data) {
//                dwr.util.removeAllOptions('stateString');
//                dwr.util.addOptions('stateString', data);
//            }
//            
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
    
    <% 
            int rid=Integer.parseInt(session.getAttribute("rid").toString());
            int paperassignid=Integer.parseInt(session.getAttribute("paperassignid").toString());
            int assign_type=Integer.parseInt(session.getAttribute("assign_type").toString());
    %>
    <body onload="EvaluationAjax.pprassignList(<%=rid%>,<%=paperassignid%>,loadPpr)">
        <%@include  file="headerClient.jsp" %>
        
        <% if (assign_type==2){ %>
         <table border="0" align="center" style="width: 80%; height: 80%;">
            <tr>
                <td class="borderdiv">
                    <div >
                            <form name="f1" method="post" action="${pageContext.request.contextPath}/ListAnswerSheet">
                                <table  border="0" style="width: 100%; height: 100%;">
                                    
                                    <tr align="center">
                                        <th colspan="2"><h2>Select Your Credentials</h2></th>
                                    </tr>
                                    <tr>
                                        <td>Paper:</td>
                                        <td><select class="inpsel" name="paper" id="paper">
                                                
                                                <option value='-1'></option> 
                                            </select></td>   
                                    </tr>
                                    
                                    <tr align="center">
                                        <td colspan="2">
                                            <input type="submit" name="Insert" value="Select" class="clkbtn">
                                            </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
            <tr>
                <td>&nbsp;</td>
            </tr>
                </td>
            </tr>
         </table>
                                <%}%>
        <%@include file="footerClient.jsp" %>
    </body>
</html>
