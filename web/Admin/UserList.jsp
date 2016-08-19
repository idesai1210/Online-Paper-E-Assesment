<%-- 
    Document   : UserList
    Created on : Mar 22, 2014, 12:59:15 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="u"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />

    </head>
    <body>
        <%@include file="header.jsp" %>
        <div id="page-heading">
            <table>
                <tr>
                    <td><h1>User List Details</h1></td>


                </tr>
            </table>
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
                    <!--  start content-table-inner ...................................................................... START -->
                    <div id="content-table-inner">

                        <!--  start table-content  -->
                        <div id="table-content">


                            <!--  start product-table ..................................................................................... -->
                            <form id="mainform" action="" name="udisp" method="post">
                                <u:if test="${ulist==null}">
                                    <u:redirect url="UserDataAdminServlet" ></u:redirect>
                                </u:if>
                                <input type="hidden" name="hid"/>

                                <table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
                                    
                                    <tr>
                                        <th class="table-header-repeat line-left minwidth-1"><a>No.</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a>Full Name</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a>Address</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a>City</a></th>
                                        <th class="table-header-repeat line-left"><a>State</a></th>
                                        <th class="table-header-options line-left"><a>Country</a></th>
                                    </tr>



                                    <tr>
                                        <u:forEach var="ul" items="${ulist}" varStatus="varcount">
                                            <td>${varcount.count}</td>
                                            <td>${ul.fname} &nbsp; ${ul.mname} &nbsp; ${ul.lname}</td>
                                            <td>${ul.address}</td>
                                            <td>${ul.cityname}</td>
                                            <td>${ul.sname}</td>
                                            <td>${ul.cname}</td>
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
