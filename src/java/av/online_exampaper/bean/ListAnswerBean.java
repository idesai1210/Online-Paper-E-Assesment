/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.bean;

/**
 *
 * @author KLINGON
 */
public class ListAnswerBean {
    private String pprid;
    private String answersheetid;
    private String student_id;
    private String path;

    public String getPprid() {
        return pprid;
    }

    public void setPprid(String pprid) {
        this.pprid = pprid;
    }

    public String getAnswersheetid() {
        return answersheetid;
    }

    public void setAnswersheetid(String answersheetid) {
        this.answersheetid = answersheetid;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
