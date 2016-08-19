/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.EvaluationLoadBean;
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
 * @author KLINGON
 */
public class EvaluationLoadDao {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs=null,rs1=null;
    private static PreparedStatement ps=null;
    
    public List<EvaluationLoadBean> uniList() {
         List<EvaluationLoadBean> uniList = new ArrayList<EvaluationLoadBean>();
         
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String uList = "select * from university";
            System.out.println("-----here******");
            ResultSet rs = stmt.executeQuery(uList);
            
            while (rs.next()) {
                EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setuId((rs.getString(1)));
                bean.setuName((rs.getString(2)));
                
                uniList.add(bean);
            }
            System.out.println("---------------"+uniList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return uniList;
    }
    
    public List<EvaluationLoadBean> collegeList() {
         List<EvaluationLoadBean> collList = new ArrayList<EvaluationLoadBean>();
         
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String cList = "select * from college";
            System.out.println("-----here******");
            ResultSet rs = stmt.executeQuery(cList);
            
            while (rs.next()) {
                EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setCollId((rs.getString(1)));
                bean.setCollName((rs.getString(2)));
                
                collList.add(bean);
            }
            System.out.println("---------------"+collList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return collList;
    }
    
    
    public List<EvaluationLoadBean> collegeList(int uni_id) {
         List<EvaluationLoadBean> collList = new ArrayList<EvaluationLoadBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String clList = "select c.*,u.university_name  from college c, university u where u.university_id = c.university_id and c.university_id='"+ uni_id +"' ";
           // String cityList = "select c.*, s.sname from city c ,state s where  s.sid = c.sid and c.sid = " + state_id + " ";
            ResultSet rs = stmt.executeQuery(clList);
            
            while (rs.next()) {
                EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setCollId((rs.getString(1)));
                bean.setCollName((rs.getString(2)));
                bean.setuId(rs.getString(3));
                bean.setuName(rs.getString(4));
                
                collList.add(bean);
            }
            System.out.println("---------------"+collList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return collList;
    }
    
    public List<EvaluationLoadBean> dptList(int coll_id) {
         List<EvaluationLoadBean> dptList = new ArrayList<EvaluationLoadBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            //String deptList = "select * from department";
            String deptList = "select d.*,c.college_name  from department d, college c where c.college_id = d.college_id and d.college_id='"+ coll_id +"' ";

            ResultSet rs = stmt.executeQuery(deptList);
            
            while (rs.next()) {
                EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setDptId((rs.getString(1)));
                bean.setDptName((rs.getString(2)));
                
                dptList.add(bean);
            }
            System.out.println("---------------"+dptList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return dptList;
    }
     
     public List<EvaluationLoadBean> degreeList(int dptId) {
         List<EvaluationLoadBean> degList = new ArrayList<EvaluationLoadBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
//            String dList = "select * from degree";
            String dList = "select de.*,dpt.department_name  from degree de, department dpt where de.department_id = dpt.department_id and dpt.department_id='"+ dptId +"' ";

            ResultSet rs = stmt.executeQuery(dList);
            
            while (rs.next()) {
                EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setDegId(rs.getString(1));
                bean.setDegName(rs.getString(2));
                bean.setDptId(rs.getString(3));
                bean.setDptName(rs.getString(4));
                
                
                degList.add(bean);
            }
            System.out.println("---------------"+degList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return degList;
    }
     
      
          
     public List<EvaluationLoadBean> subList(int degId) {
         List<EvaluationLoadBean> subList = new ArrayList<EvaluationLoadBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            //String sbList = "select * from subject";
            String sbList = "select sub.*,deg.degree_name  from subject sub, degree deg where sub.degree_id = deg.degree_id and deg.degree_id='"+ degId +"' ";
            ResultSet rs = stmt.executeQuery(sbList);
            
            while (rs.next()) {
                EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setSubId((rs.getString(1)));
                bean.setSubName((rs.getString(2)));
                bean.setDegId(rs.getString(3));
                bean.setDegName(rs.getString(4));
                
                subList.add(bean);
            }
            System.out.println("---------------"+subList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return subList;
    }
     
       public List<EvaluationLoadBean> pprassignList(String rid,String paperassignid) {
         List<EvaluationLoadBean> pprList = new ArrayList<EvaluationLoadBean>();
           System.out.println("rid:::::::::::::::::::"+rid);
           System.out.println("paperassignedid:::::::::::::::::"+paperassignid);
         int aid=0;
         try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String q1 = "select assign_id from assign_subject where registration_id='"+ rid +"' and paper_assign_id='"+ paperassignid +"'";
            
            ResultSet rs = stmt.executeQuery(q1);
            
            while (rs.next()) {
                
                aid=Integer.parseInt(rs.getString(1));
            }
            System.out.println("---------------"+aid);
            
            String q2="select p.paper_id,p.paper_name from paper_master p, assign_subject a where p.assign_id=a.assign_id and a.registration_id='" + rid + "'";
            //String q2="select paper_id,paper_name from paper_master where assign_id='"+ aid +"'";
            ResultSet rs1 = stmt.executeQuery(q2);
            
            while (rs1.next()) {
                
              EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setPprId((rs1.getString(1)));
                bean.setPprName((rs1.getString(2)));
//                bean.setSubId(rs.getString(3));
//                bean.setSubName(rs.getString(4));
                pprList.add(bean);
            }
            System.out.println("---------------"+aid);

            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
          return pprList;
       }
     

     
     
    public List<EvaluationLoadBean> pprList(int subId) {
        List<EvaluationLoadBean> pprList = new ArrayList<EvaluationLoadBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            //String pList = "select paper_id,paper_name from  paper_master";
            //String pList = "select p.*,sub.subject_name  from paper_master p, subject sub where p.subject_id = sub.subject_id and sub.subject_id='"+ subId +"' ";
            
            String aquery="select assign_id from assign_subject where suject_id='"+ subId +"' ";
            String aid="";
            ResultSet rs = stmt.executeQuery(aquery);
            while(rs.next())
            {
                aid=rs.getString(1);
                
            }
            
            String aquery2="select p.paper_id,p.paper_name from paper_master p,assign_subject a where p.assign_id=a.assign_id and a.suject_id='"+ subId +"'";
            rs=stmt.executeQuery(aquery2);
            while (rs.next()) {
                EvaluationLoadBean bean = new EvaluationLoadBean();
                bean.setPprId((rs.getString(1)));
                bean.setPprName((rs.getString(2)));
//                bean.setSubId(rs.getString(3));
//                bean.setSubName(rs.getString(4));
                pprList.add(bean);
            }
            System.out.println("---------------"+pprList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return pprList;}
    
}
