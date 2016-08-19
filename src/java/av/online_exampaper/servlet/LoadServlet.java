/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.bean.InsertBean;
import av.online_exampaper.bean.RegistrationBean;
import av.online_exampaper.dao.RegistrationDao;
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
public class LoadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getRequestURI().contains("FormData"))
        {
            System.out.println("-------here-----");
            RegistrationDao dao = new RegistrationDao();
            
            List<RegistrationBean> couList = dao.countryList();
            List<RegistrationBean> sList = dao.stateList();
            List<RegistrationBean> cList = dao.cityList();
            List<RegistrationBean> sqList = dao.secqueList();
            List<RegistrationBean> ugList = dao.udgradList();
            List<RegistrationBean> pgList = dao.postgradList();
            List<RegistrationBean> collList = dao.collegeList();
            List<RegistrationBean> degList = dao.degreeList();
            
            
            request.setAttribute("couList",couList);
            request.setAttribute("sList", sList);
            request.setAttribute("cList", cList);
            request.setAttribute("sqList", sqList);
            request.setAttribute("ugList", ugList);
            request.setAttribute("pgList", pgList);
            request.setAttribute("collList", collList);
            request.setAttribute("degList", degList);
            
            System.out.println("----------"+couList);
            System.out.println("--------"+sList);
            System.out.println("--------"+cList);
            System.out.println("------"+sqList);
            System.out.println("--------"+ugList);
            System.out.println("-------"+pgList);
            System.out.println("-------"+collList);
            request.setAttribute("-------",degList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
            rd.forward(request, response);
        }
        
        else if(request.getRequestURI().contains("Insert"))
        {
            String firstname=request.getParameter("firstname");
            String lastName=request.getParameter("lastname");
            String middleName=request.getParameter("middlename");
            String address=request.getParameter("address");
            int couId=Integer.parseInt(request.getParameter("country"));
            int sId=Integer.parseInt(request.getParameter("state"));
            int cId=Integer.parseInt(request.getParameter("city"));
            String pincode=request.getParameter("pincode");
            String gender=request.getParameter("gen");
            String mNo=request.getParameter("number");
            String tNo=request.getParameter("telphone");
            String dob=request.getParameter("dob");
            String email=request.getParameter("email");
            String altemail=request.getParameter("altemail");
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            int utype=Integer.parseInt(request.getParameter("usertype"));
            int sque1=Integer.parseInt(request.getParameter("secques1"));
            String ans1=request.getParameter("answer1");
            int sque2=Integer.parseInt(request.getParameter("secques2"));
            String ans2=request.getParameter("answer2");
            int ugadId=Integer.parseInt(request.getParameter("graduate_id"));
            int pgadId=Integer.parseInt(request.getParameter("postgraduate_id"));
            String otherqual=request.getParameter("other_qualification");
            //int collId=Integer.parseInt(request.getParameter("college_id"));
            int degId=Integer.parseInt(request.getParameter("degree_id"));
            String doj=request.getParameter("doj");
            String exp=request.getParameter("experience");
            
            System.out.println("firstname:"+firstname);
            System.out.println("lastname:"+lastName);
            System.out.println("middlename:"+middleName);
            System.out.println("address:"+address);
            System.out.println("gender:"+gender);
            System.out.println("pincode:"+pincode);
            System.out.println("mobile:"+mNo);
            System.out.println("telephone:"+tNo);
            System.out.println("dob:"+dob);
            System.out.println("email:"+email);
            System.out.println("alternate email:"+altemail);
            System.out.println("username"+username);
            
            InsertBean bean=new InsertBean();
            bean.setFirstName(firstname);
            bean.setLastName(lastName);
            bean.setMiddleName(middleName);
            bean.setAddress(address);
            bean.setCouId(couId);
            bean.setsId(sId);
            bean.setcId(cId);
            bean.setPincode(pincode);
            bean.setGender(gender);
            bean.setmNo(mNo);
            bean.settNo(tNo);
            bean.setDob(dob);
            bean.setEmail(email);
            bean.setAltemail(altemail);
            bean.setUsername(username);
            bean.setPassword(password);
            bean.setUtype(utype);
            bean.setSque1(sque1);
            bean.setAns1(ans1);
            bean.setSque2(sque2);
            bean.setAns2(ans2);
            bean.setUgadId(ugadId);
            bean.setPgadId(pgadId);
            bean.setOtherqual(otherqual);
           // bean.setCollId(collId);
            bean.setDegId(degId);
            bean.setDoj(doj);
            bean.setExp(exp);
            
            RegistrationDao ins=new RegistrationDao();
            boolean flag=ins.Insert(bean);
            System.out.println("Flag On Registration====="+flag);
            if(flag==true)
            {
                System.out.println("----Data INSERTED----");
                response.sendRedirect("/OPEAM/Login.jsp");
//                RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
//                rd.forward(request,response);
            }
            else
            {
                request.setAttribute("Already exist", "msg");
                RequestDispatcher rd=request.getRequestDispatcher("/Register.jsp");
                rd.forward(request,response);
            }
            
            
            

        }
        else if(request.getRequestURI().contains("Country"))
        {
            System.out.println("-----Countryheereee---");
            String cId=request.getParameter("hid");
            request.setAttribute("cId", cId);
            System.out.println("******"+cId);
            
            //RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
            //rd.forward(request, response);
        }

    }
}
