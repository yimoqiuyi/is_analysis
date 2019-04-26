package com.yp.common.mapper;

import com.yp.common.pojo.WorkPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//��λ����
public interface WorkPositionMapper {

    //����������ȡ��λ��Ϣ
    public WorkPosition selectOneWorkPositionById(@Param("workId") int workId);

    //������λ��ʽid�鿴��λ
    public List<WorkPosition> selectWorkPositionByworkStyleId(@Param("workStyleId") int workStyleId);

    //���ݸ����˲鿴��λ
    public List<WorkPosition> selectAllWorkPositionBygroupId(int groupId);

    //���ݸ������빤λ״̬�鿴��λ
    public List<WorkPosition> selectAllWorkPositionBygroupIdandState(@Param("groupId") int groupId, @Param("workState") int workState);

    //����״̬�鿴����λ��
    public List<WorkPosition> selectWorkPositionByState(@Param("state") int state);

    //���ݷ�������鿴��λ
    public List<WorkPosition> selectAllWorkPositionByroomId(@Param("roomId") int roomId);

    //ͨ����԰����Ϣѡ��鿴����԰�������еĹ�λ
    public List<WorkPosition> selectAllWorkPositionBySubparkId(int subParkId);

    //¼�빤λ��Ϣ
    public boolean insertOneWorkPosition(WorkPosition workPosition);

    //�޸Ĺ�λ��Ϣ
    public boolean updateOneWorkPosition(WorkPosition workPosition);

    //ɾ����λ
    public int deleteOneWorkPositionById(@Param("workId") int workId);

    //ͨ����������ܺ���λ����
    public int selectWorkPositionByRoomId(@Param("roomId") int roomId);
}
