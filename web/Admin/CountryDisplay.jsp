<%-- 
    Document   : CountryDisplay
    Created on : Mar 25, 2014, 12:10:45 PM
    Author     : Bhumi
--%>

<%-- 
    Document   : countryshow
    Created on : Feb 27, 2014, 9:04:01 PM
    Author     : Bhumi
--%>

<%@ taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="av.online_exampaper.bean.CountryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Country Details</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script>
            function del(id)
            {
                document.country1.hid.value = id;
                country1.action = "${pageContext.request.contextPath}/CountryServlet/DeleteServlet";
                country1.submit();

            }
            function upd(id)
            {
                document.country1.hid.value = id;
                country1.action = "${pageContext.request.contextPath}/CountryServlet/FetchServlet";
                country1.submit();
            }

        </script>
    </head>
    <body> 
        <%@include file="header.jsp" %>

        <!--  start page-heading -->
        <div id="page-heading">
            <h1>Country Details</h1>
        </div>
        <!-- end page-heading -->

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
                    <!--  start content-table-inner ...................................................................... START -->
                    <div id="content-table-inner">

                        <!--  start table-content  -->
                        <div id="table-content">


                            <!--  start product-table ..................................................................................... -->
                            <form id="countryform" action="" name="country1" method="post">
                                <u:if test="${countryList==null}" >
                                    <u:redirect url="CountryServlet/ShowServlet" ></u:redirect>
                                </u:if>    

                                <input type="hidden" name="hid"/>
                                <table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
                                    <tr>   
                                        <th class="table-header-repeat line-left minwidth-1"><a>No.</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a>Country Name</a></th>
                                        <th class="table-header-options line-left"><a>Action</a></th>
                                    </tr>
                                    <tr>

                                        <u:forEach var="countryList" items="${countryList}" varStatus="varcount">
                                            <td>${varcount.count}</td>
                                            <td>${countryList.countryName}</td>
                                            <td class="options-width" align="center">

                                                <a href="#" onclick="del(${countryList.countryId})" title="delete" class="icon-2 info-tooltip"></a>
                                                <a href="#" onclick="upd(${countryList.countryId})" title="Update" class="icon-1 info-tooltip"></a>
                                            </td>
                                        </tr>
                                    </u:forEach>
                                </table>
                                <!--  end product-table................................... --> 
                            </form>
                        </div>
                        <!--  end content-table  -->


                        <!--  start paging..................................................... -->
                        <table border="0" cellpadding="0" cellspacing="0" id="paging-table">
                            <tr>
                                <td>
                                    <a href="" class="page-far-left"></a>
                                    <a href="" class="page-left"></a>
                                    <div id="page-info">Page <strong>1</strong> / 10</div>
                                    <a href="" class="page-right"></a>
                                    <a href="" class="page-far-right"></a>
                                </td>
                                <tr>
                                    <td><a href="${pageContext.request.contextPath}/Admin/CountryInsertUpdate.jsp">Back to Insert Data For Country</a></td>
                                </tr>
                            </tr>
                        </table>
                        <!--  end paging................ -->

                        <div class="clear"></div>

                    </div>
                    <!--  end content-table-inner ............................................END  -->
                </td>
                <td id="tbl-border-right"></td>
            </tr>
            <tr>
                <th class="sized bottomleft"></th>
                <td id="tbl-border-bottom">&nbsp;</td>
                <th class="sized bottomright"></th>
            </tr>
        </table>
        <%@include file="footer.jsp" %>

    </body>
</html>