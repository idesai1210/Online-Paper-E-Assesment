/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.InsertBean;
import av.online_exampaper.bean.RegistrationBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KLINGON
 */
public class RegistrationDao {
     
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs=null,rs1=null;
    private static PreparedStatement ps=null;
    
     public List<RegistrationBean> countryList() {
        List<RegistrationBean> couList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String countryList = "select * from Country";

            ResultSet rs = stmt.executeQuery(countryList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setCouId(rs.getInt(1));
                bean.setCouName(rs.getString(2));

                couList.add(bean);
            }
            System.out.println("---------------"+couList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return couList;
    }
    
     public List<RegistrationBean> stateList() {
        List<RegistrationBean> sList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String stateList = "select * from State";

            ResultSet rs = stmt.executeQuery(stateList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setsId(rs.getInt(1));
                bean.setsName(rs.getString(2));
                bean.setCouId(rs.getInt(3));

                sList.add(bean);
            }
            System.out.println("---------------"+sList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return sList;
    }
     
     public List<RegistrationBean> cityList() {
        List<RegistrationBean> cList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String cityList = "select * from City";

            ResultSet rs = stmt.executeQuery(cityList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setcId(rs.getInt(1));
                bean.setcName(rs.getString(2));
                bean.setsId(rs.getInt(3));

                cList.add(bean);
            }
            System.out.println("---------------"+cList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return cList;
    }
     
     public List<RegistrationBean> secqueList() {
        List<RegistrationBean> sqList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String scqList = "select * from Security_question";

            ResultSet rs = stmt.executeQuery(scqList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setSqId(rs.getInt(1));
                bean.setSqDesc(rs.getString(2));
                
                sqList.add(bean);
            }
            System.out.println("---------------"+sqList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return sqList;
    }
     
     public List<RegistrationBean> udgradList() {
        List<RegistrationBean> ugList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String underList = "select * from qualification where qualification_name like 'B%'";

            ResultSet rs = stmt.executeQuery(underList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setUgId((rs.getInt(1)));
                bean.setUgName((rs.getString(2)));
                
                ugList.add(bean);
            }
            System.out.println("---------------"+ugList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ugList;
    }
     
     public List<RegistrationBean> postgradList() {
        List<RegistrationBean> pgList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String postList = "select * from qualification where qualification_name like 'M%'";

            ResultSet rs = stmt.executeQuery(postList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setPgId((rs.getInt(1)));
                bean.setPgName((rs.getString(2)));
                
                pgList.add(bean);
            }
            System.out.println("---------------"+pgList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return pgList;
    }
     
     public List<RegistrationBean> collegeList() {
         List<RegistrationBean> collList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String clList = "select * from college";

            ResultSet rs = stmt.executeQuery(clList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setCollId((rs.getInt(1)));
                bean.setCollName((rs.getString(2)));
                
                collList.add(bean);
            }
            System.out.println("---------------"+collList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return collList;
    }
     
     public List<RegistrationBean> degreeList() {
         List<RegistrationBean> degList = new ArrayList<RegistrationBean>();
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String dList = "select * from degree";

            ResultSet rs = stmt.executeQuery(dList);
            
            while (rs.next()) {
                RegistrationBean bean = new RegistrationBean();
                bean.setDegId((rs.getInt(1)));
                bean.setDegName((rs.getString(2)));
                
                degList.add(bean);
            }
            System.out.println("---------------"+degList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return degList;
    }
     
     public boolean Insert(InsertBean bean)
     {
         boolean flag=false;
         try
         {
               conn=ConnectionUtill.getCon();
               stmt=conn.createStatement();
               String firstName=bean.getFirstName();
               String lastName=bean.getLastName();
               String middleName=bean.getMiddleName();
               String address=bean.getAddress();
               int couId=bean.getCouId();
               int sId=bean.getsId();
               int cId=bean.getcId();
               int pincode=Integer.parseInt(bean.getPincode());
               String gender=bean.getGender();
               String mNo=bean.getmNo();
               String tNo=bean.gettNo();
               String dob=bean.getDob();
               String email=bean.getEmail();
               String altemail=bean.getAltemail();
               String username=bean.getUsername();
               String password=bean.getPassword();
               int utype=bean.getUtype();
               int sque1=bean.getSque1();
               String ans1=bean.getAns1();
               int sque2=bean.getSque2();
               String ans2=bean.getAns2();
               int ugadId=bean.getUgadId();
               int pgadId=bean.getPgadId();
               String otherqual=bean.getOtherqual();
//               int collId=bean.getCollId();
               int degId=bean.getDegId();
               String doj=bean.getDoj();
               String exp=bean.getExp();
               String a="false";
               
              
                    String query="insert into Registration_Detail(firstname,middlename,lastname,"
                            + "address,city_id,pincode,gender,mobile_no,telephone_no,dateof_birth,"
                            + "email_id,username,password,user_type_id,s_question_id1,s_answer1,"
                            + "s_question_id2,s_answer2,graduate_id,postgraduate_id,other_qualification"
                            + ",degree_id,dateof_joining,experience,approval)"
                            + " values('"+firstName+"','"+middleName+"','"+lastName+"','"+address+"','"+cId+"','"+pincode+"','"+gender+"','"+mNo+"','"+tNo+"','"+dob+"','"+email+"','"+username+"','"+password+"','"+utype+"','"+sque1+"','"+ans1+"','"+sque2+"','"+ans2+"','"+ugadId+"','"+pgadId+"','"+otherqual+"','"+degId+"','"+doj+"','"+exp+"','"+a+"')";
                    System.out.println(query);

                    int i=stmt.executeUpdate(query);
                    if(i>0)
                    {
                        flag=true;
                    }
                }
                
             
             catch(Exception e)
             {
                 e.printStackTrace();
                 System.out.println(e);
             }
         return flag;
     }

    
}
//                    ps=conn.prepareStatement(query);
//                    
//                    ps.setString(1, firstName);
//                    ps.setString(2, middleName);
//                    ps.setString(3,lastName);
//                    ps.setString(4,address);
//                    ps.setInt(5, cId);
//                    ps.setInt(6,pincode);
//                    ps.setString(7,gender);
//                    ps.setInt(8,mNo);
//                    ps.setInt(9,tNo);
//                    ps.setString(10,dob);
//                    ps.setString(11,email);
//                    ps.setString(12,username);
//                    ps.setString(13,password);
//                    ps.setInt(14,utype);
//                    ps.setInt(15,sque1);
//                    ps.setString(16,ans1);
//                    ps.setInt(17,sque2);
//                    ps.setString(18,ans2);
//                    ps.setInt(19,ugadId);
//                    ps.setInt(20,pgadId);
//                    ps.setString(21,otherqual);
//                    ps.setInt(22,collId);
//                    ps.setInt(23,degId);
//                    ps.setString(24,doj);
//                    ps.setString(25,exp);
//                    ps.setString(26, a);