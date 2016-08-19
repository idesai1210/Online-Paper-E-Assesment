/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asnthvinayak
 */
public class ConnectionUtill {
    
    public static String dapth="com.mysql.jdbc.Driver";
    public static String path="jdbc:mysql://localhost:3306/Online_ExamPaper";
    public static String unm="root";
    public static String pwd="ishan";

    public static Connection getCon()
    {
        
        Connection conn=null;
        try{
            Class.forName(dapth);
            conn=DriverManager.getConnection(path, unm, pwd);
            if(conn!=null){
                System.out.println("Database Connected.....");
            }
            else{
                System.out.println("Not Connected.....");
            }
        }catch(SQLException se){
            System.out.println("Sqlexception Error.....");
        }catch(ClassNotFoundException co){
            System.out.println("Class Not Found....");
        }
        return conn;
    }
    public static void main(String[] args) {
        getCon();
    }
    
}
