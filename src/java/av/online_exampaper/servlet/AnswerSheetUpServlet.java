/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.EvaluationLoadBean;
import av.online_exampaper.dao.EvaluationLoadDao;
import av.online_exampaper.dao.LoadFileDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

        

/**
 *
 * @author KLINGON
 */
@WebServlet("/f1")
@MultipartConfig
public class AnswerSheetUpServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getRequestURI().contains("Load"))
        {
//            System.out.println("-------here-----");
//            EvaluationLoadDao dao = new EvaluationLoadDao();
//            
//           
//            List<EvaluationLoadBean> collList = dao.collegeList();
//            List<EvaluationLoadBean> dptList = dao.dptList();
//           
//            List<EvaluationLoadBean> subList = dao.subList();
//            List<EvaluationLoadBean> pprList = dao.pprList();
//
//            
//            request.setAttribute("collList", collList);
//            request.setAttribute("dptList",dptList);
//            
//            request.setAttribute("subList",subList);
//            request.setAttribute("pprList",pprList);
//           
//            System.out.println("--------"+dptList);
//            System.out.println("-------"+collList);
//            System.out.println("-------"+subList);
//            System.out.println("-------"+pprList);
            RequestDispatcher rd = request.getRequestDispatcher("/index_1.jsp");
            rd.forward(request, response);
        }
        
        else if(request.getRequestURI().contains("File"))
        {
           
            String collid=request.getParameter("college_id");
            System.out.println("qwerty"+collid);
            String deptid=request.getParameter("department");
            String subid=request.getParameter("subject");
            String degid=request.getParameter("degree_id");
            String enrollid=request.getParameter("enrollid");
            String pprid=request.getParameter("paper");
            
            LoadFileDao dao = new LoadFileDao();
            
            String coll=dao.college(collid).toString();
            String dept=dao.dept(deptid).toString();
            String sub=dao.sub(subid).toString();
            String deg=dao.deg(degid).toString();
            String ppr=dao.ppr(pprid).toString();
            
            HttpSession session=request.getSession();
            
            session.setAttribute("enrollid",enrollid);
            session.setAttribute("pprid",pprid);
            
            session.setAttribute("path",coll+"/"+dept+"/"+deg+"/"+sub+"/"+ppr+"/"+enrollid );
            
            request.setAttribute("path1",coll+"/"+dept+"/"+deg+"/"+sub+"/"+ppr+"/"+enrollid );
            request.getRequestDispatcher("/index_1.jsp").forward(request, response);
        }
            }


}
