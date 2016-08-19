/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.QuestionTypeBean;
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
public class QuestionTypeDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static List questionTypeDisplay() {

        List questionTypeList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String questionTypeDisp = "select * from question_type";
            pst = conn.prepareStatement(questionTypeDisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                QuestionTypeBean queTypeBean=new QuestionTypeBean();
                queTypeBean.setQuestionTypeId(rs.getInt("question_type_id"));
                queTypeBean.setQuestionTypeName(rs.getString("question_type_name"));
                
                questionTypeList.add(queTypeBean);
            }

        } catch (SQLException se) {
            System.out.println("Question Type Selection Error.....");
        }
        return questionTypeList;

    }
}
