package com.yp.common.pojo;



import java.io.Serializable;

//�Ŷӳɹ�������
public class AchievementsNumber implements Serializable {
    private int achievementsNumId;
    private int patentNum;//ר������
    private int softwareNum;//�������
    private int paperNum;//��������
    private int competitionNum;//��������
    private int groupId;//�Ŷ����
    private  Group group=null;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getAchievementsNumId() {
        return achievementsNumId;
    }

    public void setAchievementsNumId(int achievementsNumId) {
        this.achievementsNumId = achievementsNumId;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
