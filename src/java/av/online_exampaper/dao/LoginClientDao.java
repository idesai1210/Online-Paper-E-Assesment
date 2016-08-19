/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.LoginClientBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author KLINGON
 */
public class LoginClientDao {
    
    private static Connection conn=null;
    private static Statement stmt=null;
    private static ResultSet rs=null;
    static int rid=0;
    static int paperassignid=0;
    public static int login(LoginClientBean bean)
    {
        boolean flag=false;
        String uname=bean.getUserName();
        String pswd=bean.getPassword();
        int id=0;
        try
        {
            conn=ConnectionUtill.getCon();
            stmt=conn.createStatement();
            
            String query="Select username,password,user_type_id,registration_id from registration_detail where username='" + uname+ "' and password='" + pswd + "' ";
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                
                id=Integer.parseInt(rs.getString(3));
                rid=Integer.parseInt(rs.getString(4));
                
                System.out.println("-----"+rs.getString(1));
            }
            
                    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
        return id;
    }
    
    public static int assign(){
        
        int assign_type=0;
        
        try
        {
            conn=ConnectionUtill.getCon();
            stmt=conn.createStatement();
            
            String query="Select paper_assign_id from assign_subject  where registration_id='" + rid+ "'";
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                
                
                paperassignid=Integer.parseInt(rs.getString(1));
                System.out.println("-----assignid"+rs.getString(1));
            }
            
            String query1="Select paper_assign_type from paper_assign where paper_assign_id='" + paperassignid+ "'";
            rs=stmt.executeQuery(query1);
            while(rs.next())
            {
                
                assign_type=Integer.parseInt(rs.getString(1));
                System.out.println("-----assigntype"+rs.getString(1));
            }
            
                    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return assign_type;
        
    }
    public static int rid()
    {
        return rid;
    }
            public static int paperassignid()
            {
                return paperassignid;
            }
    
    public static void main(String[] args) {
       
    }
    
}
