/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.CountryBean;
import av.online_exampaper.bean.SecurityBean;
import av.online_exampaper.dao.CountryDao;
import av.online_exampaper.dao.SecurityDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bhumi
 */
public class SecurityServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {

            String s_question = request.getParameter("secQuestion");

            SecurityBean sbean = new SecurityBean();
            sbean.setSecurityQuestion(s_question);
            boolean flag = SecurityDao.securityInsert(sbean);
            if (flag) {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SecurityInsertUpdate.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("ShowServlet")) {
            List securityList = SecurityDao.securityShow();
            if (securityList != null) {

                request.setAttribute("show", securityList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SecurityDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("DeleteServlet")) {
            int s_question_id = Integer.parseInt(request.getParameter("hid"));
            System.out.println("==================hid----" + request.getParameter("hid"));
            String s_question = request.getParameter("s_question");
            SecurityBean cbean = new SecurityBean();
            cbean.setSecurityId(s_question_id);
            cbean.setSecurityQuestion(s_question);
            boolean flag = SecurityDao.secrityDelete(cbean);
            request.setAttribute("show", SecurityDao.securityShow());
            if (flag) {
                //request.setAttribute("delete", "delete record");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SecurityDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("FetchServlet")) {
            int id = Integer.parseInt(request.getParameter("hid"));
            List securityList = SecurityDao.securityFetch(id);
            System.out.println("List Size....." + securityList.size());
            if (securityList != null) {
                request.setAttribute("show", securityList);
                // request.setAttribute("show", CountryDao.show());
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SecurityInsertUpdate.jsp");
                rd.forward(request, response);

            }

        } else if (request.getRequestURI().contains("UpdateServlet")) {
            int securityId = Integer.parseInt(request.getParameter("hid"));
            String securityQuestion = request.getParameter("s_question");

            SecurityBean ubean = new SecurityBean();
            ubean.setSecurityId(securityId);
            ubean.setSecurityQuestion(securityQuestion);

            boolean flag = SecurityDao.securityUpdate(ubean);
            System.out.println("Flag Update:=" + flag);
            List securityList = SecurityDao.securityShow();

            if (flag) {

                //request.setAttribute("upd", "update record..........");
                request.setAttribute("show", securityList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/SecurityDisplay.jsp");
                rd.forward(request, response);

            }

        }
    }
}
