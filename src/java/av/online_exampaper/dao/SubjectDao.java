/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.SubjectBean;
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
public class SubjectDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean Insert(SubjectBean sbean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String sinsert = "insert into subject(subject_name,degree_id) values(?,?)";

            pst = conn.prepareStatement(sinsert);

            pst.setString(1, sbean.getSubjectname());
            pst.setInt(2, sbean.getDegreeid());

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

        List slist = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String degdisp = "select * from subject";
            pst = conn.prepareStatement(degdisp);

            rs = pst.executeQuery();

            while (rs.next()) {
                SubjectBean sbean = new SubjectBean();
                sbean.setSubjectid(rs.getInt("suject_id"));
                sbean.setSubjectname(rs.getString("subject_name"));
                sbean.setDegreeid(rs.getInt("degree_id"));

                slist.add(sbean);
            }
        } catch (SQLException se) {
            System.out.println("Display Error.....");
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

    public static boolean delete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Delsql = "delete from subject where suject_id=?";

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

    public static List getBypk(int id) {
        List subList = new ArrayList();
        SubjectBean sbean = new SubjectBean();
        try {
            conn = ConnectionUtill.getCon();

            String Sql = "select s.suject_id,s.subject_name,s.degree_id,de.degree_name,de.department_id,d.department_name from degree de,department d,subject s where d.department_id=de.department_id and de.degree_id=s.degree_id and s.suject_id=? ";
            pst = conn.prepareStatement(Sql);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                sbean.setSubjectid(rs.getInt("suject_id"));
                sbean.setSubjectname(rs.getString("subject_name"));
                sbean.setDegreeid(rs.getInt("degree_id"));
                sbean.setDegreename(rs.getString("degree_name"));
                sbean.setDeptid(rs.getInt("department_id"));
                sbean.setDeptname(rs.getString("department_name"));

                subList.add(sbean);
            }
        } catch (SQLException se) {
            System.out.println("Fetching Error.....");
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
        return subList;
    }
    public static boolean update(SubjectBean sBean) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Updsql = "update subject set subject_name=?,degree_id=? where suject_id=?";

            pst = conn.prepareStatement(Updsql);

            pst.setString(1, sBean.getSubjectname());
            pst.setInt(2, sBean.getDegreeid());
            pst.setInt(3, sBean.getSubjectid());

            int i = pst.executeUpdate();

            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Updation Error......");
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
