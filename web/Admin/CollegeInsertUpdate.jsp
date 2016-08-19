<%-- 
    Document   : CollegeUpdate
    Created on : Mar 5, 2014, 1:56:18 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>College Update</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
         <script>
            function shw() {
                clg.action = "CollegeServlet/ShowServlet";
                clg.submit();
            }
            function ins(){
                alert('Data Inserted Successfully');
                clg.action="CollegeServlet/InsertServlet";
                clg.submit();
            }
            function upd(){
                alert('Data Updated Successfully');
                clgupdform.action="${pageContext.request.contextPath}/CollegeServlet/UpdateServlet";
                clgupdform.submit();
            }
        </script>
    </head>
    <body> 
        <%@include file="header.jsp" %>

        <u:if test="${collegeList==null}">
            <div id="page-heading">
                <h1>Insert College </h1>
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
                                        <form name="clg" method="post" action="">

                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">

                                                <u:if test="${universityList==null}">
                                                    <u:redirect url="/CollegeServlet/SelectList" ></u:redirect>
                                                </u:if>

                                                <tr>
                                                    <td><strong>Select University</strong></td>
                                                    <td><select name="usnm">
                                                            <option>----University----</option>
                                                            <u:forEach items="${universityList}" var="ul">
                                                                <option value="${ul. universityId}">${ul.universityName}</option>
                                                            </u:forEach>
                                                        </select></td>
                                                    <!--<td></td>-->
                                                       
                                                </tr>

                                                <tr>
                                                    <th>College Name</th>
                                                    <td><input type="text" name="cnm" class="inp-form" ></td>
                                                    <td></td>

                                                </tr>
                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Insert" name="InsertServlet" onclick="ins();" class="form-submit" />
                                                        <input type="submit" value="Show" onclick="shw();" class="form-show" />
                                                    </td>
                                                    <td></td>
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


        </u:if>
        <u:if test="${collegeList!=null}">
            <div id="page-heading">
                <h1>Edit College Data</h1>
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
                                        <form id="clgupdform" name="clgu" method="post" action="" >
                                            <c:forEach items="${collegeList}" var="cl1">
                                                <input type="hidden" name="hid" value="${cl1.collegeId}"/>

                                                <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                    <tr>
                                                        <th valign="top">University Name:</th>
                                                        <td><select name="unm">
                                                                <c:forEach items="${collegeList}" var="cl">
                                                                    <c:forEach items="${universityList}" var="ul">
                                                                        <option value="${ul.universityId}" <c:if test="${ul.universityId==cl.universityId}">selected</c:if> >${ul.universityName}</option>  
                                                                    </c:forEach> 
                                                                </c:forEach>
                                                            </select></td>
                                                        
                                                        

                                                      
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">College Name</th>
                                                        <td><input type="text" class="inp-form" name="cname" value="${cl1.collegeName}"/></td>
                                                        <td></td>
                                                    </c:forEach>
                                                </tr>

                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Update" class="form-submit" onclick="upd();"/>

                                                    </td>
                                                    <td></td>
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
        </u:if>
        <%@include file="footer.jsp" %>

    </body>
</html>






