/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import av.online_exampaper.bean.AssignExamBean;
import av.online_exampaper.bean.ChapterQuestionBean;
import av.online_exampaper.bean.CityBean;
import av.online_exampaper.bean.UserDataBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author HP I5
 */
public class AssignExamDao {

    static Connection conn = null;
    static PreparedStatement pst = null;
    static Statement smt = null;
    static ResultSet rs = null;

    public static boolean Insert(AssignExamBean abean, List list) {

        boolean flag = false;
        String approval = "true";
        try {
            conn = ConnectionUtill.getCon();
            int i = 0;
            for (Iterator sID = list.iterator(); sID.hasNext();) {
                Object staffID = sID.next();

                int asid = abean.getPaperAssignId();
                if (asid == 1) {
                    String sinsert = "insert into assign_subject(registration_id,suject_id,paper_assign_id,approval) values(?,?,?,?)";
                    pst = conn.prepareStatement(sinsert);

                    pst.setObject(1, staffID);
                    pst.setInt(2, abean.getSujectId());
                    pst.setInt(3, abean.getPaperAssignId());
                    pst.setString(4, approval);
                    i = pst.executeUpdate();
                } else if (asid == 2) {
                    String sinsert = "insert into assign_subject(registration_id,suject_id,paper_assign_id,approval,assign_block) values(?,?,?,?,?)";
                    pst = conn.prepareStatement(sinsert);

                    pst.setObject(1, staffID);
                    pst.setInt(2, abean.getSujectId());
                    pst.setInt(3, abean.getPaperAssignId());
                    pst.setString(4, approval);
                    pst.setString(5, abean.getAssignBlock());
                    i = pst.executeUpdate();
                }
            }
            if (i > 0) {
                flag = true;
            }

        } catch (SQLException se) {
            System.out.println("Insertion Error in Assign Exam....");
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

    public static List disp(int assignId, int subjectId) {
        List assignExamList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();

            String examSelect = "select a.assign_id,r.firstname,r.middlename,r.lastname,s.subject_name,p.paper_assign_type from registration_detail r,assign_subject a,subject s,paper_assign p where r.registration_id=a.registration_id and s.suject_id=a.suject_id and p.paper_assign_id=a.paper_assign_id and a.suject_id=? and a.paper_assign_id=?";
            AssignExamBean abean = null;

            pst = conn.prepareStatement(examSelect);
            pst.setInt(1, subjectId);
            pst.setInt(2, assignId);

            rs = pst.executeQuery();
            while (rs.next()) {
                abean = new AssignExamBean();
                abean.setAssignId(rs.getInt(1));
                abean.setFirstName(rs.getString(2));
                abean.setMiddleName(rs.getString(3));
                abean.setLastName(rs.getString(4));
                abean.setSubjectName(rs.getString(5));
                abean.setPaperAssignType(rs.getString(6));
                
                assignExamList.add(abean);


            }
        } catch (SQLException e) {
            System.out.println("Selection Error in Assign Exam List");
        }
        return assignExamList;

    }
    public static boolean delete(int id) {
        boolean flag = false;
        try {
            conn = ConnectionUtill.getCon();

            String Delsql = "delete from assign_subject where assign_id=?";

            pst = conn.prepareStatement(Delsql);

            pst.setInt(1, id);

            int i = pst.executeUpdate();

            if (i > 0) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.println("Deleting Error in Assign Exam.....");
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
    public static List dispUserList() {

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
