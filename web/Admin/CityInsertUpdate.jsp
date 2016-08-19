<%-- 
    Document   : cityupdate
    Created on : Mar 8, 2014, 1:48:06 PM
    Author     : Bhumi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>City Update</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Admin/css/screen.css" type="text/css" media="screen" title="default" />
        <script type='text/javascript' src='/OPEAM/dwr/engine.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/interface/AdminAjax.js'></script>
        <script type='text/javascript' src='/OPEAM/dwr/util.js'></script>

        <script>
            function shw()
            {
                city.action="${pageContext.request.contextPath}/CityServlet/ShowServlet";
                city.submit();
            }
            function ins()
            {
                alert('Data Inserted Successfully');
                city.action="${pageContext.request.contextPath}/CityServlet/InsertServlet";
                city.submit();
            }
            function upd()
            {
                alert('Data Updated Successfully');
                s2.action="${pageContext.request.contextPath}/CityServlet/UpdateServlet";
                s2.submit();
            }
            var LoadCountry=function(data){
                dwr.util.removeAllOptions('Counrty');
                dwr.util.addOptions('Country',data,'countryId','countryName');
            }
            var LoadState=function(data)
            {
                dwr.util.removeAllOptions('state1');
                dwr.util.addOptions('state1',data,'stateId','stateName');
            }
            var LoadStateEdit=function(data)
            {
                dwr.util.removeAllOptions('StateEdit');
                dwr.util.addOptions('StateEdit',data,'stateId','stateName');
            }
        </script>
    </head>
    <body> 
        <%@include file="header.jsp" %>
        <u:if test="${cityList==null}">
            <div id="page-heading">
                <h1>Insert City Data</h1>
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
                                        <form name="city" action="">

                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                <u:if test="${Select==null}">
                                                    <u:redirect url="/CityServlet/SelectServlet"></u:redirect>
                                                </u:if>
                                                <tr>
                                                    <td><strong>Select Country</strong></td>
                                                    <td><select name="country" id="Country" onchange="AdminAjax.stateShow(this.value,LoadState)">

                                                            <option>----Country----</option>
                                                            <u:forEach var="lst" items="${countryList}">
                                                                <option value="${lst.countryId}">${lst.countryName}</option>
                                                            </u:forEach>
                                                        </select>
                                                </tr> 
                                                <tr>
                                                    <td><strong>Select State</strong></td>
                                                    <td><select name="state" id="state1">
                                                            <option>----State----</option>
                                                            <u:forEach var="lst" items="${Select}">
                                                                <option value="${lst.stateId}">${lst.stateName}</option>
                                                            </u:forEach>
                                                            </tr>



                                                            <tr>
                                                                <th valign="top">City Name</th>
                                                                <td><input type="text" name="cityname" class="inp-form" ></td>
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
                        <u:if test="${cityList!=null}">
                            <div id="page-heading">
                                <h1>Edit City Data</h1>
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

                                                        <form id="deptupdform" name="s2" action="" method="post" >

                                                            <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                                                <u:forEach items="${cityList}"  var="ul">
                                                                    <input type="hidden" name="hid" value="${ul.cityId}"/>

                                                                    <tr>
                                                                        <th valign="top">Country Name:</th>
                                                                        <td><select name="country" class="styledselect_form_1" onchange="AdminAjax.stateShow(this.value,LoadStateEdit)">

                                                                                <u:forEach var="citylist" items="${countryList}">
                                                                                    <option value="${citylist.countryId}" <u:if test="${ul.countryId==citylist.countryId}">selected</u:if> >${citylist.countryName}</option>
                                                                                </u:forEach>
                                                                            </select>
                                                                        </td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th valign="top">State Name:</th>
                                                                        <td><select name="state" class="styledselect_form_1" id="StateEdit">

                                                                                <u:forEach var="citylist" items="${stateList}">
                                                                                    <option value="${citylist.stateId}" <u:if test="${ul.stateId==citylist.stateId}">selected</u:if>   >${citylist.stateName}</option>
                                                                                </u:forEach>
                                                                            </select>
                                                                        </td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th valign="top">City Name:</th>
                                                                        <td><input type="text" name="cityname" value="${ul.cityName}" class="inp-form"/></td>
                                                                        <td></td>
                                                                    </u:forEach>
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
