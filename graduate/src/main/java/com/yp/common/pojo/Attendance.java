package com.yp.common.pojo;



import java.io.Serializable;
import java.util.List;

public class Attendance implements Serializable {
    private int attendanceId;//
    private String attendanceCategory;//�������
    private int  attendanceScore;//����Ӧ���ڷ���
    private List<User> userList;

    public int getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(int attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getAttendanceCategory() {
        return attendanceCategory;
    }

    public void setAttendanceCategory(String attendanceCategory) {
        this.attendanceCategory = attendanceCategory;
    }


}
