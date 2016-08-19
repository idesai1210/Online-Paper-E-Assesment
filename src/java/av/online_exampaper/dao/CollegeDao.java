/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.CollegeBean;
import av.online_exampaper.bean.UniversityBean;
import static av.online_exampaper.dao.UniversityDao.conn;
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
 * @author asnthvinayak
 */
public class CollegeDao {
    static Connection conn=null;
    static PreparedStatement pst=null;
    static Statement smt=null;
    static ResultSet rs=null;
    
    public static boolean collgeInsert(CollegeBean cobean){
        
        boolean flag=false;
        try{
            conn=ConnectionUtill.getCon();
            String cinsert="insert into college(college_name,university_id) values(?,?)";
           
            pst=conn.prepareStatement(cinsert);
            
            pst.setString(1, cobean.getCollegeName());
            pst.setInt(2, cobean.getUniversityId());
            
            int i=pst.executeUpdate();
            if(i>0){
                flag=true;
            }
        }catch(SQLException se){
            System.out.println("Insertion Error....");
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pst != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in Connection Close");
            }
        }
        return flag;
    }
    
    
    public static List collegeDisplay(){
        
        List collegeList=new ArrayList();
        try{
            conn=ConnectionUtill.getCon();
            
            String collegeDisplay="select c.college_id,c.college_name,c.university_id,u.university_name from college c,university u where c.university_id=u.university_id";
            pst=conn.prepareStatement(collegeDisplay);
            
            rs=pst.executeQuery();
            
            while(rs.next()){
                CollegeBean cbean=new CollegeBean();
                cbean.setCollegeId(rs.getInt("college_id"));
                cbean.setCollegeName(rs.getString("college_name"));
                cbean.setUniversityName(rs.getString("university_name"));
                cbean.setUniversityId(rs.getInt("university_id"));
                
                collegeList.add(cbean);
            }
        }catch(SQLException se){
            System.out.println("Display Error.....");
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pst != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in Connection Close");
            }
        }
        return collegeList;
    }
    
    public static boolean collegeDelete(int id){
        boolean flag=false;
        try{
            conn=ConnectionUtill.getCon();
           
            String collegeDelete="delete from college where college_id=?";
            
            pst=conn.prepareStatement(collegeDelete);
            
            pst.setInt(1, id);
            
            int i=pst.executeUpdate();
            
            if(i>0){
                flag=true;
            }
        }catch(SQLException se){
            System.out.println("Deleting Error.....");
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pst != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in Connection Close");
            }
        }
        return flag;
    }
    public static List getBypk(int id){
        List collegeList=new ArrayList();
       CollegeBean cbean=new CollegeBean();
        try{
            conn=ConnectionUtill.getCon();
            
            String collegeFetch="select c.college_id,c.college_name,c.university_id,u.university_name from college c,university u where c.university_id=u.university_id and college_id=?";
            pst=conn.prepareStatement(collegeFetch);
            
            pst.setInt(1, id);
          
            rs=pst.executeQuery();
            
            while(rs.next()){
                cbean.setCollegeId(rs.getInt("college_id"));
                cbean.setCollegeName(rs.getString("college_name"));
                cbean.setUniversityName(rs.getString("university_name"));
                cbean.setUniversityId(rs.getInt("university_id"));
                
                collegeList.add(cbean);
            }
        }catch(SQLException se){
            System.out.println("Fetching Error.....");
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pst != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in Connection Close");
            }
        }
        return collegeList;
    }
    public static boolean collegeUpdate(CollegeBean cbean){
        boolean flag=false;
        try{
            conn=ConnectionUtill.getCon();
            
            String collegeUpdate="update college set college_name=?,university_id=? where college_id=?";
            
            pst=conn.prepareStatement(collegeUpdate);
          
            pst.setString(1, cbean.getCollegeName());
            pst.setInt(2, cbean.getUniversityId());
            pst.setInt(3, cbean.getCollegeId());
            
            int i=pst.executeUpdate();
            
            if(i>0){
                flag=true;
            }
        }catch(SQLException se){
            System.out.println("Updation Error......");
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pst != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in Connection Close");
            }
        }
        return flag;
    }
}
