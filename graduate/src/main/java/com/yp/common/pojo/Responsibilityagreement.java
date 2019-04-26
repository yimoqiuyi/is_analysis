package com.yp.common.pojo;

 

import java.io.Serializable;
import java.util.Date;

public class Responsibilityagreement implements Serializable {
    private int responsibleId;
    private String responsibleName;//����Э������
    private String responsibleIntroduce;//����Э�����
    private String filePath;//�ļ�·��
    private String signDate;//ǩ������
    private String expirationDate;//��������
    private int argeementId;//��ͬ���
    private int groupId;//�Ŷ����
    private int subParkId;//��԰�����
    private int generalParkId;//��԰�����
    private Agreement agreement = null;


    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getResponsibleIntroduce() {
        return responsibleIntroduce;
    }

    public void setResponsibleIntroduce(String responsibleIntroduce) {
        this.responsibleIntroduce = responsibleIntroduce;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    public int getArgeementId() {
        return argeementId;
    }

    public void setArgeementId(int argeementId) {
        this.argeementId = argeementId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }



    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }
}
