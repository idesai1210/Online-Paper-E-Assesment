/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.UserDataBean;
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
public class UserDataDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static List disp() {

        List ulist = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String udisp = "select r.registration_id,r.firstname,r.middlename,r.lastname,r.degree_id,r.experience,c.college_name,d.degree_name,de.department_name from registration_detail r,college c,degree d,department de where r.degree_id=d.degree_id and d.department_id=de.department_id and de.college_id=c.college_id";
            pst = conn.prepareStatement(udisp);

            rs = pst.executeQuery();
            while (rs.next()) {
                UserDataBean ubean = new UserDataBean();
                ubean.setUser_id(rs.getInt("registration_id"));
                ubean.setFname(rs.getString("firstname"));
                ubean.setMname(rs.getString("middlename"));
                ubean.setLname(rs.getString("lastname"));
                
                ubean.setDepartmentName(rs.getString("department_name"));
                ubean.setCollegeName(rs.getString("college_name"));
                ubean.setDegreeId(rs.getInt("degree_id"));
                ubean.setDegreeName(rs.getString("degree_name"));
                
                ubean.setExperience(rs.getString("experience"));
                
                ulist.add(ubean);
            }
        } catch (SQLException se) {
            System.out.println("Display Error In User Data Assign Exam.....");
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
        return ulist;
    }

}
