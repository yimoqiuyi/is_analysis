package com.yp.common.mapper;

import com.yp.common.pojo.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//�������õĲ���
public interface AttendanceMapper {

    //��ȡ���п�������
    public List<Attendance> selectAllAttendance();

    //¼�뿼��
    public boolean insertAttendance(Attendance attendance);

    //�޸Ŀ�������
    public boolean updateAttendance(Attendance attendance);

    //ɾ���������ø���id
    public int delectOneAttendanceByid(@Param(value = "attendanceId") int attendanceId);

    //ɾ�����п�������
    public int delectAllAttendance();

    //�����û�ID�鿴��������
    public List<Attendance> selectAttendanceByUserId(@Param(value = "userId") int userId);

    //���������鿴��������
    public Attendance selectOneAttendanceById(@Param(value = "attendanceId") int attendanceId);

}
