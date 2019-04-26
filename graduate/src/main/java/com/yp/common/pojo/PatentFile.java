package com.yp.common.pojo;

import java.io.Serializable;

public class PatentFile implements Serializable {
    private int id;
    private String pfName;   //ר���ļ�����
    private String pfPath; //ר���ļ�·��
    private int patentId;//ר�����

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPfPath() {
        return pfPath;
    }

    public void setPfPath(String pfPath) {
        this.pfPath = pfPath;
    }

    public int getPatentId() {
        return patentId;
    }

    public void setPatentId(int patentId) {
        this.patentId = patentId;
    }
}
