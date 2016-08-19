/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.bean;

/**
 *
 * @author asnthvinayak
 */
public class UnitQuestionBean {
 
    int unitQuestionId;
    String unitQuestionName;
    int subjectid;
    String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
    
    public int getUnitQuestionId() {
        return unitQuestionId;
    }

    public void setUnitQuestionId(int unitQuestionId) {
        this.unitQuestionId = unitQuestionId;
    }

    public String getUnitQuestionName() {
        return unitQuestionName;
    }

    public void setUnitQuestionName(String unitQuestionName) {
        this.unitQuestionName = unitQuestionName;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

  
    
    
    
}
