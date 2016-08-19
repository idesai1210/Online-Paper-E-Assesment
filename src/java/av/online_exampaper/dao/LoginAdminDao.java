/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.LoginAdminBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author KLINGON
 */
public class LoginAdminDao {
    
    private static Connection conn=null;
    private static Statement stmt=null;
    private static ResultSet rs=null;
    
    public static boolean login(LoginAdminBean bean)
    {
        boolean flag=false;
        String uname=bean.getUserName();
        String pswd=bean.getPassword();
        try
        {
            conn=ConnectionUtill.getCon();
            stmt=conn.createStatement();
            String query="Select * from login where UserName='" + uname+ "' and Password='" + pswd + "' ";
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                flag=true;
            }
           
                    
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
    
    
}
