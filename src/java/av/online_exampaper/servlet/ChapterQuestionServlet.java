/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.UnitQuestionBean;
import av.online_exampaper.dao.ChapterQuestionDao;
import av.online_exampaper.dao.QuestionTypeDao;
import av.online_exampaper.dao.SubjectDao;
import av.online_exampaper.dao.TopicQuestionDao;
import av.online_exampaper.dao.UnitQuestionDao;
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
public class ChapterQuestionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String chapterName = request.getParameter("chapterName");
            int unitId = Integer.parseInt(request.getParameter("unitName"));

            ChapterQuestionBean cbean = new ChapterQuestionBean();
            cbean.setChapterName(chapterName);
            cbean.setUnitId(unitId);

            ChapterQuestionDao chapterd = new ChapterQuestionDao();
            boolean flag = chapterd.Insert(cbean);

            if (flag) {

                response.sendRedirect("/OPEAM/QuestionInsert.jsp");
            } else {
                request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/QuestionInsert.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("ShowServlet")) {
            List chapterList = ChapterQuestionDao.disp();
            request.setAttribute("chapterList", chapterList);
            RequestDispatcher rd = request.getRequestDispatcher("/ChapterDisplay.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = ChapterQuestionDao.delete(id);
            List chapterList = ChapterQuestionDao.disp();
            if (flag) {
                request.setAttribute("chapterList", chapterList);
                RequestDispatcher rd = request.getRequestDispatcher("/ChapterDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/ChapterDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));

            List chapterUpdateList = ChapterQuestionDao.getBypk(hid);
            List subjectList = SubjectDao.disp();
            List unitList = UnitQuestionDao.disp();
           List questionTypeList=QuestionTypeDao.questionTypeDisplay();
            

            request.setAttribute("subjectList", subjectList);
            request.setAttribute("unitList", unitList);
            request.setAttribute("questionTypeList", questionTypeList);

            request.setAttribute("chapterUpdateList", chapterUpdateList);
            System.out.println("Chapter List Fetiching======" +chapterUpdateList.size());
            RequestDispatcher rd=request.getRequestDispatcher("/QuestionInsert.jsp");
            rd.forward(request, response);
        
        }
            else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            String chapterName = request.getParameter("chapterName");
            int unitId = Integer.parseInt(request.getParameter("unitName"));

            ChapterQuestionBean cbean=new ChapterQuestionBean();
            cbean.setChapterId(hid);
            cbean.setChapterName(chapterName);
            cbean.setUnitId(unitId);



            boolean flag = ChapterQuestionDao.update(cbean);
            List chapterList = ChapterQuestionDao.disp();
            request.setAttribute("chapterList", chapterList);
            RequestDispatcher rd = request.getRequestDispatcher("/ChapterDisplay.jsp");
            rd.forward(request, response);

        }

    }
}
