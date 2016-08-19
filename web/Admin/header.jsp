<%-- 
    Document   : header
    Created on : Mar 20, 2014, 1:11:06 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header JSP</title>
        <link href="${pageContext.request.contextPath}/Admin/css/screen.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

        <!-- Start: page-top-outer -->
        <div id="page-top-outer">    

            <!-- Start: page-top -->
            <div id="page-top">

                <!-- start logo -->
                <div id="logo">
                    <a><img src="${pageContext.request.contextPath}/Admin/images/shared/admin-logo.gif" width="160" height="60" alt="" /></a>
                </div>
                <!-- end logo -->

                <!--  start top-search -->
                <div id="top-search">
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                                   <td><input type="text" value="Search" onblur="if (this.value == '') {
                                this.value = 'Search';
                            }" onfocus="if (this.value == 'Search') {
                            this.value = '';
                        }" class="top-search-inp" /></td>

                            <td>
                                <input type="image" src="${pageContext.request.contextPath}/Admin/images/shared/top_search_btn.gif"  />
                            </td>
                        </tr>
                    </table>
                </div>
                <!--  end top-search -->
                <div class="clear"></div>

            </div>
            <!-- End: page-top -->

        </div>
        <!-- End: page-top-outer -->

        <div class="clear">&nbsp;</div>

        <!--  start nav-outer-repeat................................................................................................. START -->
        <div class="nav-outer-repeat"> 
            <!--  start nav-outer -->
            <div class="nav-outer"> 

                <!-- start nav-right -->
                <div id="nav-right">

                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="clear">&nbsp;</div>
                    <a href="${pageContext.request.contextPath}/Admin/Admin.jsp" id="logout"><img src="${pageContext.request.contextPath}/Admin/images/shared/nav/nav_logout.gif" width="64" height="14" alt="" /></a>
                    <div class="clear">&nbsp;</div>



                </div>
                <!-- end nav-right -->


                <!--  start nav -->
                <div class="nav">
                    <div class="table">

                        <ul class="select"><li><a href="#nogo"><b>List Details</b><!--[if IE 7]><!--></a><!--<![endif]-->
                                <!--[if lte IE 6]><table><tr><td><![endif]-->
                                <div class="select_sub">
                                    <ul class="sub">
                                        <li><a href="${pageContext.request.contextPath}/UniversityServlet/ShowServlet">University Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/CollegeServlet/ShowServlet">College Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/DepartmentServlet/ShowServlet">Department Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/DegreeServlet/ShowServlet">Degree Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/SubjectDisplay.jsp">Subject Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/QualificationServlet/ShowServlet">Qualification Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/CountryServlet/ShowServlet">Country Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/StateServlet/ShowServlet">State Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/CityServlet/ShowServlet">City Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/SecurityServlet/ShowServlet">Security Question Details</a></li>
                                    </ul>
                                </div>
                                <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                            </li>
                        </ul>

                        <div class="nav-divider">&nbsp;</div>

                        <ul class="select"><li><a href="#nogo"><b>Professional</b><!--[if IE 7]><!--></a><!--<![endif]-->
                                <!--[if lte IE 6]><table><tr><td><![endif]-->
                                <div class="select_sub show">
                                    <ul class="sub">
                                        <li><a href="${pageContext.request.contextPath}/Admin/UniversityInsertUpdate.jsp">Add University</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/CollegeInsertUpdate.jsp" >Add College</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/DepartmentInsertUpdate.jsp">Add Department</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/DegreeInsertUpdate.jsp">Add Degree</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/SubjectInsertUpdate.jsp">Add Subject</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/QualificationInsertUpdate.jsp" >Add Qualification</a></li>
                                    </ul>
                                </div>
                                <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                            </li>
                        </ul>

                        <div class="nav-divider">&nbsp;</div>

                        <ul class="select"><li><a href="#nogo"><b>Information</b><!--[if IE 7]><!--></a><!--<![endif]-->
                                <!--[if lte IE 6]><table><tr><td><![endif]-->
                                <div class="select_sub">
                                    <ul class="sub">
                                        <li><a href="${pageContext.request.contextPath}/Admin/CountryInsertUpdate.jsp">Add Country</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/StateInsertUpdate.jsp" >Add State</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/CityInsertUpdate.jsp" >Add City</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Admin/SecurityInsertUpdate.jsp" >Add Security Question</a></li>

                                    </ul>
                                </div>
                                <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                            </li>
                        </ul>

                        <div class="nav-divider">&nbsp;</div>

                        <ul class="select"><li><a href="${pageContext.request.contextPath}/UserDataAdminServlet"><b>Show All User</b><!--[if IE 7]><!--></a><!--<![endif]-->
                                <!--[if lte IE 6]><table><tr><td><![endif]-->

                                <!--[if lte IE 6]></td></tr></table></a><![endif]-->
                            </li>
                        </ul>



                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </div>
                <!--  start nav -->

            </div>
            <div class="clear"></div>
            <!--  start nav-outer -->
        </div>
        <!--  start nav-outer-repeat................................................... END -->

        <div class="clear"></div>

        <!-- start content-outer -->
        <div id="content-outer">
            <!-- start content -->
            <div id="content">


                </body>
                </html>
