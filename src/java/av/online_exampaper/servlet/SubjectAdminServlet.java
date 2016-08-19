/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.DegreeBean;
import av.online_exampaper.bean.SubjectAdminBean;
import av.online_exampaper.dao.CollegeDao;
import av.online_exampaper.dao.DegreeDao;
import av.online_exampaper.dao.DepartmentDao;
import av.online_exampaper.dao.SubjectAdminDao;
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
public class SubjectAdminServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String subjectName = request.getParameter("subjectnm");
            int degreeId = Integer.parseInt(request.getParameter("degreenm"));
            //int uid=Integer.parseInt(request.getParameter("usnm"));

            SubjectAdminBean subjectBean = new SubjectAdminBean();
            subjectBean.setSubjectname(subjectName);
            subjectBean.setDegreeid(degreeId);

            boolean flag = SubjectAdminDao.Insert(subjectBean);

            if (flag) {

                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectInsertUpdate.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectInsertUpdate.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("AllListServlet")) {

            
            List departmentList = DepartmentDao.departmentDisplay();
            List degreeList = DegreeDao.degreeDisplay();

            request.setAttribute("degreeList", degreeList);
            request.setAttribute("departmentList", departmentList);

            System.out.println("College List==========" + degreeList.size());
            System.out.println("Department List==========" + departmentList.size());
                
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("ShowServlet")) {

            List subjectList = SubjectAdminDao.disp();
            request.setAttribute("subjectList", subjectList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectDisplay.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("/DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = SubjectAdminDao.delete(id);
            List subjectList = SubjectAdminDao.disp();
            if (flag) {
                request.setAttribute("subjectList", subjectList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectDisplay.jsp");
                rd.forward(request, response);
            }

        }else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));

            List departmentList = DepartmentDao.departmentDisplay();
            List degreeList = DegreeDao.degreeDisplay();

            List subjectList = SubjectAdminDao.getBypk(hid);

            request.setAttribute("departmentList", departmentList);
            request.setAttribute("degreeList", degreeList);
            request.setAttribute("subjectList", subjectList);
            

            RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectInsertUpdate.jsp");
            rd.forward(request, response);

        }else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            String subjectName = request.getParameter("subName");
            int degreeId = Integer.parseInt(request.getParameter("degreeName"));

            SubjectAdminBean sBean = new SubjectAdminBean();
            sBean.setSubjectid(hid);
            sBean.setSubjectname(subjectName);
            sBean.setDegreeid(degreeId);

            boolean flag = SubjectAdminDao.update(sBean);
            List subjectList = SubjectAdminDao.disp();

            request.setAttribute("subjectList", subjectList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/SubjectDisplay.jsp");
            rd.forward(request, response);

        }

    }

}
