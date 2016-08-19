<%-- 
    Document   : SubjectDisplay
    Created on : Mar 23, 2014, 2:16:06 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject Display</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script>
            function upd(id) {
                document.subdisp.hid.value = id;
                subdisp.action = "${pageContext.request.contextPath}/SubjectAdminServlet/FetchServlet";
                subdisp.submit();
            }
            function del(id) {
                document.subdisp.hid.value = id;
                alert('Data Deleted');
                subdisp.action = "${pageContext.request.contextPath}/SubjectAdminServlet/DeleteServlet";
                subdisp.submit();
            }
        </script>
    </head>
    <body>
        <%@include file="header.jsp" %>
          <u:if test="${subjectList==null}">
                                    <u:redirect url="/SubjectAdminServlet/ShowServlet" ></u:redirect>
                                </u:if>
        <div id="page-heading">
            <h1>Subject Details</h1>
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
                            <form id="subjectform" action="" name="subdisp" method="post">
                               
                                <input type="hidden" name="hid"/>

                                <table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
                                    <tr>
                                        <th class="table-header-repeat line-left minwidth-1"><a>No.</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a>Subject Name</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a>Degree Name</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a>Department Name</a></th>
                                        <th class="table-header-options line-left"><a>Action</a></th>
                                    </tr>

                                    <tr>
                                        <u:forEach items="${subjectList}" var="subL" varStatus="varcount">
                                            <td>${varcount.count}</td>
                                             <td>${subL.subjectname}</td>
                                            <td>${subL.degreename}</td>
                                            <td>${subL.deptname}</td>
                                             <td class="options-width" align="center">

                                                <a href="#" title="Edit" onclick="del(${subL.subjectid})" class="icon-2 info-tooltip"></a>
                                                <a href="#" title="Update" onclick="upd(${subL.subjectid})" class="icon-1 info-tooltip"></a>

                                            </td>
                                        </tr>
                                    </u:forEach>
                                </table>

                                <!--  end product-table................................... --> 
                         
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
                                    <td><a href="${pageContext.request.contextPath}/Admin/SubjectInsertUpdate.jsp">Back to Insert Data For Subject</a></td>
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
