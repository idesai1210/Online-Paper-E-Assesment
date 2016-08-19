/*
 * To change this template, choose Tools | Templates
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
import org.apache.catalina.Session;

/**
 *
 * @author HP I5
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        HttpSession session=request.getSession();
        session.invalidate();
        RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
        rd.forward(request, response);
    }

    
}
