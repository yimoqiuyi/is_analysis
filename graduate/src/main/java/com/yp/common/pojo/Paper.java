package com.yp.common.pojo;



import java.io.Serializable;

public class Paper implements Serializable {
    private int paperId;
    private String paperName;//��������
    private String authors;//����
    private String authorUnit;//���ߵ�λ
    private String journalName;//�ڿ�����
    private String paperAuditTime;//�������ʱ��:
    private String grade;//���ĵȼ�
    private int groupId;//�Ŷ����
    private int achievementsId;//�ɹ����
    private int paperState;//���״̬
    private String paperPath;//����·��
    private int subParkId; //��԰�����
    private int generalParkId; //��԰�����
    private Achievements achievements; //�ɹ����� 1-1

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public Achievements getAchievements() {
        return achievements;
    }

    public void setAchievements(Achievements achievements) {
        this.achievements = achievements;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getAuthorUnit() {
        return authorUnit;
    }

    public void setAuthorUnit(String authorUnit) {
        this.authorUnit = authorUnit;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getPaperAuditTime() {
        return paperAuditTime;
    }

    public void setPaperAuditTime(String paperAuditTime) {
        this.paperAuditTime = paperAuditTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(int achievementsId) {
        this.achievementsId = achievementsId;
    }

    public int getPaperState() {
        return paperState;
    }

    public void setPaperState(int paperState) {
        this.paperState = paperState;
    }

    public String getPaperPath() {
        return paperPath;
    }

    public void setPaperPath(String paperPath) {
        this.paperPath = paperPath;
    }
}
