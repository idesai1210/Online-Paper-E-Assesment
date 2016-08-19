/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.OpenPicBean;
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
public class OpenPicDao {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs=null,rs1=null;
    private static PreparedStatement ps=null;
    
    public List<OpenPicBean> imgList(String studid, String pprid) {
         List<OpenPicBean> imgList = new ArrayList<OpenPicBean>();
         
        try {
            conn = ConnectionUtill.getCon();
            stmt = conn.createStatement();
            String iList = "select answersheet_path from student_answersheet where paper_id='"+ pprid +"' and student_id='"+ studid +"'";
            System.out.println("-----hereOPen PAth******");
            ResultSet rs = stmt.executeQuery(iList);
            
            while (rs.next()) {
                OpenPicBean bean = new OpenPicBean();
                bean.setPpath((rs.getString(1)));
            
                
                imgList.add(bean);
            }
            System.out.println("---------------"+imgList);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return imgList;
    }
}
