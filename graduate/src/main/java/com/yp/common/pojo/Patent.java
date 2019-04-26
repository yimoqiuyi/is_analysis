package com.yp.common.pojo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patent implements Serializable {
    private int patentId;//
    private String patentCategory;//ר������
    private String patentName;//ר������
    private String patentPeopleName;//ר��Ȩ��
    private String patentCreatePeopleName;//ר��������
    private String patentApplyTime;//������
    private String patentApplyNumber;//�����
    private String dateofAuthorization;//��Ȩ����
    private String authorizedPatentNumber;//��Ȩר����
    private String patentAuditTime;//ר�����ʱ��
    private int patentState;//���״̬
    private int achievementsId;//�ɹ����
    private int groupId;//�Ŷ����
    private int subParkId; //��԰�����
    private int generalParkId; //��԰�����
    private Achievements achievements; //�ɹ����� 1-1
    private List<PatentFile>  patentFileList; //ר���ļ�����

    public String getAuthorizedPatentNumber() {
        return authorizedPatentNumber;
    }

    public void setAuthorizedPatentNumber(String authorizedPatentNumber) {
        this.authorizedPatentNumber = authorizedPatentNumber;
    }

    public List<PatentFile> getPatentFileList() {
        return patentFileList;
    }

    public void setPatentFileList(List<PatentFile> patentFileList) {
        this.patentFileList = patentFileList;
    }

    public int getGroupId() {
        return groupId;

    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public int getPatentId() {
        return patentId;
    }

    public void setPatentId(int patentId) {
        this.patentId = patentId;
    }

    public String getPatentCategory() {
        return patentCategory;
    }

    public void setPatentCategory(String patentCategory) {
        this.patentCategory = patentCategory;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentPeopleName() {
        return patentPeopleName;
    }

    public void setPatentPeopleName(String patentPeopleName) {
        this.patentPeopleName = patentPeopleName;
    }

    public String getPatentCreatePeopleName() {
        return patentCreatePeopleName;
    }

    public void setPatentCreatePeopleName(String patentCreatePeopleName) {
        this.patentCreatePeopleName = patentCreatePeopleName;
    }

    public String getPatentApplyTime() {
        return patentApplyTime;
    }

    public void setPatentApplyTime(String patentApplyTime) {
        this.patentApplyTime = patentApplyTime;
    }

    public String getPatentApplyNumber() {
        return patentApplyNumber;
    }

    public void setPatentApplyNumber(String patentApplyNumber) {
        this.patentApplyNumber = patentApplyNumber;
    }

    public String getDateofAuthorization() {
        return dateofAuthorization;
    }

    public void setDateofAuthorization(String dateofAuthorization) {
        this.dateofAuthorization = dateofAuthorization;
    }


    public String getPatentAuditTime() {
        return patentAuditTime;
    }

    public void setPatentAuditTime(String patentAuditTime) {
        this.patentAuditTime = patentAuditTime;
    }

    public int getPatentState() {
        return patentState;
    }

    public void setPatentState(int patentState) {
        this.patentState = patentState;
    }

    public int getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(int achievementsId) {
        this.achievementsId = achievementsId;
    }




}
