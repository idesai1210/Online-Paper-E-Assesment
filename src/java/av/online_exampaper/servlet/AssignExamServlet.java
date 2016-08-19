/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.AssignExamBean;
import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.dao.AssignExamDao;
import av.online_exampaper.dao.ChapterQuestionDao;
import av.online_exampaper.dao.PaperAssignDao;
import av.online_exampaper.dao.SubjectDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP I5
 */
public class AssignExamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {
            int assignId = Integer.parseInt(request.getParameter("assign"));
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            String staffId[] = request.getParameterValues("userId");
            String examBlock = request.getParameter("eBlock");

            List list = new ArrayList();
            for (int i = 0; i < staffId.length; i++) {
                int j = Integer.parseInt(staffId[i]);
                list.add(j);
            }

            AssignExamBean abean = new AssignExamBean();
            abean.setSujectId(subjectId);
            abean.setPaperAssignId(assignId);
            abean.setAssignBlock(examBlock);

            boolean flag = AssignExamDao.Insert(abean, list);

            if (flag) {
                request.setAttribute("msg", "Data Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/UserDataList.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/UserDataList.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("ShowServlet")) {
            int assignId = Integer.parseInt(request.getParameter("assign"));
            int subjectId = Integer.parseInt(request.getParameter("subject"));


            List assignExamList = AssignExamDao.disp(assignId, subjectId);
            request.setAttribute("assignExamList", assignExamList);
            RequestDispatcher rd = request.getRequestDispatcher("/AssignExamList.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("ShowUserDataServlet")) {
            List ulist = AssignExamDao.dispUserList();
            List subjectList = SubjectDao.disp();
            List paperAssignList = PaperAssignDao.disp();

            request.setAttribute("ulist", ulist);
            request.setAttribute("subjectList", subjectList);
            request.setAttribute("paperAssignList", paperAssignList);

            System.out.println("User Assign Data" + ulist.size());
            RequestDispatcher rd = request.getRequestDispatcher("/UserDataList.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("DeleteServlet")) {
            
            int id = Integer.parseInt(request.getParameter("hid"));
//            int assignId = Integer.parseInt(request.getParameter("assign"));
//            int subjectId = Integer.parseInt(request.getParameter("subject"));

            boolean flag = AssignExamDao.delete(id);
//            List assignExamList = AssignExamDao.disp(assignId, subjectId);

            if (flag) {
//                request.setAttribute("assignExamList", assignExamList);
                RequestDispatcher rd = request.getRequestDispatcher("/UserDataList.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/AssignExamList.jsp");
                rd.forward(request, response);
            }
        }
    }
}
