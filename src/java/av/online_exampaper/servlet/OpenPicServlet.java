/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.OpenPicBean;
import av.online_exampaper.dao.OpenPicDao;
import av.online_exampaper.dao.QBoxDao;
import java.io.File;
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
 
public class OpenPicServlet extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
          //if(request.getRequestURI().contains("GetPath")){
        
            OpenPicDao dao = new OpenPicDao();
            String ansstudent_id=request.getParameter("student_id").toString();
            String anspaper_id=request.getParameter("pprid").toString();
            
            System.out.println("-----studid"+ansstudent_id);
            System.out.println("-----pprid"+anspaper_id);
                
            HttpSession session=request.getSession();
            session.removeAttribute(anspaper_id);
            session.removeAttribute(ansstudent_id);
            session.setAttribute("anspaper_id",anspaper_id);
            session.setAttribute("ansstudent_id",ansstudent_id);
            List<OpenPicBean> imgList = dao.imgList(ansstudent_id,anspaper_id);
            OpenPicBean b1=new OpenPicBean();
            String path=request.getRealPath("/")+"image/";
            for(int i=0;i<imgList.size();i++)
                {
                    b1=(OpenPicBean)imgList.get(i);
                    path=path+b1.getPpath();
                    
                }
            int size=new File(path).listFiles().length;
            System.out.println("Number of files:"+size);
            
            request.setAttribute("imgList",imgList);
            System.out.println("----------123456"+imgList);
           
            session.setAttribute("size",size);
            // for question box input
            List qboxlist=new ArrayList();
            qboxlist=QBoxDao.inserty(anspaper_id);
            List qboxlist1=new ArrayList();
            qboxlist1=QBoxDao.insertx(anspaper_id);
            List qboxlist2=new ArrayList();
            qboxlist2=QBoxDao.insertz();
    
             System.out.println("123456789====="+qboxlist1);
            System.out.println("dxdhcfcv======="+qboxlist);
            
              
             if(qboxlist!=null)
            {
            //request.setAttribute("qboxlist", qboxlist);
//            session.removeAttribute("qboxlist");
//            session.removeAttribute("qboxlist1");
//            session.removeAttribute("qboxlist2");
  
            request.setAttribute("qboxlist", qboxlist);
            request.setAttribute("qboxlist1", qboxlist1);
            request.setAttribute("qboxlist2", qboxlist2);
//            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            
            
            
            //rd.forward(request, response);
        }
           // response.sendRedirect("/FrameAnswerDisplay.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("/FrameAnswerDisplay.jsp");
            rd.forward(request, response);
    }
}
