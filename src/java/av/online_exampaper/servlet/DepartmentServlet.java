/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.CollegeBean;
import av.online_exampaper.bean.DepartmentBean;
import av.online_exampaper.dao.CollegeDao;
import av.online_exampaper.dao.DepartmentDao;
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
public class DepartmentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String dname = request.getParameter("dnm");
            int cid = Integer.parseInt(request.getParameter("cnm"));
            //int uid=Integer.parseInt(request.getParameter("usnm"));

            DepartmentBean dbean = new DepartmentBean();
            dbean.setDepartmentName(dname);
            dbean.setCollegeId(cid);

            DepartmentDao dd = new DepartmentDao();
            boolean flag = dd.departmentInsert(dbean);

            if (flag) {
                //request.setAttribute("msg", "Data Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentInsertUpdate.jsp");
                rd.forward(request, response);
            } else {
                //request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentInsertUpdate.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("SelectList")) {

            //
            List universityList = UniversityDao.universityDisplay();
            List collegeList = CollegeDao.collegeDisplay();

            request.setAttribute("collegeList", collegeList);
            request.setAttribute("universityList", universityList);

            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("ShowServlet")) {

            List departmentList = DepartmentDao.departmentDisplay();
            request.setAttribute("departmentList", departmentList);

            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentDisplay.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("/DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = DepartmentDao.departmentDelete(id);
            List departmentList = DepartmentDao.departmentDisplay();
            if (flag) {
                request.setAttribute("departmentList", departmentList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentDisplay.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));

            List collegeList = CollegeDao.collegeDisplay();
            List universityList = UniversityDao.universityDisplay();

            List departmentList = DepartmentDao.getBypk(hid);

            request.setAttribute("collegeList", collegeList);
            request.setAttribute("universityList", universityList);
            request.setAttribute("departmentList", departmentList);

            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            String dname = request.getParameter("dname");
            int cid = Integer.parseInt(request.getParameter("cnm"));

            DepartmentBean dbean = new DepartmentBean();
            dbean.setDepartmentId(hid);
            dbean.setDepartmentName(dname);
            dbean.setCollegeId(cid);

            DepartmentDao dd = new DepartmentDao();

            boolean flag = dd.departmentUpdate(dbean);
            List departmentList = DepartmentDao.departmentDisplay();

            request.setAttribute("departmentList", departmentList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DepartmentDisplay.jsp");
            rd.forward(request, response);

        }
    }

}
