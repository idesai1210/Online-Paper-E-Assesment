/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.SubjectBean;
import av.online_exampaper.dao.SubjectDao;
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
public class SubjectServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
            List subjectList = SubjectDao.disp();
            request.setAttribute("subjectList", subjectList);
            RequestDispatcher rd = request.getRequestDispatcher("QuestionInsert.jsp");
            rd.forward(request, response);
        
        

    }

}
