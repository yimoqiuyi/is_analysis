package com.yp.common.pojo;

import java.io.Serializable;
import java.util.List;

public class WorkstylePicture implements Serializable {
    private int workStyleId;//��λ��ʽ����
    private String workStyleName;//��λ��ʽ����
    private String workStylePicture;//��λ��ʽͼƬ
    private List<WorkPosition> workPositionList;

    public List<WorkPosition> getWorkPositionList() {
        return workPositionList;
    }

    public void setWorkPositionList(List<WorkPosition> workPositionList) {
        this.workPositionList = workPositionList;
    }

    public int getWorkStyleId() {
        return workStyleId;
    }

    public void setWorkStyleId(int workStyleId) {
        this.workStyleId = workStyleId;
    }

    public String getWorkStyleName() {
        return workStyleName;
    }

    public void setWorkStyleName(String workStyleName) {
        this.workStyleName = workStyleName;
    }

    public String getWorkStylePicture() {
        return workStylePicture;
    }

    public void setWorkStylePicture(String workStylePicture) {
        this.workStylePicture = workStylePicture;
    }
}
