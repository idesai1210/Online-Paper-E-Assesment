/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.bean.StateBean;
import av.online_exampaper.dao.CountryDao;
import av.online_exampaper.dao.StateDao;
//import av.online_ExamPaper.Dao.SteteDao;
import av.online_exampaper.bean.StateBean;
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
 * @author Bhumi
 */
public class StateServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("InsertServlet")) {
            String state_name = request.getParameter("state_name");
            int country = Integer.parseInt(request.getParameter("country"));
            StateBean sbean = new StateBean();
            sbean.setStateName(state_name);
            sbean.setCountryId(country);
            boolean flag = StateDao.stateInsert(sbean);


            request.setAttribute("insert", "insert record.....");
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/StateInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("SelectList")) {
            List countryList = CountryDao.countryShow();
            request.setAttribute("countryList", countryList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/StateInsertUpdate.jsp");
            rd.forward(request, response);


        } else if (request.getRequestURI().contains("ShowServlet")) {

            List stateList = StateDao.stateShow();
            if (stateList != null) {
                request.setAttribute("stateList", stateList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/StateDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("DeleteServlet")) {
            int state_id = Integer.parseInt(request.getParameter("hid"));


            StateBean bean = new StateBean();
            bean.setStateId(state_id);

            boolean flag = StateDao.stateDelete(state_id);
            request.setAttribute("stateList", StateDao.stateShow());

            if (flag) {
                request.setAttribute("delete", "delete record...");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/StateDisplay.jsp");
                rd.forward(request, response);

            }
        } else if (request.getRequestURI().contains("FetchServlet")) {
            int id = Integer.parseInt(request.getParameter("hid"));

            List stateList = StateDao.stateFetch(id);
            if (stateList != null) {
                request.setAttribute("stateList", stateList);
                request.setAttribute("countryList", CountryDao.countryShow());
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/StateInsertUpdate.jsp");
                rd.forward(request, response);

            }
        } else if (request.getRequestURI().contains("UpdateServlet")) {
            int state_id = Integer.parseInt(request.getParameter("hid"));
            String state_name = request.getParameter("statename");
            int countryid = Integer.parseInt(request.getParameter("country"));
            StateBean bean = new StateBean();
            bean.setStateId(state_id);
            bean.setStateName(state_name);
            bean.setCountryId(countryid);
            boolean flag = StateDao.stateUpdate(bean);
            System.out.println("Flag Update:=" + flag);
            List stateList = StateDao.stateShow();
            request.setAttribute("stateList", stateList);

            if (flag) {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/StateDisplay.jsp");
                rd.forward(request, response);

            }

        }

    }
}
