/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.AdminAjaxBean;
import av.online_exampaper.bean.CityBean;
import av.online_exampaper.bean.CollegeBean;
import av.online_exampaper.bean.DegreeBean;
import av.online_exampaper.bean.DepartmentBean;
import av.online_exampaper.bean.UniversityBean;
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
public class AdminAjaxDao {

    public static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static List universityDisplay() {

        List universityList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String universityDisplay = "select * from university";
            pst = conn.prepareStatement(universityDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                AdminAjaxBean abean = new AdminAjaxBean();
                abean.setUniversityId(rs.getInt("university_id"));
                abean.setUniversityName(rs.getString("university_name"));
                universityList.add(abean);
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

        return universityList;
    }

    public static List collegeDisplay(String id) {

        List collegeList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String collegeDisplay = "select c.college_id,c.college_name,c.university_id,u.university_name from college c,university u where c.university_id=u.university_id and u.university_id='" + id + "'";
            pst = conn.prepareStatement(collegeDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                AdminAjaxBean abean = new AdminAjaxBean();
                abean.setCollegeId(rs.getInt("college_id"));
                abean.setCollegeName(rs.getString("college_name"));
                abean.setUniversityName(rs.getString("university_name"));
                abean.setUniversityId(rs.getInt("university_id"));

                collegeList.add(abean);
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
        return collegeList;
    }

    public static List departmentDisplay(String id) {

        List departmentList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String departmentDisplay = "select d.department_id,d.department_name,c.college_name,u.university_name from department d,college c,university u where d.college_id=c.college_id and c.university_id=u.university_id and c.college_id='" + id + "'";
            pst = conn.prepareStatement(departmentDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                AdminAjaxBean abean = new AdminAjaxBean();
                abean.setDepartmentId(rs.getInt("department_id"));
                abean.setDepartmentName(rs.getString("department_name"));
                abean.setCollegeName(rs.getString("college_name"));
                abean.setUniversityName(rs.getString("university_name"));

                departmentList.add(abean);
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

    public static List degreeDisplay(String id) {

        List degreeList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String degreeDisplay = "select de.degree_id,de.degree_name,d.department_name from degree de,department d where de.department_id=d.department_id and d.department_id='" + id + "'";
            pst = conn.prepareStatement(degreeDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                AdminAjaxBean abean = new AdminAjaxBean();
                abean.setDegreeId(rs.getInt("degree_id"));
                abean.setDegreeName(rs.getString("degree_name"));
                abean.setDepartmentName(rs.getString("department_name"));

                degreeList.add(abean);
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

    public static List countryShow() {
        List countryList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();
            String Select = "select * from country";
              pst = conn.prepareStatement(Select);

            rs = pst.executeQuery();
            while (rs.next()) {
                AdminAjaxBean abean = new AdminAjaxBean();
                abean.setCountryId(rs.getInt(1));
                abean.setCountryName(rs.getString(2));

                countryList.add(abean);

            }
        } catch (SQLException e) {
            System.out.println("not show data In City");
        }
        return countryList;

    }

    public static List stateShow(String id) {
        List stateList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();
            String Select = "select s.*,c.country_name from state s,country c where s.country_id=c.country_id and c.country_id=" + id + "";
           pst = conn.prepareStatement(Select);

            rs = pst.executeQuery();
            while (rs.next()) {
                AdminAjaxBean abean = new AdminAjaxBean();
                abean.setStateId(rs.getInt(1));
                abean.setStateName(rs.getString(2));
                abean.setCountryId(rs.getInt(3));
                abean.setCountryName(rs.getString(4));

                stateList.add(abean);
                System.out.println("list" + stateList.size());

            }
        } catch (SQLException e) {
            System.out.println("not show data In City");
        }
        return stateList;

    }
}
