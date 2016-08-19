/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.EvaluationLoadBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KLINGON
 */
public class LoadFileDao {
    
     private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs=null,rs1=null;
    private static PreparedStatement ps=null;

    public static int saveAnswerSheet(String enrollid, String path, String pprid) {
        int id=0;
        System.out.println(enrollid);
        System.out.println(path);
        System.out.println(pprid);
        boolean flag=false;
         try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            
            
            String q1 = "select * from  student_answersheet where student_id='"+ enrollid +"' and paper_id='"+ pprid +"'" ;

            ResultSet rs = stmt.executeQuery(q1);
            
            while (rs.next()) {
                flag=true;
                System.out.println("*****"+flag);
            }
            if(flag==false)
            {
                String q2="insert into student_answersheet values(null,'"+ enrollid +"','"+ pprid +"','"+ path +"')";
                id=stmt.executeUpdate(q2);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
    
    
    public String college(String id) {
         String collname="";
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            
            
            String q1 = "select college_name from college where college_id='"+ id +"'";

            ResultSet rs = stmt.executeQuery(q1);
            
            while (rs.next()) {
                collname=rs.getString(1).toString();
                            }
            System.out.println("---------------"+collname);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return collname;
    }
    
    public String dept(String id) {
         String deptname="";
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            
            
            String q1 = "select department_name from department where department_id='"+ id +"'";

            ResultSet rs = stmt.executeQuery(q1);
            
            while (rs.next()) {
                deptname=rs.getString(1).toString();
                            }
            System.out.println("---------------"+deptname);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return deptname;
    }
    
    public String sub(String id) {
         String subname="";
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            
            
            String q1 = "select subject_name from subject where suject_id='"+ id +"'";

            ResultSet rs = stmt.executeQuery(q1);
            
            while (rs.next()) {
                subname=rs.getString(1).toString();
                            }
            System.out.println("---------------"+subname);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return subname;
    }
    
     public String deg(String degid) {
        
         String degname="";
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            
            
            String q1 = "select degree_name from degree where degree_id='"+ degid +"'";

            ResultSet rs = stmt.executeQuery(q1);
            
            while (rs.next()) {
                degname=rs.getString(1).toString();
                            }
            System.out.println("---------------"+degname);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return degname; 
     }
    
    
  
    public String ppr(String id) {
        String pprname="";
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            
            
            String q1 = "select paper_name from paper_master where paper_id='"+ id +"'";

            ResultSet rs = stmt.executeQuery(q1);
            
            while (rs.next()) {
                pprname=rs.getString(1).toString();
                            }
            System.out.println("---------------"+pprname);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return pprname; }

   
    
}
