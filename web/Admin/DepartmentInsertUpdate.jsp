<%-- 
    Document   : DepartmentUpdate
    Created on : Mar 8, 2014, 3:09:29 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Department Update</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/AdminAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>

        <script>
            function shw() {
                dept.action = "DepartmentServlet/ShowServlet";
                dept.submit();
            }
            function ins(){
                alert('Data Inserted Successfully');
                dept.action="DepartmentServlet/InsertServlet";
                dept.submit();
            }
            function upd(){
                alert('Data Updated Successfully');
                deptupdform.action="${pageContext.request.contextPath}/DepartmentServlet/UpdateServlet";
                deptupdform.submit();
            }
            var LoadUniversity=function(data){
                dwr.util.removeAllOptions('University');
                dwr.util.addOptions('University',data,'universityId','universityName');
            }
            var LoadCollege=function(data){
                dwr.util.removeAllOptions('College');
                dwr.util.addOptions('College',data,'collegeId','collegeName');
            }
            var LoadCollegeEdit=function(data){
                dwr.util.removeAllOptions('CollegeEdit');
                dwr.util.addOptions('CollegeEdit',data,'collegeId','collegeName');
            }
            
        </script>
    </head>
    <body> 
        <%@include file="header.jsp" %>
        <d:if test="${departmentList==null}">
            <div id="page-heading">
                <h1>Insert Department </h1>
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
                                        <form name="dept" method="post" action="">

                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                <d:if test="${collegeList==null || universityList==null}">
                                                    <d:redirect url="/DepartmentServlet/SelectList" ></d:redirect>
                                                </d:if>


                                                <tr>
                                                    <td><strong>Select University</strong></td>
                                                    <td><select name="usnm" onchange="AdminAjax.collegeDisplay(this.value,LoadCollege)">
                                                            
                                                            <option>----University----</option>
                                                            <d:forEach items="${universityList}" var="ul">
                                                                <option value="${ul. universityId}">${ul.universityName}</option>
                                                            </d:forEach>
                                                        </select></td>

                                                </tr> 

                                                <tr>
                                                    <td><strong>Select College</strong></td>
                                                    <td><select name="cnm" id="College" >
                                                            <option>----College----</option>
                                                            <d:forEach items="${collegeList}" var="cl">
                                                                <option value="${cl.collegeId}">${cl.collegeName}</option>
                                                            </d:forEach>
                                                        </select></td>
                                                </tr>

                                                <tr>
                                                    <th valign="top">Department Name</th>
                                                    <td><input type="text" name="dnm" class="inp-form" ></td>
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



        </d:if>






        <d:if test="${departmentList!=null}">

            <div id="page-heading">
                <h1>Edit Department Data</h1>
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
                                        <form id="deptupdform" name="deptupd" method="post" action="" >
                                            <d:forEach items="${departmentList}" var="dl1">
                                                <input type="hidden" name="hid" value="${dl1.departmentId}"/>

                                                <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                    <tr>
                                                        <th valign="top">University Name:</th>
                                                        <td><select name="unm" class="styledselect_form_1" onchange="AdminAjax.collegeDisplay(this.value,LoadCollegeEdit)">
                                                                <d:forEach items="${departmentList}" var="dl">
                                                                    <d:forEach items="${universityList}" var="ul">
                                                                        <option value="${ul.universityId}" <d:if test="${ul.universityId==dl.universityId}">selected</d:if> >${ul.universityName}</option>  
                                                                    </d:forEach> 
                                                                </d:forEach>
                                                            </select></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">College Name:</th>
                                                        <td><select name="cnm" class="styledselect_form_1" id="CollegeEdit">
                                                                <d:forEach items="${departmentList}" var="dl">
                                                                    <d:forEach items="${collegeList}" var="cl">
                                                                        <option value="${cl.collegeId}" <d:if test="${cl.collegeId==dl.collegeId}">selected</d:if> >${cl.collegeName}</option>  
                                                                    </d:forEach> 
                                                                </d:forEach>
                                                            </select></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">Department Name:</th>
                                                        <td><input type="text" name="dname" value="${dl1.departmentName}" class="inp-form"/></td>
                                                        <td></td>
                                                    </d:forEach>
                                                </tr>


                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Update" class="form-submit"  onclick="upd();"/>

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
        </d:if>
        <%@include file="footer.jsp" %>
    </body>
</html>






