package com.yp.common.pojo;

 

import java.io.Serializable;

public class AssessmentReport implements Serializable {
    private int reportId;//
    private String assessmentMessage;//�����������4
    private String sDescription;//�����������
    private String attendanceDescription;//�����������
    private int groupId;//�Ŷ����
    private Group group=null;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getAssessmentMessage() {
        return assessmentMessage;
    }

    public void setAssessmentMessage(String assessmentMessage) {
        this.assessmentMessage = assessmentMessage;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public String getAttendanceDescription() {
        return attendanceDescription;
    }

    public void setAttendanceDescription(String attendanceDescription) {
        this.attendanceDescription = attendanceDescription;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
