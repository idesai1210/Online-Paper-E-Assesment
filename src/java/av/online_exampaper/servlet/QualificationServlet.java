/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.QualificationBean;
import av.online_exampaper.bean.UniversityBean;
import av.online_exampaper.dao.QualificationDao;
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
public class QualificationServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String qname = request.getParameter("qualificationName");

            QualificationBean qbean = new QualificationBean();
            qbean.setQualificationName(qname);

         
            boolean flag = QualificationDao.qualiInsert(qbean);
            System.out.println("Flag For Qualification:="+flag);
            if (flag) {
               
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/QualificationInsertUpdate.jsp");
                rd.forward(request, response);
            } else {
               
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/QualificationInsertUpdate.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("ShowServlet")) {

            List qualiList = QualificationDao.QualiDisplay();
            System.out.println("List==========" + qualiList.size());
            request.setAttribute("qualiList", qualiList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/QualificationDisplay.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = QualificationDao.QualiDelete(id);
            System.out.println("Flag====" + flag);
            List qualiList = QualificationDao.QualiDisplay();
            if (flag) {
                request.setAttribute("qualiList", qualiList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/QualificationDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/QualificationDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));

            List qualiList = QualificationDao.getBypk(hid);
            request.setAttribute("qualiList", qualiList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/QualificationInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            // int uid=Integer.parseInt(request.getParameter("uid"));
            String qname = request.getParameter("qname");

            QualificationBean qbean=new QualificationBean();
            qbean.setQualificationId(hid);
            // ubean.setUniversityid(uid);
            qbean.setQualificationName(qname);

            //QualificationDao qd = new QualificationDao();

            boolean flag = QualificationDao.QualiUpdate(qbean);
            List qualiList = QualificationDao.QualiDisplay();
            //System.out.println("List====="+ulist.size());
            request.setAttribute("qualiList", qualiList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/QualificationDisplay.jsp");
            rd.forward(request, response);

        }

    }

}
