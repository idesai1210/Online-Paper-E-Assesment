/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.TopicQuestionBean;
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
public class TopicQuestionDao {
    
    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

     public static boolean Insert(TopicQuestionBean tbean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String sinsert = "insert into topic_question(topic_name,chapter_id) values(?,?)";

            pst = conn.prepareStatement(sinsert);

            pst.setString(1, tbean.getTopicName());
            pst.setInt(2, tbean.getChapterId());

            int i = pst.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Insertion Error in Topic....");
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
         
         List topicList=new ArrayList();
         try{
              conn = ConnectionUtill.getCon();

            String degdisp = "select t.*,c.chapter_name,u.unit_name,s.subject_name from topic_question t,chapter_question c,unit_question u,subject s where t.chapter_id=c.chapter_id and c.unit_id=u.unit_id and u.subject_id=s.suject_id";
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                TopicQuestionBean tbean=new TopicQuestionBean();
                tbean.setTopicId(rs.getInt("topic_id"));
                tbean.setTopicName(rs.getString("topic_name"));
                tbean.setChapterId(rs.getInt("chapter_id"));
                tbean.setChapterName(rs.getString("chapter_name"));
                tbean.setUnitName(rs.getString("unit_name"));
                tbean.setSubjectName(rs.getString("subject_name"));
                 
                topicList.add(tbean);
            }
             
         }catch(SQLException se){
             System.out.println("Topic Selection Error.....");
         }
         return topicList;
     
     }
     public static boolean delete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Delsql = "delete from topic_question where topic_id=?";

            pst = conn.prepareStatement(Delsql);

            pst.setInt(1, id);

            int i = pst.executeUpdate();

            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Deleting Error.....");
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
        List topicList=new ArrayList();
       TopicQuestionBean tbean=null;
        try{
            conn=ConnectionUtill.getCon();
            
            String Sql="select t.*,c.chapter_name,c.unit_id,u.unit_name,u.subject_id,s.subject_name from topic_question t,chapter_question c,unit_question u,subject s where t.chapter_id=c.chapter_id and c.unit_id=u.unit_id and u.subject_id=s.suject_id and t.topic_id=?";
            pst=conn.prepareStatement(Sql);
            
            pst.setInt(1, id);
          
            rs=pst.executeQuery();
            
            while(rs.next()){
                tbean= new TopicQuestionBean();
                tbean.setTopicId(rs.getInt("topic_id"));
                tbean.setTopicName(rs.getString("topic_name"));
                tbean.setChapterId(rs.getInt("chapter_id"));
                tbean.setChapterName(rs.getString("chapter_name"));
                
                tbean.setUnitId(rs.getInt("unit_id"));
                tbean.setUnitName(rs.getString("unit_name"));
                
                tbean.setSubjectId(rs.getInt("subject_id"));
                tbean.setSubjectName(rs.getString("subject_name"));
                
                topicList.add(tbean);
            }
        }catch(SQLException se){
            System.out.println("Fetching Error In Topic.....");
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
        return topicList;
    }
    public static boolean update(TopicQuestionBean tbean){
        boolean flag=false;
        try{
            conn=ConnectionUtill.getCon();
            
            String Updsql="update topic_question set topic_name=?,chapter_id=? where topic_id=?";
            
            pst=conn.prepareStatement(Updsql);
          
            pst.setString(1, tbean.getTopicName());
            pst.setInt(2, tbean.getChapterId());
            pst.setInt(3, tbean.getTopicId());
            
            int i=pst.executeUpdate();
            
            if(i>0){
                flag=true;
            }
        }catch(SQLException se){
            System.out.println("Updation Error In Topic......");
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
