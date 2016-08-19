/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.LoginAdminBean;
import av.online_exampaper.dao.LoginAdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KLINGON
 */
public class LoginAdminServlet extends HttpServlet {

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String Uname=request.getParameter("username");
        String pwd=request.getParameter("password");
        
        LoginAdminBean bean=new LoginAdminBean();
        bean.setUserName(Uname);
        bean.setPassword(pwd);
        
        boolean flag=LoginAdminDao.login(bean);
        System.out.println("Flag======"+flag);
        if(flag)
        {
                 RequestDispatcher rd=request.getRequestDispatcher("/UniversityServlet/ShowServlet");
             rd.forward(request, response);
        }
        else
        {
            request.setAttribute("msg", "Invalid UserName and Password");
            RequestDispatcher rd=request.getRequestDispatcher("Admin/Admin.jsp");
            rd.forward(request, response);
        }
        
    }
    

}
