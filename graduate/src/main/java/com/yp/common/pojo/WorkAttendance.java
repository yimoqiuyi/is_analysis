package com.yp.common.pojo;

import java.io.Serializable;

public class WorkAttendance implements Serializable {
    private int waId;//
    private int userId;//�û����
    private int attendanceId;//�������

    public int getWaId() {
        return waId;
    }

    public void setWaId(int waId) {
        this.waId = waId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }
}
