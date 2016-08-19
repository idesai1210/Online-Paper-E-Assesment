/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.DepartmentBean;
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
public class DepartmentDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean departmentInsert(DepartmentBean dbean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String departmentInsert = "insert into department(department_name,college_id) values(?,?)";

            pst = conn.prepareStatement(departmentInsert);

            pst.setString(1, dbean.getDepartmentName());
            pst.setInt(2, dbean.getCollegeId());

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

    public static List departmentDisplay() {

        List departmentList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String departmentDisplay = "select d.department_id,d.department_name,c.college_name,u.university_name from department d,college c,university u where d.college_id=c.college_id and c.university_id=u.university_id";
            pst = conn.prepareStatement(departmentDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                DepartmentBean dbean = new DepartmentBean();
                dbean.setDepartmentId(rs.getInt("department_id"));
                dbean.setDepartmentName(rs.getString("department_name"));
                dbean.setCollegeName(rs.getString("college_name"));
                dbean.setUniversityName(rs.getString("university_name"));

                departmentList.add(dbean);
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
        return departmentList;
    }

    public static boolean departmentDelete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String departmentdelete = "delete from department where department_id=?";

            pst = conn.prepareStatement(departmentdelete);

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
        List departmentList = new ArrayList();
        DepartmentBean dbean = new DepartmentBean();
        try {
            conn = ConnectionUtill.getCon();

            String Departmentselect = "select d.department_id,d.department_name,d.college_id,c.college_name,c.university_id,u.university_name from department d,college c,university u where d.department_id=? and c.university_id=u.university_id and c.college_id=d.college_id";
            pst = conn.prepareStatement(Departmentselect);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                dbean.setDepartmentId(rs.getInt("department_id"));
                dbean.setDepartmentName(rs.getString("department_name"));
                dbean.setCollegeId(rs.getInt("college_id"));
                dbean.setCollegeName(rs.getString("college_name"));
                dbean.setUniversityId(rs.getInt("university_id"));
                dbean.setUniversityName(rs.getString("university_name"));

                departmentList.add(dbean);
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
        return departmentList;
    }

    public static boolean departmentUpdate(DepartmentBean dbean) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String departmentUpdate = "update department set department_name=?,college_id=? where department_id=?";

            pst = conn.prepareStatement(departmentUpdate);

            pst.setString(1, dbean.getDepartmentName());
            pst.setInt(2, dbean.getCollegeId());
            pst.setInt(3, dbean.getDepartmentId());

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
