/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.CountryBean;
import av.online_exampaper.bean.SecurityBean;
import static av.online_exampaper.dao.CountryDao.conn;
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
 * @author Bhumi
 */
public class SecurityDao {
 
    static Connection conn=null;
    static Statement stmt=null;
    static boolean flag=false;
    static PreparedStatement pst=null;
    static ResultSet rs=null;



public static boolean securityInsert(SecurityBean sbean)
        
{
 try{
     
     conn=ConnectionUtill.getCon();
     String securityInsert ="insert into Security_Question(security_question)values(?)";
     pst=conn.prepareStatement(securityInsert);
    
     //pst.setInt(1,sbean.getS_question_id());
    
     pst.setString(1, sbean.getSecurityQuestion());
      int i= pst.executeUpdate();
     if(i>0)
      {
           
          flag=true;
          System.out.println("insert record");
     }else
     {
         System.out.println("not insert data");
     }
 }catch(SQLException e)
 {
     System.out.println("insert error");
 }
 return flag;

}
public static List securityShow()
{
    List securityList=new ArrayList();
    try{
        SecurityBean sbean=null;
        conn=ConnectionUtill.getCon();
        String securitySelect="select * from Security_Question";
        pst=conn.prepareStatement(securitySelect);
        rs=pst.executeQuery();
        while(rs.next())
        {
            sbean=new SecurityBean();
            sbean.setSecurityId(rs.getInt(1));
            sbean.setSecurityQuestion(rs.getString(2));
           securityList.add(sbean);
        }
    }catch(SQLException e)
    {
        System.out.println("display error");
    }
    return securityList;
}

public static boolean secrityDelete(SecurityBean cbean)
{
    try{
        conn=ConnectionUtill.getCon();
        String securityDelete="delete from Security_Question where security_question_id=(?)";
        pst=conn.prepareStatement(securityDelete);
        pst.setInt(1, cbean.getSecurityId());
        int d=pst.executeUpdate();
        if(d>0)
        {
            flag=true;
            System.out.println("delete record");
        }else
        {
            System.out.println("not delete");
        }
        
    }catch(SQLException e)
    {
        System.out.println(" delete error");
    }
    return flag;
}
 public static List securityFetch(int id)
    {
        List securityList=new ArrayList();
        try{
            
            conn=ConnectionUtill.getCon();
            String securityFetch="select * from Security_Question where security_question_id=(?)";
            
            pst=conn.prepareStatement(securityFetch);
            pst.setInt(1, id);
            
            rs=pst.executeQuery();
            while (rs.next()) { 
                SecurityBean fbean=new SecurityBean();
            
                fbean.setSecurityId(rs.getInt(1));
                fbean.setSecurityQuestion(rs.getString(2));
                securityList.add(fbean);
            }
        }catch(SQLException e)
        {
            System.out.println("fatch error..........");
        }
        return securityList;
   
}
  public static boolean securityUpdate(SecurityBean ubean)
    {
        try{
            conn=ConnectionUtill.getCon();
            String update="update Security_Question set security_question=(?) where security_question_id=(?)";
            pst=conn.prepareStatement(update);
            pst.setString(1, ubean.getSecurityQuestion());
            pst.setInt(2, ubean.getSecurityId());
            int u=pst.executeUpdate();
            if(u>0)
            {
                flag=true;
                System.out.println("updated record");
            }else
            {
                System.out.println("not updated record");
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return flag;
        
    }
   
}


        