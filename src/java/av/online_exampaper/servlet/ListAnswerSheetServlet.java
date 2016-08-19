/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.ListAnswerBean;
import av.online_exampaper.dao.ListAnswerSheetDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KLINGON
 */
public class ListAnswerSheetServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String pprid=request.getParameter("paper");
        
        HttpSession session=request.getSession();
        session.removeAttribute("listshowpprid");
        session.setAttribute("listshowpprid",pprid);
       
        System.out.println("List answer sheet paper id:"+pprid);
        ListAnswerBean bean=new ListAnswerBean();
        bean.setPprid(pprid);
        
        List<ListAnswerBean> anslist=ListAnswerSheetDao.list(bean);
        
        request.setAttribute("anslist", anslist);
        
        RequestDispatcher rd=request.getRequestDispatcher("/AnswerSheetList.jsp");
        rd.forward(request, response);
        
    }
    
    
    
}
