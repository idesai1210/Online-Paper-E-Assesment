/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.PaperFormatBean;
import av.online_exampaper.dao.DegreeDao;
import av.online_exampaper.dao.PaperAssignDao;
import av.online_exampaper.dao.PaperFormatDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP I5
 */
public class PaperFormatServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List assignIdList = new ArrayList();

        if (request.getRequestURI().contains("SubjectDataServlet")) {
            HttpSession id = request.getSession();

            String ais = id.getAttribute("paperassignid").toString();
            String grid = id.getAttribute("rid").toString();
            int assignId = Integer.parseInt(ais);
            int rid = Integer.parseInt(grid);

            List subjectList = PaperFormatDao.dispSubject(assignId, rid);
            request.setAttribute("subjectList", subjectList);
            RequestDispatcher rd = request.getRequestDispatcher("/paperformat.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("InsertServlet")) {

            HttpSession id = request.getSession();

            String ais = id.getAttribute("paperassignid").toString();
            String grid = id.getAttribute("rid").toString();
            int assignId = Integer.parseInt(ais);
            int rid = Integer.parseInt(grid);
            int sid = Integer.parseInt(request.getParameter("subjectName"));

            int examType = Integer.parseInt(request.getParameter("examType"));
            String paperName = request.getParameter("paperName");
            String examDate = request.getParameter("examDate");
            String examtime = request.getParameter("examtime");
            String paperGDate = request.getParameter("paperGDate");
            String notes = request.getParameter("notes");

            PaperFormatBean pbean = new PaperFormatBean();
            pbean.setRid(rid);
            pbean.setPaperassignId(assignId);
            pbean.setSubId(sid);
            pbean.setExamType(examType);
            pbean.setPaperName(paperName);
            pbean.setExamDate(examDate);
            pbean.setTimeDuration(examtime);
            pbean.setPaperGDate(paperGDate);
            pbean.setNotes(notes);

            boolean flag = PaperFormatDao.Insert(pbean);

            if (flag) {
                RequestDispatcher rd = request.getRequestDispatcher("/PaperCreaiton.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/paperformat.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("ShowServlet")) {

            List allPaperList = PaperFormatDao.dispPaper();
            request.setAttribute("allPaperList", allPaperList);
            RequestDispatcher rd = request.getRequestDispatcher("/paperFormatDisplay.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = PaperFormatDao.paperDelete(id);
           
            List allPaperList = PaperFormatDao.dispPaper();
            if (flag) {
                request.setAttribute("allPaperList", allPaperList);
                RequestDispatcher rd = request.getRequestDispatcher("/paperFormatDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/paperFormatDisplay.jsp");
                rd.forward(request, response);
            }

        }
    }
}