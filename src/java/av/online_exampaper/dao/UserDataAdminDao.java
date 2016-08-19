/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.DegreeBean;
import av.online_exampaper.bean.UserDataAdminBean;
import static av.online_exampaper.dao.DegreeDao.conn;
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
public class UserDataAdminDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static List disp() {

        List ulist = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String udisp = "select r.registration_id,r.firstname,r.middlename,r.lastname,r.address,r.city_id,c.city_name,c.state_id,s.state_name,s.country_id,cn.country_name from registration_detail r,city c,state s,country cn where r.city_id=c.city_id and c.state_id=s.state_id and s.country_id=cn.country_id";
            pst = conn.prepareStatement(udisp);

            rs = pst.executeQuery();
            while (rs.next()) {
                UserDataAdminBean ubean = new UserDataAdminBean();
                ubean.setUser_id(rs.getInt("registration_id"));
                ubean.setFname(rs.getString("firstname"));
                ubean.setMname(rs.getString("middlename"));
                ubean.setLname(rs.getString("lastname"));
                ubean.setAddress(rs.getString("address"));
                ubean.setCityid(rs.getInt("city_id"));
                ubean.setCityname(rs.getString("city_name"));
                ubean.setSid(rs.getInt("state_id"));
                ubean.setSname(rs.getString("state_name"));
                ubean.setCid(rs.getInt("country_id"));
                ubean.setCname(rs.getString("country_name"));
                
                ulist.add(ubean);
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
        return ulist;
    }

}
