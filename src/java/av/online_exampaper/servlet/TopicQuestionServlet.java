/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.TopicQuestionBean;
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
public class TopicQuestionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("CallChapterServlet")) {

            List subjectList = SubjectDao.disp();
            List unitList = UnitQuestionDao.disp();
            List chapterList = ChapterQuestionDao.disp();
            List topicList = TopicQuestionDao.disp();
            List questionTypeList = QuestionTypeDao.questionTypeDisplay();


            request.setAttribute("subjectList", subjectList);
            request.setAttribute("unitList", unitList);
            request.setAttribute("chapterList", chapterList);
            request.setAttribute("topicList", topicList);
            request.setAttribute("questionTypeList", questionTypeList);

            System.out.println("Subject List==" + subjectList.size());
            System.out.println("unit List==" + unitList.size());
            System.out.println("Chapter List==" + chapterList.size());
            System.out.println("Topic List==" + topicList.size());
            System.out.println("Question Type List==" + questionTypeList.size());

            RequestDispatcher rd = request.getRequestDispatcher("/QuestionInsert.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("InsertServlet")) {

            String topicName = request.getParameter("topicName");
            int chapterId = Integer.parseInt(request.getParameter("chapterName"));

            TopicQuestionBean tbean = new TopicQuestionBean();
            tbean.setTopicName(topicName);
            tbean.setChapterId(chapterId);

            TopicQuestionDao topicd = new TopicQuestionDao();
            boolean flag = topicd.Insert(tbean);

            if (flag) {
                response.sendRedirect("/OPEAM/QuestionInsert.jsp");
            } else {
                request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/QuestionInsert.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("ShowServlet")) {
            List topicList = TopicQuestionDao.disp();
            request.setAttribute("topicList", topicList);
            RequestDispatcher rd = request.getRequestDispatcher("/TopicDisplay.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = TopicQuestionDao.delete(id);
            List topicList = TopicQuestionDao.disp();
            if (flag) {
                request.setAttribute("topicList", topicList);
                RequestDispatcher rd = request.getRequestDispatcher("/TopicDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/TopicDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));

            List topicUpdateList = TopicQuestionDao.getBypk(hid);
            List chapterList = ChapterQuestionDao.disp();
            List unitList = UnitQuestionDao.disp();
            List subjectList = SubjectDao.disp();
            List questionTypeList = QuestionTypeDao.questionTypeDisplay();

            request.setAttribute("questionTypeList", questionTypeList);
            request.setAttribute("subjectList", subjectList);
            request.setAttribute("unitList", unitList);
            request.setAttribute("chapterList", chapterList);
            request.setAttribute("topicUpdateList", topicUpdateList);
            System.out.println("Topic List Fetiching======" + topicUpdateList.size());
            RequestDispatcher rd = request.getRequestDispatcher("/QuestionInsert.jsp");
            rd.forward(request, response);

        }
        else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            String topicName = request.getParameter("topicName");
            int chapterId = Integer.parseInt(request.getParameter("chapterName"));

            TopicQuestionBean tbean=new TopicQuestionBean();
            tbean.setTopicId(hid);
            tbean.setTopicName(topicName);
            tbean.setChapterId(chapterId);



            boolean flag = TopicQuestionDao.update(tbean);
            List topicList = TopicQuestionDao.disp();
            request.setAttribute("topicList", topicList);
            RequestDispatcher rd = request.getRequestDispatcher("/TopicDisplay.jsp");
            rd.forward(request, response);

        }
    }
}
