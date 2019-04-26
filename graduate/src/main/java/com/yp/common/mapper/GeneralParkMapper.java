package com.yp.common.mapper;

import com.yp.common.pojo.GeneralPark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//��԰������
public interface GeneralParkMapper {

    //������԰��idѡ����԰��
    public GeneralPark selectOneGeneralParkBygeneralParkId(@Param("generalParkId") int generalParkId);

    //����԰��������ѡ��԰��
    public GeneralPark selectGeneralParkByid(@Param("userId")int userId);

    //�鿴���е���԰��
    public List<GeneralPark> selectAllGeneralPark();

    //¼����԰��
    public boolean insertGeneralPark(GeneralPark generalPark);

    //�޸���԰��
    public boolean updateGeneralPark(GeneralPark generalPark);

    //ɾ��ĳ����԰��
    public int delectGeneralParkByuserId(@Param("generalParkId")int generalParkId);

    //ɾ��������԰��
    public int delectAllGeneralPark();
}
