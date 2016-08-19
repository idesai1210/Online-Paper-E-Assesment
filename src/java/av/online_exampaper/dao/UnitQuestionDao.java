/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.SubjectBean;
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
 * @author asnthvinayak
 */
public class UnitQuestionDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean Insert(UnitQuestionBean ubean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String sinsert = "insert into unit_question(unit_name,subject_id) values(?,?)";

            pst = conn.prepareStatement(sinsert);

            pst.setString(1, ubean.getUnitQuestionName());
            pst.setInt(2, ubean.getSubjectid());

            int i = pst.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Insertion Error....");
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

        List unitList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String degdisp = "select u.*,s.subject_name from unit_question u,subject s where s.suject_id=u.subject_id";
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                UnitQuestionBean ubean = new UnitQuestionBean();
                ubean.setUnitQuestionId(rs.getInt("unit_id"));
                ubean.setUnitQuestionName(rs.getString("unit_name"));
                ubean.setSubjectid(rs.getInt("subject_id"));
                ubean.setSubjectName(rs.getString("subject_name"));

                unitList.add(ubean);
            }

        } catch (SQLException se) {
            System.out.println("Unit Selection Error.....");
        }
        return unitList;

    }
    public static boolean delete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Delsql = "delete from unit_question where unit_id=?";

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
        List unitList=new ArrayList();
       UnitQuestionBean ubean=new UnitQuestionBean();
        try{
            conn=ConnectionUtill.getCon();
            
            String Sql="select u.unit_id,u.unit_name,u.subject_id,s.subject_name from unit_question u,subject s where u.subject_id=s.suject_id and u.unit_id=?";
            pst=conn.prepareStatement(Sql);
            
            pst.setInt(1, id);
          
            rs=pst.executeQuery();
            
            while(rs.next()){
                ubean.setUnitQuestionId(rs.getInt("unit_id"));
                ubean.setUnitQuestionName(rs.getString("unit_name"));
                ubean.setSubjectName(rs.getString("subject_name"));
                ubean.setSubjectid(rs.getInt("subject_id"));
                
                unitList.add(ubean);
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
        return unitList;
    }
    public static boolean update(UnitQuestionBean ubean){
        boolean flag=false;
        try{
            conn=ConnectionUtill.getCon();
            
            String Updsql="update unit_question set unit_name=?,subject_id=? where unit_id=?";
            
            pst=conn.prepareStatement(Updsql);
          
            pst.setString(1, ubean.getUnitQuestionName());
            pst.setInt(2, ubean.getSubjectid());
            pst.setInt(3, ubean.getUnitQuestionId());
            
            int i=pst.executeUpdate();
            
            if(i>0){
                flag=true;
            }
        }catch(SQLException se){
            System.out.println("Updation Error In Unit......");
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
