<%-- 
    Document   : FrameAnswerDisplay
    Created on : 19-Apr-2014, 22:16:34
    Author     : KLINGON
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${id==null}">
    <c:redirect url="Login.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Answers</title>
        <link rel="stylesheet" type="text/css" href="cssClient/style_2.css">

        <!-- Example assets -->
        <link rel="stylesheet" type="text/css" href="cssClient/jcarousel.basic.css">

        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
        <script type="text/javascript" src="js/jcarousel.basic.js"></script> 
        <script type="text/javascript" src="js/jquery.zoom.js"></script> 
        <style>
            /* styles unrelated to zoom */
            * { border:0; margin:0; padding:0; }

            /* these styles are for the demo, but are not required for the plugin */
            .zoom {
                display:inline-block;
                position: relative;
            }

            /* magnifying glass icon */
            .zoom:after {
                content:'';
                display:block; 
                width:33px; 
                height:33px; 
                position:absolute; 
                top:0;
                right:0;
                background:url(icon.png);
            }

            .zoom img {
                display: block;
            }

            .zoom img::selection { background-color: transparent; }


            .myButton {
                -moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
                -webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
                box-shadow:inset 0px 1px 0px 0px #ffffff;
                background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ededed), color-stop(1, #dfdfdf));
                background:-moz-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
                background:-webkit-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
                background:-o-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
                background:-ms-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
                background:linear-gradient(to bottom, #ededed 5%, #dfdfdf 100%);
                filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#dfdfdf',GradientType=0);
                background-color:#ededed;
                -moz-border-radius:6px;
                -webkit-border-radius:6px;
                border-radius:6px;
                border:1px solid #dcdcdc;
                display:inline-block;
                cursor:pointer;
                color:#777777;
                font-family:arial;
                font-size:15px;
                font-weight:bold;
                padding:6px 24px;
                text-decoration:none;
                text-shadow:0px 1px 0px #ffffff;
            }
            .myButton:hover {
                background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #ededed));
                background:-moz-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
                background:-webkit-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
                background:-o-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
                background:-ms-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
                background:linear-gradient(to bottom, #dfdfdf 5%, #ededed 100%);
                filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed',GradientType=0);
                background-color:#dfdfdf;
            }
            .myButton:active {
                position:relative;
                top:1px;
            }


        </style>


        <script>
            $(document).ready(function() {
                $('.zoomIt').zoom();

            });
            function validate(id, a)
            {

                if (id > a)
                {
                    alert("Marks out of range. Must be less than:" + a);
                    return false;
                    
                }

            }
        </script>
    </head>
    <body>
        <%@include file="headerClient.jsp" %>
        <table border = 1  width="100%" height="100%">
            <tr >
                <td rowspan=3 width=75% height=100%>

                    <form name="f01" >

                        <c:if test="${ imgList==null }">
                            <c:redirect url="OpenPicServlet"/>
                        </c:if>
                        <div class="wrapper" style="margin-left: 100px">
                            <h1>Answer Sheet</h1>
                            <div class="jcarousel-wrapper" style="height: 900px;">
                                <div class="jcarousel" style="height: 900px;">
                                    <ul>
                                        <% for (int i = 1; i <= Integer.parseInt(session.getAttribute("size").toString()); i++) {%>
                                        <c:forEach var="imgList" items="${imgList}">


                                            <li> 
                                                <span  class="zoom zoomIt" style="position: relative; overflow: hidden;">
                                                    <img width="600" height="900px" src="image/${imgList.ppath}/<%=i%>.jpg">
                                                    <img class="zoomImg" src="image/${imgList.ppath}/<%=i%>.jpg" style="position: absolute;  opacity: 0; width: 1200px; height: 900px; border: medium none; max-width: none; max-height: none;">
                                                </span> 
                                            </li>

                                        </c:forEach>
                                        <%}%>
                                    </ul>
                                </div>
                                <a href="#" class="jcarousel-control-prev">&lsaquo;</a>
                                <a href="#" class="jcarousel-control-next">&rsaquo;</a>
                                <p class="jcarousel-pagination"></p>
                            </div>
                        </div>

                    </form>


                </td>
            </tr>

            <tr>
                <td>


                    <form name="f1" method="post" action="SubmitMarksServlet">

                        <table border="1">

                            <c:forEach var="qboxlist" items="${qboxlist}">
                                <tr>

                                    <td>
                                        Q${qboxlist.mq}

                                    </td>

                                    <td>
                                        <table border="1"> 

                                            <c:forEach var="qboxlist1" items="${qboxlist1}">
                                                <tr>
                                                    <c:if test="${qboxlist1.mq eq qboxlist.mq}">

                                                        <td>
                                                            ${qboxlist1.sq}
                                                        </td>

                                                        <!--                                    sub sub question start-->
                                                        <td>
                                                            <table border="1">
                                                                <c:forEach var="qboxlist2" items="${qboxlist2}">
                                                                    <tr>
                                                                        <c:if test="${qboxlist2.mq eq qboxlist.mq && qboxlist2.sq eq qboxlist1.sq}">
                                                                            <td>
                                                                                ${qboxlist1.que}
                                                                            </td>
                                                                            <td>

                                                                                <input type="number" min="0" max="${qboxlist1.qm}" style="width: 35px" maxlength="2" id="${qboxlist1.mq}_${qboxlist1.sq}_${qboxlist1.que}" name="${qboxlist1.mq}_${qboxlist1.sq}_${qboxlist1.que}" onchange="return validate(this.value,${qboxlist1.qm})">
                                                                                <% int i = 1;%>
                                                                                <input type="hidden" name="<%=i%>" id="<%=i%>" value="${qboxlist1.mq}_${qboxlist1.sq}_${qboxlist1.que}"/>
                                                                                <% i++;%>
                                                                            </td>
                                                                            <td>
                                                                                /
                                                                            </td>
                                                                            <td>
                                                                                <input type="text" style="width: 15px" value="${qboxlist1.qm}" disabled="yes" maxlength="2"  id="${qboxlist1.mq}_${qboxlist1.sq}_${qboxlist1.que}_m" name="${qboxlist1.mq}_${qboxlist1.sq}_${qboxlist1.que}_m" >
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                </c:forEach>

                                                            </table>


                                                        </td>

                                                    </c:if>
                                                </tr>
                                            </c:forEach>

                                        </table>  
                                    </td>
                                </tr>                                

                            </c:forEach>   


                        </table>
                        <input type="submit" class="myButton" name="submitmarks" id="submitmarks" value="Submit Marks"/>
                    </form>





                </td>

            </tr>

            <tr>
                <td>	</td>

            </tr>
        </table>
        <%@include file="footerClient.jsp" %>
    </body>
</html>
