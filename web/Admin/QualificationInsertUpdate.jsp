<%-- 
    Document   : QualificationUpdate
    Created on : Mar 13, 2014, 11:28:27 AM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="q"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Qualification Insert Update</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script>
            function shw() {
                f1.action = "${pageContext.request.contextPath}/QualificationServlet/ShowServlet";
                f1.submit();
            }
        </script>
    </head>
    <body> 
        <%@include file="header.jsp" %>

        <q:if test="${qualiList==null}">
            <div id="page-heading">
                <h1>Insert Qualification</h1>
            </div>


            <table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
                <tr>
                    <th rowspan="3" class="sized"><img src="${pageContext.request.contextPath}/Admin/images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
                    <th class="topleft"></th>
                    <td id="tbl-border-top">&nbsp;</td>
                    <th class="topright"></th>
                    <th rowspan="3" class="sized"><img src="${pageContext.request.contextPath}/Admin/images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
                </tr>
                <tr>
                    <td id="tbl-border-left"></td>
                    <td>
                        <!--  start content-table-inner -->
                        <div id="content-table-inner">

                            <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                <tr valign="top">
                                    <td>

                                        <!--  start product-table ..................................................................................... -->
                                        <form id="qualiform" name="f1" method="post" action="${pageContext.request.contextPath}/QualificationServlet/InsertServlet">

                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                <tr>
                                                    <th>Qualification Name:</th>
                                                    <td><input type="text" name="qualificationName" class="inp-form"/></td>
                                                   <!-- <td></td>-->
                                                    
                                                </tr>
                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Insert" name="Insert" class="form-submit" />

                                                        <input type="submit" value="Show" onclick="shw();" class="form-show" />


                                                    </td>
                                                    
                                                   
                                                </tr>

                                            </table>
                                            <!-- end id-form  -->
                                        </form>
                                    </td>

                                </tr>
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/Admin/images/shared/blank.gif" width="695" height="1" alt="blank" /></td>
                                    <td></td>
                                </tr>
                            </table>

                            <div class="clear"></div>


                        </div>
                        <!--  end content-table-inner  -->
                    </td>
                    <td id="tbl-border-right"></td>
                </tr>
                <tr>
                    <th class="sized bottomleft"></th>
                    <td id="tbl-border-bottom">&nbsp;</td>
                    <th class="sized bottomright"></th>

                </tr>

            </table>
        </q:if>
        <q:if test="${qualiList!=null}">
            <div id="page-heading">
                <h1>Edit Qualification Data</h1>
            </div>


            <table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
                <tr>
                    <th rowspan="3" class="sized"><img src="${pageContext.request.contextPath}/Admin/images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
                    <th class="topleft"></th>
                    <td id="tbl-border-top">&nbsp;</td>
                    <th class="topright"></th>
                    <th rowspan="3" class="sized"><img src="${pageContext.request.contextPath}/Admin/images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
                </tr>
                <tr>
                    <td id="tbl-border-left"></td>
                    <td>
                        <!--  start content-table-inner -->
                        <div id="content-table-inner">

                            <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                <tr valign="top">
                                    <td>


                                        <!--  start product-table ..................................................................................... -->
                                        <form id="unisupdform" name="quaupdate" method="post" action="${pageContext.request.contextPath}/QualificationServlet/UpdateServlet">
                                            <q:forEach items="${qualiList}" var="ql">
                                                <input type="hidden" name="hid" value="${ql.qualificationId}"/>
                                                <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                    <tr>
                                                        <th valign="top">Qualification Name</th>
                                                        <td><input type="text" name="qname" value="${ql.qualificationName}" class="inp-form"/></td>
                                                        <td></td>
                                                    </q:forEach>
                                                </tr>
                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Update" class="form-submit" />

                                                    </td>
                                                    <td></td>
                                                </tr>

                                            </table>
                                            <!-- end id-form  -->

                                    </td>

                                </tr>
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/Admin/images/shared/blank.gif" width="695" height="1" alt="blank" /></td>
                                    <td></td>
                                </tr>
                            </table>

                            <div class="clear"></div>


                        </div>
                        <!--  end content-table-inner  -->
                    </td>
                    <td id="tbl-border-right"></td>
                </tr>
                <tr>
                    <th class="sized bottomleft"></th>
                    <td id="tbl-border-bottom">&nbsp;</td>
                    <th class="sized bottomright"></th>
                </tr>
            </table>
        </q:if>
        <%@include file="footer.jsp" %>
    </body>
</html>



