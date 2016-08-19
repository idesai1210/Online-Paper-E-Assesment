/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.DegreeBean;
import av.online_exampaper.bean.DepartmentBean;
import static av.online_exampaper.dao.DepartmentDao.conn;
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
public class DegreeDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean degreeInsert(DegreeBean degbean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String degreeInsert = "insert into degree(degree_name,department_id) values(?,?)";

            pst = conn.prepareStatement(degreeInsert);

            pst.setString(1, degbean.getDegreeName());
            pst.setInt(2, degbean.getDepartmentId());

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

    public static List degreeDisplay() {

        List degreeList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String degreeDisplay = "select de.degree_id,de.degree_name,d.department_name,c.college_name,u.university_name from degree de,department d,college c,university u where de.department_id=d.department_id and d.college_id=c.college_id and c.university_id=u.university_id";
            pst = conn.prepareStatement(degreeDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                DegreeBean degbean = new DegreeBean();
                degbean.setDegreeId(rs.getInt("degree_id"));
                degbean.setDegreeName(rs.getString("degree_name"));
                degbean.setDepartmentName(rs.getString("department_name"));
                degbean.setCollegeName(rs.getString("college_name"));
                degbean.setUniversityName(rs.getString("university_name"));

                degreeList.add(degbean);
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
        return degreeList;
    }

    public static boolean degreeDelete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String DegreeDelete = "delete from degree where degree_id=?";

            pst = conn.prepareStatement(DegreeDelete);

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
        List degreeList = new ArrayList();
        DegreeBean degbean = new DegreeBean();
        try {
            conn = ConnectionUtill.getCon();

            String degreeSql = "select de.degree_id,de.degree_name,de.department_id,d.department_name,d.college_id,c.college_name,c.university_id,u.university_name from degree de,department d,college c,university u where c.university_id=u.university_id and c.college_id=d.college_id and de.department_id=d.department_id and de.degree_id=? ";
            pst = conn.prepareStatement(degreeSql);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                degbean.setDegreeId(rs.getInt("degree_id"));
                degbean.setDegreeName(rs.getString("degree_name"));
                degbean.setDepartmentId(rs.getInt("department_id"));
                degbean.setDepartmentName(rs.getString("department_name"));
                degbean.setCollegeId(rs.getInt("college_id"));
                degbean.setCollegeName(rs.getString("college_name"));
                degbean.setUniversityId(rs.getInt("university_id"));
                degbean.setUniversityName(rs.getString("university_name"));

                degreeList.add(degbean);
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
        return degreeList;
    }

    public static boolean update(DegreeBean degbean) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Updsql = "update degree set degree_name=?,department_id=? where degree_id=?";

            pst = conn.prepareStatement(Updsql);

            pst.setString(1, degbean.getDegreeName());
            pst.setInt(2, degbean.getDepartmentId());
            pst.setInt(3, degbean.getDegreeId());

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
