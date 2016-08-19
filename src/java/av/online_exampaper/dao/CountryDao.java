/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.CountryBean;
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
public class CountryDao {
        static Connection conn=null;
    static Statement stmt=null;
    static PreparedStatement pst=null;
    static ResultSet rs=null;
    static boolean flag=false;
    
    public static boolean countryInsert(CountryBean bean)
    {
        try{
            conn=ConnectionUtill.getCon();
            //stmt=conn.createStatement();
            String insert="insert into Country(country_name) values(?)";
            //int i=stmt.executeUpdate(insert);
            pst=conn.prepareStatement(insert);
            pst.setString(1, bean.getCountryName());
            int i=pst.executeUpdate();
                    
            if(i>0)
            {
                flag=true;
                System.out.println("inserted data");
            }else
            {
                System.out.println("not inserted");         
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return flag;
        
    }
    public static List countryShow()
    {
        List countryList=new ArrayList();
        try{
            CountryBean bean=null;
            conn=ConnectionUtill.getCon();
            stmt=conn.createStatement();
            String select="select * from Country";
            rs=stmt.executeQuery(select);
            while (rs.next()) {
                
             bean=new CountryBean();
             bean.setCountryId(rs.getInt(1));
             bean.setCountryName(rs.getString(2));
             countryList.add(bean);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return  countryList;
              
    }
    
    public static boolean countryDelete(CountryBean bean)
    {
        try{
            conn=ConnectionUtill.getCon();
             String countryDelete="delete from Country where country_id=(?)";
            pst=conn.prepareStatement(countryDelete);
            pst.setInt(1, bean.getCountryId());
            int d=pst.executeUpdate();
            if(d>0)
            {
                flag=true;
                System.out.println("flag............................"+flag);
                System.out.println("deleted record");
            }else
            {
                System.out.println("not deleted");
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    public static List countryFetch(int id)
    {
        List countryList=new ArrayList();
        try{
            
            conn=ConnectionUtill.getCon();
            String fat="select * from Country where country_id=(?)";
            
            pst=conn.prepareStatement(fat);
            pst.setInt(1, id);
            
            rs=pst.executeQuery();
            while (rs.next()) { 
                CountryBean ubean =new CountryBean();
            
                ubean.setCountryId(rs.getInt(1));
                ubean.setCountryName(rs.getString(2));
                countryList.add(ubean);
            }
        }catch(SQLException e)
        {
            System.out.println("fatch error..........");
        }
        return countryList;
    }
    
    public static boolean countryUpdate(CountryBean bean)
    {
        try{
            conn=ConnectionUtill.getCon();
            String update="update Country set country_name=(?) where country_id=(?)";
            pst=conn.prepareStatement(update);
            pst.setString(1, bean.getCountryName());
            pst.setInt(2, bean.getCountryId());
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
