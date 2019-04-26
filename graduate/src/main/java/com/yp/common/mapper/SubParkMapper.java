package com.yp.common.mapper;

import com.yp.common.pojo.SubPark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//��԰��������
public interface SubParkMapper {
    //��������ѡ���԰��
    public SubPark selectOneSubParkById(int subParkId);

    //�����û�id�鿴��԰��������
    public SubPark selectSubparkByUserId(@Param("userId") int userId);

    //������԰��ѡ���԰��
    public List<SubPark> selectAllSubParkBygeneralParkId(@Param("generalParkId") int generalParkId);

    //¼���԰��
    public boolean insertOneSubPark(SubPark subPark);

    //�޸ķ�԰��
    public boolean updateOneSubPark(SubPark subPark);

    //ɾ����԰��
    public int deleteOneSubPark(int subParkId);


}
