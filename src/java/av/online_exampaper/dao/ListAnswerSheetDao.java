/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.dao;

import av.online_exampaper.bean.ListAnswerBean;
import av.online_exampaper.utill.ConnectionUtill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KLINGON
 */
public class ListAnswerSheetDao {
    
     private static Connection conn=null;
    private static Statement stmt=null;
    private static ResultSet rs=null,rs1=null;
    
    public static List<ListAnswerBean> list(ListAnswerBean bean) {
         
        List<ListAnswerBean> anslist= new ArrayList<ListAnswerBean>();
         
        try
        {
            
            conn=ConnectionUtill.getCon();
            stmt=conn.createStatement();

            String pprId=bean.getPprid();


            String query1="Select *from student_answersheet where paper_id='"+ pprId +"' ";

            rs=stmt.executeQuery(query1);
            while(rs.next())
            {
                ListAnswerBean b1= new ListAnswerBean();
                b1.setAnswersheetid(rs.getString(1));
                b1.setStudent_id(rs.getString(2));
                b1.setPprid(rs.getString(3));
                b1.setPath(rs.getString(4));
                anslist.add(b1);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
        
        return anslist;
        }
    
}
