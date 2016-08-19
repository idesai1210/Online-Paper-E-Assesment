/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.dao.PaperAssignDao;
import av.online_exampaper.dao.SubjectDao;
import av.online_exampaper.dao.UserDataDao;
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
public class UserDataServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        List ulist=UserDataDao.disp();
        List subjectList=SubjectDao.disp();
        List paperAssignList=PaperAssignDao.disp();
        
        request.setAttribute("ulist", ulist);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("paperAssignList", paperAssignList);
        
        System.out.println("User Assign Data"+ulist.size());
        RequestDispatcher rd=request.getRequestDispatcher("/UserDataList.jsp");
        rd.forward(request, response);
        
    
    }

    
    
}
