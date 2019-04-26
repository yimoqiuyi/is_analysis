package com.yp.common.service;

import com.yp.common.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {
    //���ݷ���idѡ�񷿼�
    public Room selectOneRoomById(@Param("roomId") int roomId);

    //���ݷ�԰���鿴����
    public List<Room> selectAllRoomBysubParkId(@Param("subParkId") int subParkId);

    //¼�뷿��
    public boolean insertOneRoom(Room room);

    //�޸ķ���
    public boolean updateOneRoom(Room room);

    //ɾ���������id
    public int deleteOneRoomById(@Param("roomId") int roomId);

    //ͨ��buidingId�鿴����
    public List<Room> selectRoomByBuildId(@Param("buildId") int buildId);

    //��ҳ�鿴
    public List<Room> seletctRoomByLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

    //ɾ���������buildId
    public int deleteOneRoomBybuildId(@Param("buildId") int buildId);

    //ͨ����԰��generalParkId�鿴����
    public List<Room> selectRoomBygeneralParkId(@Param("generalParkId") int generalParkId);

    //ͨ��assetId��ѯ����
    public Room selectRoomByassetId(@Param("assetId") int assetId);

    //ͨ����԰�����ͳ�Ʒ�������
    public int selectRoomBySubParkId(@Param("subParkId") int subParkId);

    public int selectRoomNumberByBuildId(@Param("buildId") int buildId);
}
