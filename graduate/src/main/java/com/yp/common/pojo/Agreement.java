package com.yp.common.pojo;

import java.io.Serializable;

public class Agreement implements Serializable {
    private int agreementId;
    private String agreementName; //��ͬ����
    private String agreementCategory;//��ͬ���

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }

    public String getAgreementName() {
        return agreementName;
    }

    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName;
    }

    public String getAgreementCategory() {
        return agreementCategory;
    }

    public void setAgreementCategory(String agreementCategory) {
        this.agreementCategory = agreementCategory;
    }


}
