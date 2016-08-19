/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

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
 * @author HP I5
 */
public class PaperCreationServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List subjectList = SubjectDao.disp();
        List unitList = UnitQuestionDao.disp();
        List chapterList = ChapterQuestionDao.disp();
        List topicList = TopicQuestionDao.disp();
//        List questionTypeList = QuestionTypeDao.questionTypeDisplay();


        request.setAttribute("subjectList", subjectList);
        request.setAttribute("unitList", unitList);
        request.setAttribute("chapterList", chapterList);
        request.setAttribute("topicList", topicList);
//        request.setAttribute("questionTypeList", questionTypeList);

        System.out.println("Subject List==" + subjectList.size());
        System.out.println("unit List==" + unitList.size());
        System.out.println("Chapter List==" + chapterList.size());
        System.out.println("Topic List==" + topicList.size());
//        System.out.println("Question Type List==" + questionTypeList.size());

        RequestDispatcher rd = request.getRequestDispatcher("/PaperCreaiton.jsp");
        rd.forward(request, response);
    }
}
