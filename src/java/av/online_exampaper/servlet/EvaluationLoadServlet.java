/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.EvaluationLoadBean;
import av.online_exampaper.dao.EvaluationLoadDao;
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
 * @author KLINGON
 */
public class EvaluationLoadServlet extends HttpServlet {

     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getRequestURI().contains("SelectCredData"))
        {
//            System.out.println("-------here-----");
//            EvaluationLoadDao dao = new EvaluationLoadDao();
//            
//            List<EvaluationLoadBean> uniList = dao.uniList();
//            List<EvaluationLoadBean> collList = dao.collegeList();
//            List<EvaluationLoadBean> dptList = dao.dptList();
//            List<EvaluationLoadBean> degList = dao.degreeList();
//            List<EvaluationLoadBean> subList = dao.subList();
//            List<EvaluationLoadBean> pprList = dao.pprList();
//
//            request.setAttribute("uniList",uniList);
//            request.setAttribute("collList", collList);
//            request.setAttribute("dptList",dptList);
//            request.setAttribute("degList", degList);
//            request.setAttribute("subList",subList);
//            request.setAttribute("pprList",pprList);
//            
//            System.out.println("----------"+uniList);
//            System.out.println("--------"+degList);
//            System.out.println("--------"+dptList);
//            System.out.println("-------"+collList);
//            System.out.println("-------"+subList);
//            System.out.println("-------"+pprList);
//            
//            RequestDispatcher rd = request.getRequestDispatcher("/Evaluation.jsp");
//            rd.forward(request, response);
        }

}
}