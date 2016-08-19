/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.SubjectBean;
import av.online_exampaper.bean.UnitQuestionBean;
import av.online_exampaper.dao.ChapterQuestionDao;
import av.online_exampaper.dao.SubjectDao;
import av.online_exampaper.dao.UnitQuestionDao;
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
 * @author asnthvinayak
 */
public class UnitQuestionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getRequestURI().contains("InsertServlet")) {

            String unitName = request.getParameter("unitName");
            int subjectId = Integer.parseInt(request.getParameter("subjectName"));

            UnitQuestionBean ubean = new UnitQuestionBean();
            ubean.setUnitQuestionName(unitName);
            ubean.setSubjectid(subjectId);

            UnitQuestionDao unitd = new UnitQuestionDao();
            boolean flag = unitd.Insert(ubean);

            if (flag) {
                response.sendRedirect("/OPEAM/QuestionInsert.jsp");

            } else {
                request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/QuestionInsert.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("ShowServlet")) {
            List unitList = UnitQuestionDao.disp();
            request.setAttribute("unitList", unitList);
            RequestDispatcher rd = request.getRequestDispatcher("/UnitDisplay.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = UnitQuestionDao.delete(id);
            List unitList = UnitQuestionDao.disp();
            if (flag) {
                request.setAttribute("unitList", unitList);
                RequestDispatcher rd = request.getRequestDispatcher("/UnitDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/UnitDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            List subjectList = SubjectDao.disp();
            List unitUpdateList = UnitQuestionDao.getBypk(hid);

            request.setAttribute("subjectList", subjectList);
            request.setAttribute("unitUpdateList", unitUpdateList);
            System.out.println("Unit List Fetiching======" + unitUpdateList.size());
            RequestDispatcher rd = request.getRequestDispatcher("/QuestionInsert.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            String unitName = request.getParameter("unitName");
            int subjectId = Integer.parseInt(request.getParameter("subjectName"));

            UnitQuestionBean ubean = new UnitQuestionBean();
            ubean.setUnitQuestionId(hid);
            ubean.setUnitQuestionName(unitName);
            ubean.setSubjectid(subjectId);



            boolean flag = UnitQuestionDao.update(ubean);
            List unitlist = UnitQuestionDao.disp();
            request.setAttribute("unitlist", unitlist);
            RequestDispatcher rd = request.getRequestDispatcher("/UnitDisplay.jsp");
            rd.forward(request, response);

        }

    }
}
