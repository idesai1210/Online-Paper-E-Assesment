/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.QuestionBean;
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
 * @author HP I5
 */
public class QuestionDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean questionInsert(QuestionBean qbean) {

        boolean flag = false,flag1=false;
        try {
            conn = ConnectionUtill.getCon();
            String sinsert = "insert into all_question(all_que_desc,topic_id,default_marks,question_type_id) values(?,?,?,?)";

            pst = conn.prepareStatement(sinsert);

            pst.setString(1, qbean.getQuestion());
            pst.setInt(2, qbean.getTopicId());
            pst.setString(3, qbean.getDefaultMark());
            pst.setInt(4, qbean.getQuestionTypeId());

            int i = pst.executeUpdate();
            if (i > 0) {
                flag = true;
            }
            if (flag == true) {
                String id = null;
                String selectQueID = "select all_que_id from all_question where all_que_desc=? and question_type_id=1";
                pst = conn.prepareStatement(selectQueID);

                pst.setString(1, qbean.getQuestion());
                rs = pst.executeQuery();

                while (rs.next()) {
                    id = rs.getString("all_que_id");
                    if (id != null) {
                        flag = false;
                    }
                }
                String insertMcqOption1 = "insert into mcq_option(all_que_id,option_value) values('" + id + "','" + qbean.getOption1() + "')";
                smt = conn.createStatement();
                int i1 = smt.executeUpdate(insertMcqOption1);

                String insertMcqOption2 = "insert into mcq_option(all_que_id,option_value) values('" + id + "','" + qbean.getOption2() + "')";
                smt = conn.createStatement();
                int i2 = smt.executeUpdate(insertMcqOption2);

                String insertMcqOption3 = "insert into mcq_option(all_que_id,option_value) values('" + id + "','" + qbean.getOption3() + "')";
                smt = conn.createStatement();
                int i3 = smt.executeUpdate(insertMcqOption3);

                String insertMcqOption4 = "insert into mcq_option(all_que_id,option_value) values('" + id + "','" + qbean.getOption4() + "')";
                smt = conn.createStatement();
                int i4 = smt.executeUpdate(insertMcqOption4);
                if (i1 > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
                    flag = true;
                    flag1 = true;
                }
            }

        } catch (SQLException se) {
            System.out.println("Question Insertion Error....");
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

        public static List questionDisplay() {

        List questionList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String questionDisplay = "select all_question.*,t.topic_name,m.option_value,c.chapter_name,u.unit_name,s.subject_name,q.question_type_name from all_question left join mcq_option m on all_question.all_que_id = m.all_que_id left join topic_question t on all_question.topic_id = t.topic_id left join chapter_question c on c.chapter_id = t.chapter_id left join unit_question u on u.unit_id = c.unit_id left join subject s on s.suject_id=u.subject_id left join question_type q on all_question.question_type_id=q.question_type_id";
            pst = conn.prepareStatement(questionDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                QuestionBean qbean = new QuestionBean();
                qbean.setQuestionId(rs.getInt("all_que_id"));
                qbean.setQuestion(rs.getString("all_que_desc"));
                qbean.setDefaultMark(rs.getString("default_marks"));
                qbean.setTopicId(rs.getInt("topic_id"));
                qbean.setTopicName(rs.getString("topic_name"));

                qbean.setChapterName(rs.getString("chapter_name"));
                qbean.setUnitName(rs.getString("unit_name"));
                qbean.setSubjectName(rs.getString("subject_name"));

                qbean.setQuestionTypeId(rs.getInt("question_type_id"));
                qbean.setQuestionTypeName(rs.getString("question_type_name"));
                qbean.setOption1(rs.getString("option_value"));

                questionList.add(qbean);
            }

        } catch (SQLException se) {
            System.out.println("Question Selection Error.....");
        }
        return questionList;

    }

    public static boolean questionDelete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Delsql = "delete from all_question where all_que_id=?";

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
}
