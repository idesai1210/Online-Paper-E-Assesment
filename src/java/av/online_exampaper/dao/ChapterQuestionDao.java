/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.UnitQuestionBean;
import static av.online_exampaper.dao.UnitQuestionDao.conn;
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
public class ChapterQuestionDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

     public static boolean Insert(ChapterQuestionBean cbean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String sinsert = "insert into chapter_question(chapter_name,unit_id) values(?,?)";

            pst = conn.prepareStatement(sinsert);

            pst.setString(1, cbean.getChapterName());
            pst.setInt(2, cbean.getUnitId());

            int i = pst.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Insertion Error in Chapter....");
        } finally {
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
    public static List disp() {
         
         List chapterList=new ArrayList();
         try{
              conn = ConnectionUtill.getCon();

            String degdisp = "select c.*,u.unit_name,s.subject_name from chapter_question c,unit_question u,subject s where u.unit_id=c.unit_id and s.suject_id=u.subject_id";
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                ChapterQuestionBean cbean = new ChapterQuestionBean();
                cbean.setChapterId(rs.getInt("chapter_id"));
                cbean.setChapterName(rs.getString("chapter_name"));
                cbean.setUnitId(rs.getInt("unit_id"));
                cbean.setUnitName(rs.getString("unit_name"));
                cbean.setSubjectName(rs.getString("subject_name"));
                 
                chapterList.add(cbean);
            }
             
         }catch(SQLException se){
             System.out.println("Chapter Selection Error.....");
         }
         return chapterList;
     
     }
    public static boolean delete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Delsql = "delete from chapter_question where chapter_id=?";

            pst = conn.prepareStatement(Delsql);

            pst.setInt(1, id);

            int i = pst.executeUpdate();

            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Deleting Error in Chapter.....");
        } finally {
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
        List chapterList=new ArrayList();
       ChapterQuestionBean cbean=null;
        try{
            conn=ConnectionUtill.getCon();
            
            String Sql="select c.chapter_id,c.chapter_name,c.unit_id,u.unit_name,u.subject_id,s.subject_name from chapter_question c,unit_question u,subject s where c.unit_id=u.unit_id and u.subject_id=s.suject_id and c.chapter_id=?";
            pst=conn.prepareStatement(Sql);
            
            pst.setInt(1, id);
          
            rs=pst.executeQuery();
            
            while(rs.next()){
                cbean= new ChapterQuestionBean();
                cbean.setChapterId(rs.getInt("chapter_id"));
                cbean.setChapterName(rs.getString("chapter_name"));
                
                cbean.setUnitId(rs.getInt("unit_id"));
                cbean.setUnitName(rs.getString("unit_name"));
                
                cbean.setSubjectId(rs.getInt("subject_id"));
                cbean.setSubjectName(rs.getString("subject_name"));
                
                chapterList.add(cbean);
            }
        }catch(SQLException se){
            System.out.println("Fetching Error In Chapter.....");
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
        return chapterList;
    }
    public static boolean update(ChapterQuestionBean cbean){
        boolean flag=false;
        try{
            conn=ConnectionUtill.getCon();
            
            String Updsql="update chapter_question set chapter_name=?,unit_id=? where chapter_id=?";
            
            pst=conn.prepareStatement(Updsql);
          
            pst.setString(1, cbean.getChapterName());
            pst.setInt(2, cbean.getUnitId());
            pst.setInt(3, cbean.getChapterId());
            
            int i=pst.executeUpdate();
            
            if(i>0){
                flag=true;
            }
        }catch(SQLException se){
            System.out.println("Updation Error In Chapter......");
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
