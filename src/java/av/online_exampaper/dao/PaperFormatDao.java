/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.PaperFormatBean;
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
public class PaperFormatDao {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;
    static int rid = 0;
    static int paperassignid = 0;

    public static List dispSubject(int assignId, int rid) {
        List subjectList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();

            String query = "select s.subject_name,s.suject_id from subject s,assign_subject a where a.suject_id=s.suject_id and a.registration_id='" + rid + "' and paper_assign_id='" + assignId + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                PaperFormatBean pbean = new PaperFormatBean();
                pbean.setSubject(rs.getString("subject_name"));
                pbean.setSubId(rs.getInt("suject_id"));

                subjectList.add(pbean);
            }
        } catch (SQLException se) {
            System.out.println("Subject Selection Error.....");
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
        return subjectList;

    }

    public static boolean Insert(PaperFormatBean pbean) {
        boolean flag = false;
        List assignIdList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();

            String query = "select assign_id from assign_subject where suject_id='" + pbean.getSubId() + "' and registration_id='" + pbean.getRid() + "' and paper_assign_id='" + pbean.getPaperassignId() + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {

                int aid = rs.getInt("assign_id");

                if (aid > 0) {
                    String sinsert = "insert into paper_master(exam_type_id,assign_id,exam_date,time_duration,note,paper_generated_date,paper_name) values(?,?,?,?,?,?,?)";

                    pst = conn.prepareStatement(sinsert);

                    pst.setInt(1, pbean.getExamType());
                    pst.setInt(2, aid);
                    pst.setString(3, pbean.getExamDate());
                    pst.setString(4, pbean.getTimeDuration());
                    pst.setString(5, pbean.getNotes());
                    pst.setString(6, pbean.getPaperGDate());
                    pst.setString(7, pbean.getPaperName());

                    int i = pst.executeUpdate();
                    if (i > 0) {
                        flag = true;
                    }
                }

            }
        } catch (SQLException se) {
            System.out.println("Paper Data Insertion Error.....");
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

    public static List dispPaper() {
        List allPaperList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();

            String query = "select p.paper_id,firstname,middlename,lastname,p.paper_name,s.subject_name,d.degree_name,c.college_name from registration_detail r,assign_subject a,subject s,degree d,department de,college c,paper_master p where a.registration_id=r.registration_id and a.suject_id=s.suject_id and p.assign_id=a.assign_id and s.degree_id=d.degree_id and d.department_id=de.department_id and de.college_id=c.college_id";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                PaperFormatBean pbean = new PaperFormatBean();
                pbean.setPaperId(rs.getInt(1));
                pbean.setFirstName(rs.getString(2));
                pbean.setMiddleName(rs.getString(3));
                pbean.setLastName(rs.getString(4));
                pbean.setPaperName(rs.getString(5));
                pbean.setSubject(rs.getString(6));
                pbean.setDegreeName(rs.getString(7));
                pbean.setCollegeName(rs.getString(8));

                allPaperList.add(pbean);
            }

        } catch (SQLException se) {
            System.out.println("Ppaer List Selection Error.......");
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
        return allPaperList;
    }

    public static boolean paperDelete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String paperDelete = "delete from paper_master where paper_id=?";

            pst = conn.prepareStatement(paperDelete);

            pst.setInt(1, id);

            int i = pst.executeUpdate();

            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Paper Deleting Error.....");
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
