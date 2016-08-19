/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.dao.UserDataAdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asnthvinayak
 */
public class UserDataAdminServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        List ulist=UserDataAdminDao.disp();
        System.out.println("User List====="+ulist.size());
        request.setAttribute("ulist", ulist);
        RequestDispatcher rd=request.getRequestDispatcher("Admin/UserList.jsp");
        rd.forward(request, response);
    
    }

    
    
}
