/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.dao.CountryDao;
import av.online_exampaper.bean.CountryBean;
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
public class CountryServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().contains("InsertServlet")) {
            String country_name = request.getParameter("countryname");
            CountryBean bean = new CountryBean();
            bean.setCountryName(country_name);
            boolean flag = CountryDao.countryInsert(bean);

            if (flag) {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CountryInsertUpdate.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("ShowServlet")) {
            List countryList = CountryDao.countryShow();
            if (countryList != null) {
                request.setAttribute("countryList", countryList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CountryDisplay.jsp");
                rd.forward(request, response);
            }

        } else if (request.getRequestURI().contains("DeleteServlet")) {
            int country_id = Integer.parseInt(request.getParameter("hid"));
            String country_name = request.getParameter("country_name");
            CountryBean bean = new CountryBean();
            bean.setCountryId(country_id);
            bean.setCountryName(country_name);
            boolean flag = CountryDao.countryDelete(bean);
            request.setAttribute("countryList", CountryDao.countryShow());
            if (flag) {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CountryDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("FetchServlet")) {
            int id = Integer.parseInt(request.getParameter("hid"));
            List countryList = CountryDao.countryFetch(id);
            if (countryList != null) {
                request.setAttribute("countryList", countryList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CountryInsertUpdate.jsp");
                rd.forward(request, response);

            }

        } else if (request.getRequestURI().contains("UpdateServlet")) {
            int country_id = Integer.parseInt(request.getParameter("hid"));
            String country_name = request.getParameter("countryname");

            CountryBean bean = new CountryBean();
            bean.setCountryId(country_id);
            bean.setCountryName(country_name);

            boolean flag = CountryDao.countryUpdate(bean);
            List countryList = CountryDao.countryShow();

            if (flag) {

                request.setAttribute("countryList", countryList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CountryDisplay.jsp");
                rd.forward(request, response);
            }
        }

    }
}
