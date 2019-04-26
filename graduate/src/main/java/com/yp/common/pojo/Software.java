package com.yp.common.pojo;



import java.io.Serializable;

public class Software implements Serializable {
    private int softId;
    private String softName;//��������
    private String softPeopleMame;//����Ȩ��
    private String softGrade;//��������
    private String dateofAuthorization;//��Ȩ����
    private String certificateNumber;// ֤���
    private String registrationNumber;//�ǼǺ�
    private String softDocument;//�����ļ�(PDF)·��
    private String softwareAuditTime;//�������ʱ��
    private int softwareState;//״̬
    private int groupId;//�Ŷ����
    private int achievementsId;//�ɹ����
     private int subParkId; //��԰�����
    private int generalParkId; //��԰�����
    private Achievements achievements; //�ɹ����� 1-1

    public String getSoftGrade() {
        return softGrade;
    }

    public void setSoftGrade(String softGrade) {
        this.softGrade = softGrade;
    }

    @Override
    public String toString() {
        return "Software{" +
                "softId=" + softId +
                ", softName='" + softName + '\'' +
                ", softPeopleMame='" + softPeopleMame + '\'' +
                ", softGrade='" + softGrade + '\'' +
                ", dateofAuthorization='" + dateofAuthorization + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", softDocument='" + softDocument + '\'' +
                ", softwareAuditTime='" + softwareAuditTime + '\'' +
                ", softwareState=" + softwareState +
                ", groupId=" + groupId +
                ", achievementsId=" + achievementsId +
                ", subParkId=" + subParkId +
                ", generalParkId=" + generalParkId +
                ", achievements=" + achievements +
                '}';
    }

    public int getSoftwareState() {
        return softwareState;
    }

    public void setSoftwareState(int softwareState) {
        this.softwareState = softwareState;
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

    public int getSoftId() {
        return softId;
    }

    public void setSoftId(int softId) {
        this.softId = softId;
    }

    public String getSoftName() {
        return softName;
    }

    public void setSoftName(String softName) {
        this.softName = softName;
    }

    public String getSoftPeopleMame() {
        return softPeopleMame;
    }

    public void setSoftPeopleMame(String softPeopleMame) {
        this.softPeopleMame = softPeopleMame;
    }

    public String getDateofAuthorization() {
        return dateofAuthorization;
    }

    public void setDateofAuthorization(String dateofAuthorization) {
        this.dateofAuthorization = dateofAuthorization;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getSoftDocument() {
        return softDocument;
    }

    public void setSoftDocument(String softDocument) {
        this.softDocument = softDocument;
    }

    public String getSoftwareAuditTime() {
        return softwareAuditTime;
    }

    public void setSoftwareAuditTime(String softwareAuditTime) {
        this.softwareAuditTime = softwareAuditTime;
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
}
