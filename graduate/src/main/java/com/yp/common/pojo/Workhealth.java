package com.yp.common.pojo;


import java.io.Serializable;

public class Workhealth implements Serializable {
    private int whId;
    private int userId;//�û����
    private int sId;//�������
     public int getWhId() {
        return whId;
    }

    public void setWhId(int whId) {
        this.whId = whId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }
}
