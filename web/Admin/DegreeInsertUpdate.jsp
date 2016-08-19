<%-- 
    Document   : DegreeUpdate
    Created on : Mar 12, 2014, 12:10:52 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<!DOCTYPE html>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Degree Update</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/AdminAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>

        <script>
            function shw() {
                deg.action = "${pageContext.request.contextPath}/DegreeServlet/ShowServlet";
                deg.submit();
            }
            function ins(){
                alert('Data Inserted Successfully');
                deg.action="${pageContext.request.contextPath}/DegreeServlet/InsertServlet";
                deg.submit();
            }
            function upd(){
                
                alert('Data Updated Successfully');
                degupd.action="${pageContext.request.contextPath}/DegreeServlet/UpdateServlet";
                degupd.submit();
                
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
            var LoadDepartment=function(data){
                dwr.util.removeAllOptions('Department');
                dwr.util.addOptions('Department',data,'departmentId','departmentName');
            }
            var LoadDepartmentEdit=function(data){
                dwr.util.removeAllOptions('DepartmentEdit');
                dwr.util.addOptions('DepartmentEdit',data,'departmentId','departmentName');
            }
        </script>
    </head>
    <body> 
        <%@include file="header.jsp" %>

        <d:if test="${degreeList==null}">
            <div id="page-heading">
                <h1>Insert Degree </h1>
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
                                        <form name="deg" method="post" action="">
                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">

                                                <d:if test="${collegeList==null || universityList==null || departmentList==null}">
                                                    <d:redirect url="/DegreeServlet/SelectList" ></d:redirect>
                                                </d:if>


                                                <tr>
                                                    <td><strong>Select University</strong></td>
                                                    <!--<td></td>-->


                                                    <td><select name="usnm" onchange="AdminAjax.collegeDisplay(this.value,LoadCollege)">
                                                            <option>----University----</option>
                                                            <d:forEach items="${universityList}" var="ul">
                                                                <option value="${ul. universityId}">${ul.universityName}</option>
                                                            </d:forEach>
                                                        </select></td>

                                                </tr> 

                                                <tr>
                                                    <td><strong>Select College</strong></td>
                                                    <td><select name="cnm" id="College" onchange="AdminAjax.departmentDisplay(this.value,LoadDepartment)">
                                                            <option>----College----</option>
                                                            <d:forEach items="${collegeList}" var="cl">
                                                                <option value="${cl.collegeId}">${cl.collegeName}</option>
                                                            </d:forEach>
                                                        </select></td>
                                                </tr>
                                                <tr>
                                                    <td><strong>Select Department</strong></td>
                                                    <td><select name="dnm" id="Department" >
                                                            <option>----Department----</option>
                                                            <d:forEach items="${departmentList}" var="dl">
                                                                <option value="${dl.departmentId}">${dl.departmentName}</option>
                                                            </d:forEach>
                                                        </select></td>
                                                </tr>

                                                <tr>
                                                    <th valign="top">Degree Name</th>
                                                    <td><input type="text" name="degnm" class="inp-form" ></td>
                                                    <td></td>

                                                </tr>
                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Insert" name="InsertServlet" onclick="ins();" class="form-submit" />
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




        </d:if>


        <d:if test="${degreeList!=null}">
            <div id="page-heading">
                <h1>Edit Degree Data</h1>
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
                                        <form id="degreeupdform" name="degupd" method="post" action="" >
                                            <d:forEach items="${degreeList}" var="degl1">
                                                <input type="hidden" name="hid" value="${degl1.degreeId}"/>

                                                <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                    <tr>
                                                        <th valign="top">University Name:</th>
                                                        <td><select name="unm" class="styledselect_form_1" onchange="AdminAjax.collegeDisplay(this.value,LoadCollegeEdit)">
                                                                <d:forEach items="${degreeList}" var="degl">
                                                                    <d:forEach items="${universityList}" var="ul">
                                                                        <option value="${ul.universityId}" <d:if test="${ul.universityId==degl.universityId}">selected</d:if> >${ul.universityName}</option>  
                                                                    </d:forEach> 
                                                                </d:forEach>
                                                            </select></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">College Name:</th>
                                                        <td><select name="cnm" class="styledselect_form_1" id="CollegeEdit" onchange="AdminAjax.departmentDisplay(this.value,LoadDepartmentEdit)">
                                                                <d:forEach items="${degreeList}" var="degl">
                                                                    <d:forEach items="${collegeList}" var="cl">
                                                                        <option value="${cl.collegeId}" <d:if test="${cl.collegeId==degl.collegeId}">selected</d:if> >${cl.collegeName}</option>  
                                                                    </d:forEach> 
                                                                </d:forEach>
                                                            </select></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">Department Name:</th>
                                                        <td><select name="dnm" class="styledselect_form_1" id="DepartmentEdit">
                                                                <d:forEach items="${degreeList}" var="degl">
                                                                    <d:forEach items="${departmentList}" var="dl">
                                                                        <option value="${dl.departmentId}" <d:if test="${dl.departmentId==degl.departmentId}">selected</d:if> >${dl.departmentName}</option>  
                                                                    </d:forEach> 
                                                                </d:forEach>
                                                            </select></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">Degree Name:</th>
                                                        <td><input type="text" name="degname" value="${degl1.degreeName}" class="inp-form"/></td>
                                                        <td></td>
                                                    </d:forEach>
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



