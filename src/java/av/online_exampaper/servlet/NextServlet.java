/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class NextServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        int i=Integer.parseInt(session.getAttribute("i").toString());
        System.out.println("Next answer sheet:"+i);
               i++;
                session.setAttribute("i",i);
                System.out.println(i);
                RequestDispatcher rd = request.getRequestDispatcher("/openpic.jsp");
                rd.forward(request, response);
    }

    
}
