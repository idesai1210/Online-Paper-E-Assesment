/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.servlet;

import av.online_exampaper.dao.CityDao;
import av.online_exampaper.dao.CountryDao;
import av.online_exampaper.dao.StateDao;
import av.online_exampaper.bean.CityBean;
import av.online_exampaper.bean.StateBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bhumi
 */
public class CityServlet extends HttpServlet {

   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().contains("InsertServlet")) {
            String city_name = request.getParameter("cityname");
            int state = Integer.parseInt(request.getParameter("state"));

            CityBean cbean = new CityBean();
            cbean.setCityName(city_name);
            cbean.setStateId(state);


            boolean flag = CityDao.cityInsert(cbean);


            //  request.setAttribute("insert", "insert record.....");
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/CityInsertUpdate.jsp");
            rd.forward(request, response);

        } else if (request.getRequestURI().contains("SelectServlet")) {
            List stateList = StateDao.stateShow();
            List countryList = CountryDao.countryShow();
            request.setAttribute("Select", stateList);
            request.setAttribute("countryList", countryList);
            RequestDispatcher rd = request.getRequestDispatcher("/Admin/CityInsertUpdate.jsp");
            rd.forward(request, response);


        } else if (request.getRequestURI().contains("ShowServlet")) {

            List cityList = CityDao.cityShow();
            if (cityList != null) {
                request.setAttribute("cityList", cityList);
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CityDisplay.jsp");
                rd.forward(request, response);
            }
        } else if (request.getRequestURI().contains("DeleteServlet")) {
            int city_id = Integer.parseInt(request.getParameter("hid"));
            CityBean cbean = new CityBean();
            cbean.setCityId(city_id);
            boolean flag = CityDao.cityDelete(city_id);
            request.setAttribute("show", CityDao.cityShow());

            if (flag) {
                request.setAttribute("delete", "delete record...");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CityDisplay.jsp");
                rd.forward(request, response);

            }
        } else if (request.getRequestURI().contains("FetchServlet")) {
            int id = Integer.parseInt(request.getParameter("hid"));
            List cityList = CityDao.cityFetch(id);

            if (cityList != null) {
                request.setAttribute("cityList", cityList);
                request.setAttribute("stateList", StateDao.stateShow());
                request.setAttribute("countryList", CountryDao.countryShow());
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CityInsertUpdate.jsp");
                rd.forward(request, response);

            }



        } else if (request.getRequestURI().contains("UpdateServlet")) {
            int city_id = Integer.parseInt(request.getParameter("hid"));
            String city_name = request.getParameter("cityname");
            int stateid = Integer.parseInt(request.getParameter("state"));
            CityBean cbean = new CityBean();
            cbean.setCityId(city_id);
            cbean.setCityName(city_name);
            cbean.setStateId(stateid);
            boolean flag = CityDao.cityUpdate(cbean);
            request.setAttribute("show", CityDao.cityShow());

            System.out.println("Flag Update:=" + flag);


            if (flag) {

                request.setAttribute("upd", "update record..........");
                RequestDispatcher rd = request.getRequestDispatcher("/Admin/CityDisplay.jsp");
                rd.forward(request, response);

            }
        }


    }
}