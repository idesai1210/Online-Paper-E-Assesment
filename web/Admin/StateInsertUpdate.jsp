<%-- 
    Document   : stateupdate
    Created on : Mar 8, 2014, 10:52:56 AM
    Author     : Bhumi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>State Update</title>
        <link rel="stylesheet" href="Admin/css/screen.css">
        <script>
            function shw()
            {
                state.action = "${pageContext.request.contextPath}/StateServlet/ShowServlet";
                state.submit();
            }
        </script>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <u:if test="${stateList==null}">
            <div id="page-heading">
                <h1>Insert State </h1>
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

                                        <form name="state" method="post" action="${pageContext.request.contextPath}/StateServlet/InsertServlet">

                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                <u:if test="${countryList==null}">
                                                    <u:redirect url="/StateServlet/SelectList"></u:redirect>
                                                </u:if>
                                                <tr>
                                                    <td><strong>Select Country</strong></td>
                                                    <td><select name="country">

                                                            <option>----Country----</option>
                                                            <u:forEach var="countryList" items="${countryList}">
                                                                <option value="${countryList.countryId}">${countryList.countryName}</option>
                                                            </u:forEach>
                                                        </select>
                                                </tr> 



                                                <tr>
                                                    <th valign="top">State Name</th>
                                                    <td><input type="text" name="state_name" class="inp-form" ></td>
                                                    <td></td>

                                                </tr>
                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Insert" name="InsertServlet"class="form-submit" />
                                                        <input type="submit" value="Show" name="ShowServlet" onclick="shw();" class="form-show" />
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
        <u:if test="${stateList!=null}">
            <div id="page-heading">
                <h1>Edit State Data</h1>
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
                                        <form id="stateupdform" name="s2" action="${pageContext.request.contextPath}/StateServlet/UpdateServlet" method="post" >
                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                <u:forEach items="${stateList}" var="ul">
                                                    <input type="hidden" name="hid" value="${ul.stateId}"/>

                                                    <tr>

                                                        <th valign="top">Country Name:</th>
                                                        <td><select name="country" class="styledselect_form_1">
                                                                <u:forEach var="stateList" items="${countryList}">
                                                                    <option value="${stateList.countryId}" <u:if test="${ul.countryId==stateList.countryId}"> selected </u:if> >${stateList.countryName}</option>
                                                                </u:forEach>  
                                                            </select>
                                                        </td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">State Name</th>
                                                        <td><input type="text" name="statename" value="${ul.stateName}" class="inp-form"/></td>
                                                        <td></td>
                                                    </u:forEach>
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
