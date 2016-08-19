/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.QuestionBean;
import av.online_exampaper.dao.ChapterQuestionDao;
import av.online_exampaper.dao.QuestionDao;
import av.online_exampaper.dao.TopicQuestionDao;
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
 * @author HP I5
 */
public class QuestionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String question = request.getParameter("question");
            int topicId = Integer.parseInt(request.getParameter("topicName"));
            String marks = request.getParameter("mark");
            int questionTypeId = Integer.parseInt(request.getParameter("questionType"));
            String mcqOption1 = request.getParameter("option1");
            String mcqOption2 = request.getParameter("option2");
            String mcqOption3 = request.getParameter("option3");
            String mcqOption4 = request.getParameter("option4");

            QuestionBean qbean = new QuestionBean();
            qbean.setQuestion(question);
            qbean.setTopicId(topicId);
            qbean.setDefaultMark(marks);
            qbean.setQuestionTypeId(questionTypeId);
            qbean.setOption1(mcqOption1);
            qbean.setOption2(mcqOption2);
            qbean.setOption3(mcqOption3);
            qbean.setOption4(mcqOption4);

            boolean flag = QuestionDao.questionInsert(qbean);

            if (flag) {

                response.sendRedirect("/OPEAM/QuestionInsert.jsp");
            } else {
                request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/QuestionInsert.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("ShowServlet")) {
            List questionList = QuestionDao.questionDisplay();
            request.setAttribute("questionList", questionList);
            RequestDispatcher rd = request.getRequestDispatcher("/QuestionDisplay.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = QuestionDao.questionDelete(id);
            List questionList = QuestionDao.questionDisplay();
            if (flag) {
                request.setAttribute("questionList", questionList);
                RequestDispatcher rd = request.getRequestDispatcher("/QuestionDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/QuestionDisplay.jsp");
                rd.forward(request, response);
            }
        }


    }
}
