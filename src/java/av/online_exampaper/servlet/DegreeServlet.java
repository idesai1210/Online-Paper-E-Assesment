/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.DegreeBean;
import av.online_exampaper.bean.DepartmentBean;
import av.online_exampaper.dao.CollegeDao;
import av.online_exampaper.dao.DegreeDao;
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
public class DegreeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String degname = request.getParameter("degnm");
            int did = Integer.parseInt(request.getParameter("dnm"));
            //int uid=Integer.parseInt(request.getParameter("usnm"));

            DegreeBean degbean = new DegreeBean();
            degbean.setDegreeName(degname);
            degbean.setDepartmentId(did);

            DegreeDao degd = new DegreeDao();
            boolean flag = degd.degreeInsert(degbean);

            if (flag) {
                //request.setAttribute("msg", "Data Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeInsertUpdate.jsp");
                rd.forward(request, response);
            } else {
                //request.setAttribute("msg", "Data Not Inserted......");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeInsertUpdate.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("SelectList")) {

            //
            List universityList = UniversityDao.universityDisplay();
            List collegeList = CollegeDao.collegeDisplay();
            List departmentList = DepartmentDao.departmentDisplay();

            request.setAttribute("collegeList", collegeList);
            request.setAttribute("universityList", universityList);
            request.setAttribute("departmentList", departmentList);

            System.out.println("University List====" + universityList.size());
            System.out.println("College List==========" + collegeList.size());
            System.out.println("Department List==========" + departmentList.size());

            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("ShowServlet")) {

            List degreeList = DegreeDao.degreeDisplay();
            request.setAttribute("degreeList", degreeList);
            System.out.println("nckdnkdnkdnfjkdnfkjd---------"+degreeList.size());
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeDisplay.jsp");
            rd.forward(request, response);
        } else if (request.getRequestURI().contains("/DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = DegreeDao.degreeDelete(id);
            List degreeList = DegreeDao.degreeDisplay();
            if (flag) {
                request.setAttribute("degreeList", degreeList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeDisplay.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));

            List collegeList = CollegeDao.collegeDisplay();
            List universityList = UniversityDao.universityDisplay();
            List departmentList = DepartmentDao.departmentDisplay();

            List degreeList = DegreeDao.getBypk(hid);

            request.setAttribute("collegeList", collegeList);
            request.setAttribute("universityList", universityList);
            request.setAttribute("departmentList", departmentList);
            request.setAttribute("degreeList", degreeList);

            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            String degname = request.getParameter("degname");
            int depid = Integer.parseInt(request.getParameter("dnm"));

            DegreeBean degbean = new DegreeBean();
            degbean.setDegreeId(hid);
            degbean.setDegreeName(degname);
            degbean.setDepartmentId(depid);

            DegreeDao degd = new DegreeDao();

            boolean flag = degd.update(degbean);
            List degreeList = DegreeDao.degreeDisplay();

            request.setAttribute("degreeList", degreeList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/DegreeDisplay.jsp");
            rd.forward(request, response);

        }
    }

}
