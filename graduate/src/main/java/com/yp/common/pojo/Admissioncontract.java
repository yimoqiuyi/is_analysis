package com.yp.common.pojo;



import java.io.Serializable;


public class Admissioncontract implements Serializable {
    private int admissionId;//
    private String admissionName;//��ͬ����
    private String admissionIntroduce;//��ͬ����
    private String filePath;//�ļ�·��
    private int agreementId;//��ͬ���
    private String signDate;//ǩ������
    private String expirationDate;//��������
    private int groupId;//�Ŷ����
    private int subParkId;//��԰�����
    private int generalParkId;//��԰�����
    private Agreement agreement = null;

    public  Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public String getAdmissionName() {
        return admissionName;
    }

    public void setAdmissionName(String admissionName) {
        this.admissionName = admissionName;
    }

    public String getAdmissionIntroduce() {
        return admissionIntroduce;
    }

    public void setAdmissionIntroduce(String admissionIntroduce) {
        this.admissionIntroduce = admissionIntroduce;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
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

    public int getGroupId() {
        return groupId;
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
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
