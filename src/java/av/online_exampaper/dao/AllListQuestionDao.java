/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.AllListQuestionBean;
import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.SubjectBean;
import av.online_exampaper.bean.TopicQuestionBean;
import av.online_exampaper.bean.UnitQuestionBean;
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
 * @author HP I5
 */
public class AllListQuestionDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static List dispSubject() {

        List slist = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String degdisp = "select suject_id,subject_name from subject";
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                AllListQuestionBean abean = new AllListQuestionBean();
                abean.setSubjectId(rs.getInt("suject_id"));
                abean.setSubjectName(rs.getString("subject_name"));

                slist.add(abean);
            }
        } catch (SQLException se) {
            System.out.println("Display Error In Subject List");
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
        return slist;
    }

    public static List dispUnit(String id) {

        List unitList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String degdisp = "select u.*,s.subject_name from unit_question u,subject s where s.suject_id=u.subject_id and s.suject_id='" + id + "'";
            System.out.println("query" + degdisp);
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                AllListQuestionBean abean = new AllListQuestionBean();
                abean.setUnitId(rs.getInt("unit_id"));
                abean.setUnitName(rs.getString("unit_name"));
                abean.setSubjectId(rs.getInt("subject_id"));
                abean.setSubjectName(rs.getString("subject_name"));

                unitList.add(abean);
            }

        } catch (SQLException se) {
            System.out.println("Unit Selection Error.....");
        }
        return unitList;

    }

    public static List dispChapter(String id) {

        List chapterList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String degdisp = "select c.*,u.unit_name,s.subject_name from chapter_question c,unit_question u,subject s where u.unit_id=c.unit_id and s.suject_id=u.subject_id and u.unit_id='"+id+"'";
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                AllListQuestionBean abean = new AllListQuestionBean();
                abean.setChapterId(rs.getInt("chapter_id"));
                abean.setChapterName(rs.getString("chapter_name"));
                abean.setUnitId(rs.getInt("unit_id"));
                abean.setUnitName(rs.getString("unit_name"));
                abean.setSubjectName(rs.getString("subject_name"));

                chapterList.add(abean);
            }

        } catch (SQLException se) {
            System.out.println("Chapter Selection Error.....");
        }
        return chapterList;

    }
    public static List dispTopic(String id) {
         
         List topicList=new ArrayList();
         try{
              conn = ConnectionUtill.getCon();

            String degdisp = "select t.*,c.chapter_name,u.unit_name,s.subject_name from topic_question t,chapter_question c,unit_question u,subject s where t.chapter_id=c.chapter_id and c.unit_id=u.unit_id and u.subject_id=s.suject_id and c.chapter_id='"+id+"'";
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                AllListQuestionBean abean = new AllListQuestionBean();
                abean.setTopicId(rs.getInt("topic_id"));
                abean.setTopicName(rs.getString("topic_name"));
                abean.setChapterId(rs.getInt("chapter_id"));
                abean.setChapterName(rs.getString("chapter_name"));
                abean.setUnitName(rs.getString("unit_name"));
                abean.setSubjectName(rs.getString("subject_name"));
                 
                topicList.add(abean);
            }
             
         }catch(SQLException se){
             System.out.println("Topic Selection Error.....");
         }
         return topicList;
     
     }
}
