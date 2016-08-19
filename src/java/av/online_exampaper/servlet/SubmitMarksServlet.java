/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.ListAnswerBean;
import av.online_exampaper.bean.MarksBean;
import av.online_exampaper.dao.ListAnswerSheetDao;
import av.online_exampaper.dao.MarksDao;
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
 * @author KLINGON
 */
public class SubmitMarksServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        
        String paper_id=session.getAttribute("anspaper_id").toString();
        String student_id=session.getAttribute("ansstudent_id").toString();
        System.out.println("submit marks for paper _id:"+paper_id);
        System.out.println("submit marks for paper _id:"+student_id);
        
        List<MarksBean> quesidlist=MarksDao.totalquesid(paper_id);
        List<MarksBean> quesmarkslist=new ArrayList<MarksBean>();
        MarksBean b1=new MarksBean();
        String queName[]=new String[100];
        String queid[]=new String[100];
        int length=quesidlist.size();
        for(int i=0;i<length;i++)
                {
                    b1=(MarksBean)quesidlist.get(i);
                    queid[i]=b1.getExamquesid();
                    queName[i]=b1.getMq()+"_"+b1.getSq()+"_"+b1.getQue();
                    
                }
        String marks[]=new String[100];
        MarksBean b2=null;new MarksBean();
        for(int i=0;i<length;i++)
                {
                    b2=new MarksBean();;
                    marks[i]=request.getParameter(queName[i]).toString();
                    b2.setMarks(marks[i]);
                    b2.setExamquesid(queid[i]);
                    quesmarkslist.add(b2);
                }
        int insert=MarksDao.insertMarks(quesmarkslist,student_id);
        
        String listshowpprid=session.getAttribute("listshowpprid").toString();
        ListAnswerBean bean=new ListAnswerBean();
        bean.setPprid(listshowpprid);
        
        List<ListAnswerBean> anslist=ListAnswerSheetDao.list(bean);
        
        request.setAttribute("anslist", anslist);
        
        RequestDispatcher rd=request.getRequestDispatcher("/AnswerSheetList.jsp");
        rd.forward(request, response);
        
    }

   
}
