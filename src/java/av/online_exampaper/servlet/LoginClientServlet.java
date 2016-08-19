/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.LoginClientBean;
import av.online_exampaper.dao.LoginClientDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KLINGON
 */
public class LoginClientServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String Uname=request.getParameter("username");
        String pwd=request.getParameter("password");
        
        HttpSession session = request.getSession();
        
        LoginClientBean bean=new LoginClientBean();
        bean.setUserName(Uname);
        bean.setPassword(pwd);
        
        int id=LoginClientDao.login(bean);
        int assign_type=LoginClientDao.assign();
        
        
        int rid=LoginClientDao.rid();
        int paperassignid=LoginClientDao.paperassignid();
        
       
       
        if(id>0)
        {
             if(id==3)
             {
                 session.setAttribute("id", id);
                 session.setAttribute("assign_type", assign_type);
                 session.setAttribute("paperassignid", paperassignid);
                 session.setAttribute("rid", rid);
                 RequestDispatcher rd=request.getRequestDispatcher("/index_1.jsp");
                 rd.forward(request, response);
             }
             else
             {
                 session.setAttribute("id", id);
                 session.setAttribute("assign_type", assign_type);
                 session.setAttribute("paperassignid", paperassignid);
                 session.setAttribute("rid", rid);
                 RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
                 rd.forward(request, response);
             }
        }
        else
        {
            request.setAttribute("msg", "Invalid UserName and Password");
            RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        }
        
    }
    

}
