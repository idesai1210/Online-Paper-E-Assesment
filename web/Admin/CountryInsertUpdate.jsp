<%-- 
    Document   : countryupdate
    Created on : Feb 28, 2014, 2:17:12 PM
    Author     : Bhumi
--%>

<%@page import="av.online_exampaper.bean.CountryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>
<!DOCTYPE html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Country Update</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script>
            function shw()
            {
                country.action="CountryServlet/ShowServlet";
                country.submit();    
            }
        </script>
    </head>
    <body> 
        <%@include file="header.jsp" %>

        <u:if test="${countryList==null}">
            <div id="page-heading">
                <h1>Insert Country </h1>
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
                                        <form id="countryinsertform" name="country" method="post" action="${pageContext.request.contextPath}/CountryServlet/InsertServlet">

                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                <tr>
                                                    <th valign="top">Country Name</th>
                                                    <td><input type="text" name="countryname" class="inp-form" ></td>
                                                    <td></td>

                                                </tr>
                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Insert" name="InserServlet" class="form-submit" />

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

        <u:if test="${countryList!=null}">
            <div id="page-heading">
                <h1>Edit Country Data</h1>
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
                                        <form id="unisupdform" name="country3" action="${pageContext.request.contextPath}/CountryServlet/UpdateServlet" method="post">
                                            <u:forEach items="${countryList}"  var="ul">
                                                <input type="hidden" name="hid" value="${ul.countryId}"/>
                                                <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                    <tr>
                                                        <th valign="top">Country Name</th>
                                                        <td><input type="text" name="countryname" value="${ul.countryName}" class="inp-form"/></td>
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
