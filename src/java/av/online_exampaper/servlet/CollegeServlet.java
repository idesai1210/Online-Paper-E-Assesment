/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.CollegeBean;
import av.online_exampaper.bean.UniversityBean;
import av.online_exampaper.dao.CollegeDao;
import av.online_exampaper.dao.UniversityDao;
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
public class CollegeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
      if(request.getRequestURI().contains("InsertServlet")){
            String cname=request.getParameter("cnm");
            int uid=Integer.parseInt(request.getParameter("usnm"));
            
            CollegeBean cbean=new CollegeBean();
            cbean.setCollegeName(cname);
            cbean.setUniversityId(uid);
            
            
            CollegeDao cd=new CollegeDao();
            boolean flag=cd.collgeInsert(cbean);
            
            if(flag){
                //request.setAttribute("msg", "Data Inserted......");
                RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeInsertUpdate.jsp");
                rd.forward(request, response);
            }
            else{
                //request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeInsertUpdate.jsp");
                rd.forward(request, response);
            }
      
      
      }
         else if(request.getRequestURI().contains("SelectList")){
          
           //
            List universityList=UniversityDao.universityDisplay();
            System.out.println("University List===="+universityList.size());
            //System.out.println("List=========="+clist.size());
           // request.setAttribute("clist", clist);
            request.setAttribute("universityList", universityList);
            RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeInsertUpdate.jsp");
            rd.forward(request, response);
            
        }
      else if(request.getRequestURI().contains("ShowServlet")){
          
            List collegeList=CollegeDao.collegeDisplay();
            request.setAttribute("collegeList", collegeList);
            System.out.println("List=========="+collegeList.size());
            
            RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeDisplay.jsp");
            rd.forward(request, response);
      }
      else if(request.getRequestURI().contains("/DeleteServlet")){
          
          int id=Integer.parseInt(request.getParameter("hid"));
            
          boolean flag=CollegeDao.collegeDelete(id);
          List collegeList=CollegeDao.collegeDisplay();
          if(flag){
               request.setAttribute("collegeList", collegeList);
               RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeDisplay.jsp");
               rd.forward(request, response);
          }else{
               RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeDisplay.jsp");
               rd.forward(request, response);
           }
      
      }
      else if(request.getRequestURI().contains("FetchServlet")){
            
            int hid=Integer.parseInt(request.getParameter("hid"));
            List universityList=UniversityDao.universityDisplay();
            List collegeList=CollegeDao.getBypk(hid);
            
            request.setAttribute("collegeList", collegeList);
            request.setAttribute("universityList", universityList);
            System.out.println("College List Fetiching======"+collegeList.size());
            RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeInsertUpdate.jsp");
            rd.forward(request, response);
            
       }
       else if(request.getRequestURI().contains("UpdateServlet")){
            
            int hid=Integer.parseInt(request.getParameter("hid"));
           // int uid=Integer.parseInt(request.getParameter("uid"));
            String cname=request.getParameter("cname");
            int uid=Integer.parseInt(request.getParameter("unm"));
            
            CollegeBean cbean=new CollegeBean();
            cbean.setCollegeId(hid);
           // ubean.setUniversityid(uid);
            cbean.setCollegeName(cname);
            cbean.setUniversityId(uid);
            
            
            CollegeDao cd=new CollegeDao();
            
            boolean flag=cd.collegeUpdate(cbean);
            List collegeList=CollegeDao.collegeDisplay();
           //System.out.println("List====="+ulist.size());
            request.setAttribute("collegeList", collegeList);
            RequestDispatcher rd=request.getRequestDispatcher("/Admin/CollegeDisplay.jsp");
            rd.forward(request, response); 
                
        }
        
        
    }
 
    
}
