<%-- 
    Document   : footer
    Created on : Apr 11, 2014, 12:13:46 PM
    Author     : HP I5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="cssClient/style.css" rel="stylesheet" type="text/css" />

    </head>

    <body>
        <div class="fbg">
            <div class="fbg_resize">
                <div class="col c1">
                    <h2><span>Image Gallery</span></h2>
                    <a href="#"><img src="${pageContext.request.contextPath}/cssClient/images/pic_1.jpg" width="58" height="58" alt="" /></a> 
                    <a href="#"><img src="${pageContext.request.contextPath}/cssClient/images/pic_2.jpg" width="58" height="58" alt="" /></a> 
                    <a href="#"><img src="${pageContext.request.contextPath}/cssClient/images/pic_3.jpg" width="58" height="58" alt="" /></a> 
                    <a href="#"><img src="${pageContext.request.contextPath}/cssClient/images/pic_4.jpg" width="58" height="58" alt="" /></a> 
                    <a href="#"><img src="${pageContext.request.contextPath}/cssClient/images/pic_5.jpg" width="58" height="58" alt="" /></a> 
                    <a href="#"><img src="${pageContext.request.contextPath}/cssClient/images/pic_6.jpg" width="58" height="58" alt="" /></a> 
                </div>
                <div class="col c2">
                    <h2><span>System Features</span></h2>
                    <p class="col features">Fully Customize<br>
                        Time Assesement<br> 
                        Detaild Report.<br>
                        Multiple Choice <br>
                        Paper Creation <br>
                        Paper Observation<p>
                </div>
                <div class="col c3">
                    <h2><span>About</span></h2>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo. llorem, eu posuere nunc justo tempus leo. Donec mattis, purus nec placerat bibendum. <a href="#">Learn more...</a></p>
                </div>
                <div class="clr"></div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="footer_resize">
            <p class="rf">&copy; Copyright <a href="#">OPEAM.Com</a>.</p>
            <div class="clr"></div>
        </div>
    </div>



</body>
</html>
