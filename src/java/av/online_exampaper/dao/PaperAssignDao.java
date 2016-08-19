/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.PaperAssignBean;
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
 * @author HP I5
 */
public class PaperAssignDao {
    
    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static List disp() {

        List assignExamlist = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String udisp = "select * from paper_assign";
            pst = conn.prepareStatement(udisp);

            rs = pst.executeQuery();
            while (rs.next()) {
                PaperAssignBean pabean=new PaperAssignBean();
                pabean.setPaperAssignId(rs.getInt("paper_assign_id"));
                pabean.setPaperAssignType(rs.getString("paper_assign_type"));
                
                assignExamlist.add(pabean);
            }
        } catch (SQLException se) {
            System.out.println("Display Error In Assign Exam.....");
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
        return assignExamlist;
    }
    
}
