/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av.online_exampaper.dao;

import static av.online_exampaper.dao.CountryDao.conn;
import av.online_exampaper.bean.CountryBean;
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
public class StateDao {

    static Connection conn = null;
    static Statement stmt = null;
    static boolean flag = false;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public static boolean stateInsert(StateBean sbean) {
        try {
            conn = ConnectionUtill.getCon();
            String stateInsert = "insert into State(state_name,country_id)values(?,?)";
            pst = conn.prepareStatement(stateInsert);
            pst.setString(1, sbean.getStateName());
            pst.setInt(2, sbean.getCountryId());
            int i = pst.executeUpdate();
            if (i > 0) {
                flag = true;
                System.out.println("insert data");
            } else {
                System.out.println("not insert data....");
            }

        } catch (SQLException e) {
            System.out.println("insert error.....");
        }
        return flag;
    }

    public static List stateShow() {
        List<StateBean> stateList = new ArrayList<StateBean>();
        try {
            conn = ConnectionUtill.getCon();
            String stateSelect = "select s.state_id,s.state_name,c.country_id,c.country_name from State s,Country c where s.country_id=c.country_id";
            StateBean sbean = null;
            pst = conn.prepareStatement(stateSelect);
            //pst.setInt(1, sbean.getState_id());
            //pst.setString(2,sbean.getState_name());
            //pst.setInt(3, sbean.getCountry_id());
            rs = pst.executeQuery();
            while (rs.next()) {
                sbean = new StateBean();
                sbean.setStateId(rs.getInt(1));
                sbean.setStateName(rs.getString(2));
                sbean.setCountryId(rs.getInt(3));
                sbean.setCountryName(rs.getString(4));
                stateList.add(sbean);
            }
        } catch (SQLException e) {
            System.out.println("not show data");
        }
        for (StateBean s : stateList) {
            System.out.println(">>>>>>>>>>>>" + s.getStateId());;
        }

        return stateList;

    }

    public static boolean stateDelete(int id) {
        try {
            conn = ConnectionUtill.getCon();
            String stateDelete = "delete from State where state_id=(?)";
            pst = conn.prepareStatement(stateDelete);
            StateBean sbean = new StateBean();
            pst.setInt(1, id);
            //pst.setString(2, sbean.getState_name());
            //pst.setString(3, sbean.getCountry_name());
            int d = pst.executeUpdate();
            if (d > 0) {
                flag = true;
                System.out.println("delete record");
            }
        } catch (SQLException e) {
            System.out.println("delete error...");
        }
        return flag;
    }

    public static List stateFetch(int id) {
        List stateList = new ArrayList();
        try {

            conn = ConnectionUtill.getCon();
            String fat = "select s.state_id,s.state_name,c.country_id,c.country_name from State s,Country c where s.country_id=c.country_id and s.state_id=?";

            pst = conn.prepareStatement(fat);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                StateBean sbean = new StateBean();

                sbean.setStateId(rs.getInt(1));
                sbean.setStateName(rs.getString(2));
                sbean.setCountryId(rs.getInt(3));
                sbean.setCountryName(rs.getString(4));
                stateList.add(sbean);
            }
        } catch (SQLException e) {
            System.out.println("fatch error..........");
        }
        return stateList;

    }

    public static boolean stateUpdate(StateBean bean) {
        try {
            conn = ConnectionUtill.getCon();
            String stateUpdate = "update State set state_name=(?),country_id=(?) where state_id=(?)";
            pst = conn.prepareStatement(stateUpdate);
            pst.setString(1, bean.getStateName());
            pst.setInt(2, bean.getCountryId());
            pst.setInt(3, bean.getStateId());
            int u = pst.executeUpdate();
            if (u > 0) {
                flag = true;
                System.out.println("updated record");
            } else {
                System.out.println("not updated record");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }
}
