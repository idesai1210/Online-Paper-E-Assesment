<%-- 
    Document   : SubjectInsert
    Created on : Mar 23, 2014, 1:26:13 PM
    Author     : asnthvinayak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="u"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Subject Insert</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/AdminAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>

        <script>
            function shw() {
                subject.action = "${pageContext.request.contextPath}/SubjectAdminServlet/ShowServlet";
                subject.submit();
            }
            function ins() {
                alert('Data Inserted Successfully');
                subject.action = "SubjectAdminServlet/InsertServlet";
                subject.submit();
            }
            function upd() {
                alert('Data Updated Successfully');
                subjectUpdate.action = "${pageContext.request.contextPath}/SubjectAdminServlet/UpdateServlet";
                subjectUpdate.submit();
            }
            var LoadDepartment=function(data){
                dwr.util.removeAllOptions('Department');
                dwr.util.addOptions('Department',data,'departmentId','departmentName');
            }
            var LoadDegree=function(data){
                dwr.util.removeAllOptions('Degree');
                dwr.util.addOptions('Degree',data,'degreeId','degreeName');
            }
            var LoadDegreeEdit=function(data){
                dwr.util.removeAllOptions('DegreeEdit');
                dwr.util.addOptions('DegreeEdit',data,'degreeId','degreeName');
            }
        </script>
    </head>
    <body>

        <%@include file="header.jsp"%>
        <u:if test="${subjectList==null}">
            <div id="page-heading">
                <h1>Insert Subject</h1>
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
                                        <form name="subject" method="post" action="">
                                            <u:if test="${degreeList==null ||  departmentList==null}">
                                                <u:redirect url="/SubjectAdminServlet/AllListServlet" ></u:redirect>
                                            </u:if>

                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                <tr>
                                                    <td><strong>Select Department</strong></td>
                                                    <!--  <td></td> -->
                                                    <td><select name="dnm" onchange="AdminAjax.degreeDisplay(this.value,LoadDegree)">
                                                            <option>----Department----</option>
                                                            <u:forEach items="${departmentList}" var="dl">
                                                                <option value="${dl.departmentId}">${dl.departmentName}</option>
                                                            </u:forEach>
                                                        </select></td>

                                                </tr>
                                                <tr>
                                                    <td><strong>Select Degree</strong></td>
                                                    <td><select name="degreenm" id="Degree">
                                                            <option>----Degree----</option>
                                                            <u:forEach items="${degreeList}" var="degl">
                                                                <option value="${degl.degreeId}">${degl.degreeName}</option>
                                                            </u:forEach>
                                                        </select></td>
                                                </tr>
                                                <tr>
                                                    <th valign="top">Subject Name</th>
                                                    <td><input type="text" name="subjectnm" class="inp-form" ></td>
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
        </u:if>               
        <u:if test="${subjectList!=null}">
            <div id="page-heading">
                <h1>Edit Subject Data</h1>
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

                                        <form id="SubUpdForm" name="subjectUpdate" method="post" action="" >
                                            <u:forEach items="${subjectList}" var="subL">
                                                <input type="hidden" name="hid" value="${subL.subjectid}"/>

                                                <table border="0" cellpadding="0" cellspacing="0"  id="id-form">

                                                    <tr>
                                                        <th valign="top">Department Name:</th>
                                                        <td><select name="departmentName" onchange="AdminAjax.degreeDisplay(this.value,LoadDegreeEdit)">
                                                                <u:forEach items="${departmentList}" var="deptL">
                                                                    <option value="${deptL.departmentId}" <u:if test="${deptL.departmentId==subL.deptid}">selected</u:if> >${deptL.departmentName}</option>  
                                                                </u:forEach> 

                                                            </select></td>

                                                        <td></td>

                                                    </tr>
                                                    <tr>
                                                        <td valign="top">Degree Name:</td>
                                                        <td><select name="degreeName" id="DegreeEdit">
                                                                <option>----Degree----</option>
                                                                <u:forEach items="${degreeList}" var="degL">
                                                                    <option value="${degL.degreeId}" <u:if test="${degL.degreeId==subL.degreeid}">selected</u:if> >${degL.degreeName}</option>  
                                                                </u:forEach> 


                                                            </select></td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top">Subject Name:</th>
                                                        <td><input type="text" name="subName" value="${subL.subjectname}" class="inp-form"/></td>
                                                        <td></td>
                                                    </u:forEach>
                                                </tr>


                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td valign="top" colspan="2">
                                                        <input type="submit" value="Update" class="form-submit" onclick="upd();" />

                                                    </td>
                                                    <td></td>
                                                </tr>

                                            </table>
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
