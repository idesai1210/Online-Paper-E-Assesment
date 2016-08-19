/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import static av.online_exampaper.dao.StateDao.conn;
import av.online_exampaper.bean.CityBean;
import av.online_exampaper.bean.StateBean;
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
 * @author Bhumi
 */
public class CityDao {
    
    static Connection conn=null;
    static Statement stmt=null;
    static boolean flag=false;
    static PreparedStatement pst=null;
    static ResultSet rs=null;



public static boolean cityInsert(CityBean cbean)
{
    try{
        conn=ConnectionUtill.getCon();
        String cityInsert="insert into City(city_name,state_id)values(?,?)";
        pst=conn.prepareStatement(cityInsert);
        pst.setString(1, cbean.getCityName());
        pst.setInt(2, cbean.getStateId());
        
        int i=pst.executeUpdate();
        if(i>0)
        {
            flag=true;
            System.out.println("insert data");
        }else
        {
            System.out.println("not insert data....");
        }
        
    }catch(SQLException e)
    {
        System.out.println("insert error.....");
    }
    return flag;

}
    public static List cityShow() {
        List cityList = new ArrayList();
        try {
            conn = ConnectionUtill.getCon();
            String citySelect = "select c.*,s.state_name,co.* from city c, state s, country co where c.state_id=s.state_id and s.country_id=co.country_id";
            CityBean cbean = null;
            pst = conn.prepareStatement(citySelect);
            //pst.setInt(1, sbean.getState_id());
            //pst.setString(2,sbean.getState_name());
            //pst.setInt(3, sbean.getCountry_id());
            rs = pst.executeQuery();
            while (rs.next()) {
                cbean = new CityBean();
                cbean.setCityId(rs.getInt(1));
                cbean.setCityName(rs.getString(2));
                cbean.setStateId(rs.getInt(3));
                cbean.setStateName(rs.getString(4));
                cbean.setCountryId(rs.getInt(5));
                cbean.setCountryName(rs.getString(6));
                cityList.add(cbean);


            }
        } catch (SQLException e) {
            System.out.println("not show data");
        }
        return cityList;

    }
public static boolean cityDelete(int id)
{
    try{
        conn=ConnectionUtill.getCon();
        String cityDelete="delete from City where city_id=(?)";
        pst=conn.prepareStatement(cityDelete);
        CityBean cbean=new CityBean();
        pst.setInt(1, id);
        //pst.setString(2, sbean.getState_name());
        //pst.setString(3, sbean.getCountry_name());
         int d=pst.executeUpdate();
         if(d>0)
         {
             flag=true;
             System.out.println("delete record");
         }
    }catch(SQLException e)
    {
        System.out.println("delete error...");
    }
    return flag;
}
 public static List cityFetch(int id)
    {
        List cityList=new ArrayList();
        try{
            
            conn=ConnectionUtill.getCon();
            String cityFetch="select c.*,s.*,co.* from city c, state s, country co where c.state_id=s.state_id and s.country_id=co.country_id and c.city_id=?";     
       
            pst=conn.prepareStatement(cityFetch);
            pst.setInt(1, id);
            
            rs=pst.executeQuery();
            while (rs.next()) { 
             CityBean cbean=new CityBean();
              cbean.setCityId(rs.getInt("city_id"));
              cbean.setCityName(rs.getString("city_name"));
              cbean.setStateId(rs.getInt("state_id"));
              cbean.setStateName(rs.getString("state_name"));
              cbean.setCountryId(rs.getInt("country_id"));
              cbean.setCountryName(rs.getString("country_name"));
              cityList.add(cbean);
            }
        }catch(SQLException e)
        {
            System.out.println("fatch error..........");
        }
        return cityList;
}
 public static boolean cityUpdate(CityBean cbean)
        {
        try{
            conn=ConnectionUtill.getCon();
            String update="update City set city_name=(?),state_id=(?) where city_id=(?)";
            pst=conn.prepareStatement(update);
            pst.setString(1, cbean.getCityName());
            pst.setInt(2, cbean.getStateId());
            pst.setInt(3, cbean.getCityId());
            int u=pst.executeUpdate();
            if(u>0)
            {
                flag=true;
                System.out.println("updated record");
            }else
            {
                System.out.println("not updated record");
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return flag;
        
    }
} 