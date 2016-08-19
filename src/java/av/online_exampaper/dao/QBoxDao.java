/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;


import av.online_exampaper.bean.QBoxBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arpit
 */
public class QBoxDao {

    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;

//method for insert

    public static List insertx(String id) {
        List list = new ArrayList();
            
        try {
                
                conn=ConnectionUtill.getCon();
                stmt=conn.createStatement();
                String query = "select * from exam_question where paper_id='"+ id +"'";
                ResultSet rs = stmt.executeQuery(query);              
             
                QBoxBean bean;
                
                while(rs.next())
                {
                    bean = new QBoxBean();
                    bean.setEqi(rs.getString(1));
                    bean.setPi(rs.getString(2));
                    bean.setMq(rs.getString(3));
                    bean.setSq(rs.getString(4));
                    bean.setQue(rs.getString(5));
                    bean.setAqi(rs.getString(6));
                    bean.setQm(rs.getString(7));
                    list.add(bean); 
                }
              
         
           } 
        catch (Exception e)
        {
            System.out.println("Error"+e);
        }

        return list;
        
    }
 public static List list1=null;
     public static List inserty(String id) {
         list1 = new ArrayList();
            
        try {
                
                conn=ConnectionUtill.getCon();
                stmt=conn.createStatement();
                String query = "select distinct master_que from exam_question where paper_id='" + id + "'";
                ResultSet rs = stmt.executeQuery(query);              
             
                QBoxBean bean1=new QBoxBean();
                
                while(rs.next())
                {
                    bean1 = new QBoxBean();
                    bean1.setMq(rs.getString(1));
                    list1.add(bean1); 
                }
                System.out.println("qwerty"+list1);
                
         
           } 
        catch (Exception e)
        {
            System.out.println("Error"+e);
        }

        return list1;
        
    }
     
     public static List insertz() {
        List list2 = new ArrayList();
        QBoxBean bean1=new QBoxBean();
        String s[]=new String[1000];
        try {
                
                for(int i=0;i<list1.size();i++)
                {
                    bean1=(QBoxBean)list1.get(i);
                    s[i]=bean1.getMq();
                }
                conn=ConnectionUtill.getCon();
                stmt=conn.createStatement();
                for(int i=0;i<s.length;i++)
                {
                String query = "select distinct master_que,sub_que from exam_question where master_que='"+ s[i] +"'";
                ResultSet rs = stmt.executeQuery(query);              
             
                
                
                while(rs.next())
                {
                    bean1 = new QBoxBean();
                    bean1.setMq(rs.getString(1));
                    bean1.setSq(rs.getString(2));
                    list2.add(bean1); 
                }
                
                }
                System.out.println("z:"+list2);
                for(int i=0;i<list2.size();i++)
                {
                    bean1=(QBoxBean)list2.get(i);
                    System.out.println("zzzz:"+bean1.getMq());
                    System.out.println("zzzz2:"+bean1.getSq());
                }
         
           } 
        catch (Exception e)
        {
            System.out.println("Error"+e);
        }

        return list2;
     }     
//     public static void main(String[] args) {
//        QBoxDao.inserty();
//        QBoxDao.insertx();
//        QBoxDao.insertz();
//    }

 }




   
   

