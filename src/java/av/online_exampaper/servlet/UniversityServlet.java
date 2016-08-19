/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.UniversityBean;
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
public class UniversityServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String name = request.getParameter("unm");

            UniversityBean ubean = new UniversityBean();
            ubean.setUniversityName(name);

            UniversityDao ud = new UniversityDao();
            boolean flag = ud.universityInsert(ubean);

            if (flag) {
//                request.setAttribute("msg", "Data Inserted Successfully");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/UniversityInsertUpdate.jsp");
                rd.forward(request, response);
            } else {
//                request.setAttribute("msg", "Data Not Inserted");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/UniversityInsertUpdate.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("ShowServlet")) {

            List universityList = UniversityDao.universityDisplay();
            System.out.println("List==========" + universityList.size());
            request.setAttribute("universityList", universityList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/UniversityDisplay.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("DeleteServlet")) {

            int id = Integer.parseInt(request.getParameter("hid"));

            boolean flag = UniversityDao.universityDelete(id);
            System.out.println("Flag====" + flag);
            List universityList = UniversityDao.universityDisplay();
            if (flag) {
                request.setAttribute("universityList", universityList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/UniversityDisplay.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/UniversityDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("FetchServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));

            List universityList = UniversityDao.getBypk(hid);

            request.setAttribute("universityList", universityList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/UniversityInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("UpdateServlet")) {

            int hid = Integer.parseInt(request.getParameter("hid"));
            // int uid=Integer.parseInt(request.getParameter("uid"));
            String uname = request.getParameter("uname");

            UniversityBean ubean = new UniversityBean();
            ubean.setHid(hid);
            // ubean.setUniversityid(uid);
            ubean.setUniversityName(uname);

            UniversityDao ud = new UniversityDao();

            boolean flag = ud.universityUpdate(ubean);
            List universityList = UniversityDao.universityDisplay();
            //System.out.println("List====="+ulist.size());
            request.setAttribute("universityList", universityList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/UniversityDisplay.jsp");
            rd.forward(request, response);

        }

    }

}
