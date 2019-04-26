package com.yp.common.pojo;

 
import java.io.Serializable;
import java.util.Date;

public class Managementagreement implements Serializable {
    private int managementId;
    private String managementName;//�ʲ�Э������
    private String managementIntroduce;//�ʲ�Э�����
    private String filePath;//�ļ�·��
    private String signDate;//ǩ������
    private String expirationDate;//��������
    private int groupId;//�Ŷ����
    private int subParkId;//��԰�����
    private int generalParkId;//��԰�����
    private int agreementId;//��ͬ���
    private Agreement agreement = null;

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public int getManagementId() {
        return managementId;
    }

    public void setManagementId(int managementId) {
        this.managementId = managementId;
    }

    public String getManagementName() {
        return managementName;
    }

    public void setManagementName(String managementName) {
        this.managementName = managementName;
    }

    public String getManagementIntroduce() {
        return managementIntroduce;
    }

    public void setManagementIntroduce(String managementIntroduce) {
        this.managementIntroduce = managementIntroduce;
    }

    public String getFilePath() {
        return filePath;
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

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }
}
