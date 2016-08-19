/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

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
 * @author asnthvinayak
 */
public class UniversityDao {

    public static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean universityInsert(UniversityBean ubean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String universityInsert = "insert into university(university_name) values(?)";

            pst = conn.prepareStatement(universityInsert);

            pst.setString(1, ubean.getUniversityName());

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

    public static List universityDisplay() {

        List universityList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String universityDisplay = "select * from university";
            pst = conn.prepareStatement(universityDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
               UniversityBean ubean = new UniversityBean();
                ubean.setUniversityId(rs.getInt("university_id"));
                ubean.setUniversityName(rs.getString("university_name"));
                universityList.add(ubean);
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

    public static boolean universityDelete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            // smt=conn.createStatement();

            String universityDelete = "delete from university where university_id=?";

            pst = conn.prepareStatement(universityDelete);

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
        List universityList = new ArrayList();
        UniversityBean ubean = new UniversityBean();
        try {
            conn = ConnectionUtill.getCon();

            String universityFetch = "select * from university where university_id=?";
            pst = conn.prepareStatement(universityFetch);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                ubean.setUniversityId(rs.getInt("university_id"));
                ubean.setUniversityName(rs.getString("university_name"));

                universityList.add(ubean);
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
        return universityList;
    }

    public static boolean universityUpdate(UniversityBean ubean) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String universityUpdate = "update university set university_name=? where university_id=?";

            pst = conn.prepareStatement(universityUpdate);
            // pst.setInt(1, ubean.getUniversityid());
            pst.setString(1, ubean.getUniversityName());
            pst.setInt(2, ubean.getHid());

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
