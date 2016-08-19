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
public class MarksBean {

    private String examquesid;
    private String mq;
    private String sq;
    private String que;
    private String marks;

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getExamquesid() {
        return examquesid;
    }

    public void setExamquesid(String examquesid) {
        this.examquesid = examquesid;
    }

    public String getMq() {
        return mq;
    }

    public void setMq(String mq) {
        this.mq = mq;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

}
