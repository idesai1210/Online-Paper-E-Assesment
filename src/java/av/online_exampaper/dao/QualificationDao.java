/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.QualificationBean;
import av.online_exampaper.bean.UniversityBean;
import static av.online_exampaper.dao.UniversityDao.conn;
import static av.online_exampaper.dao.UniversityDao.pst;
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
public class QualificationDao {
 
    
    public static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean qualiInsert(QualificationBean qbean) {

        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            String qInsert = "insert into qualification(qualification_name) values(?)";

            pst = conn.prepareStatement(qInsert);

            pst.setString(1, qbean.getQualificationName());

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
    public static List QualiDisplay() {

        List qlist = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String qDisplay = "select * from qualification";
            pst = conn.prepareStatement(qDisplay);

            rs = pst.executeQuery();

            while (rs.next()) {
                
                QualificationBean qbean = new QualificationBean();
                qbean.setQualificationId(rs.getInt(1));
                qbean.setQualificationName(rs.getString(2));

                qlist.add(qbean);
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

        return qlist;
    }
    public static boolean QualiDelete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();
            // smt=conn.createStatement();

            String QualiDelete = "delete from qualification where qualification_id=?";

            pst = conn.prepareStatement(QualiDelete);

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
        List qualiList = new ArrayList();
        QualificationBean qbean = new QualificationBean();
        try {
            conn = ConnectionUtill.getCon();

            String QualiSelect = "select * from qualification where qualification_id=?";
            pst = conn.prepareStatement(QualiSelect);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                qbean.setQualificationId(rs.getInt("qualification_id"));
                qbean.setQualificationName(rs.getString("qualification_name"));

                qualiList.add(qbean);
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
        return qualiList;
    }

    public static boolean QualiUpdate(QualificationBean qbean) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String QualiUpdate = " update qualification set qualification_name=? where qualification_id=?";
            pst = conn.prepareStatement(QualiUpdate);
           // pst.setInt(1, qbean.getUniversityid());
           
            pst.setString(1, qbean.getQualificationName());
            pst.setInt(2, qbean.getQualificationId());
 
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
