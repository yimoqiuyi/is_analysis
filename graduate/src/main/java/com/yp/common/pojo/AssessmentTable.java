package com.yp.common.pojo;



import java.io.Serializable;

//����
public class AssessmentTable implements Serializable {
    private int assessmentId;
    private int patentNum;//ר����
    private int softwareNum;//������
    private int paperNum;//������
    private int competitionNum;//����
    private String assessmentStartTime;//����ʼ����
    private String assessmentEndTime;//�����������
    private int groupId;//�Ŷ����
    private  Group group=null;

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public  Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }



    public int getPatentNum() {
        return patentNum;
    }

    public void setPatentNum(int patentNum) {
        this.patentNum = patentNum;
    }

    public int getSoftwareNum() {
        return softwareNum;
    }

    public void setSoftwareNum(int softwareNum) {
        this.softwareNum = softwareNum;
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public int getCompetitionNum() {
        return competitionNum;
    }

    public void setCompetitionNum(int competitionNum) {
        this.competitionNum = competitionNum;
    }

    public String getAssessmentStartTime() {
        return assessmentStartTime;
    }

    public void setAssessmentStartTime(String assessmentStartTime) {
        this.assessmentStartTime = assessmentStartTime;
    }

    public String getAssessmentEndTime() {
        return assessmentEndTime;
    }

    public void setAssessmentEndTime(String assessmentEndTime) {
        this.assessmentEndTime = assessmentEndTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
