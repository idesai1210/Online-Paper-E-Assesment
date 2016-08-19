/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.EvaluationLoadBean;
import av.online_exampaper.bean.MarksBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KLINGON
 */
public class MarksDao {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs=null,rs1=null;
    
    public static List<MarksBean> totalquesid(String id)
    {
        List<MarksBean> quesidlist = new ArrayList<MarksBean>();
         try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String qList = "select exam_que_id,master_que,sub_que,que  from exam_question where paper_id='"+ id +"'";
            System.out.println("-----heremarksDao----");
            ResultSet rs = stmt.executeQuery(qList);
            
            while (rs.next()) {
                MarksBean bean = new MarksBean();
                bean.setExamquesid(rs.getString(1));
                bean.setMq(rs.getString(2));
                bean.setSq(rs.getString(3));
                bean.setQue(rs.getString(4));
                
                
                quesidlist.add(bean);
            }
            System.out.println("---------------"+quesidlist);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return quesidlist;
    }
    
    public static int insertMarks(List<MarksBean> quesmarkslist,String stud_id)
    {
        int id=0;
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String quesid[]=new String[100];
            String marks[]=new String[100];
            MarksBean bean=new MarksBean();
            for(int i=0;i<quesmarkslist.size();i++)
            {
                    bean=(MarksBean)quesmarkslist.get(i);
                    quesid[i]=bean.getExamquesid().toString();
                    marks[i]=bean.getMarks().toString();
             
            }
            for(int i=0;i<quesmarkslist.size();i++)
            {
                String imarks = "insert into student_marks values(null,'"+ stud_id +"','"+ quesid[i] +"','"+ marks[i] +"')";
               
                id = stmt.executeUpdate(imarks);
            }
            
            System.out.println("---------------inserted marks"+id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
}
