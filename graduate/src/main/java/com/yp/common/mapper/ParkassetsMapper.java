package com.yp.common.mapper;

import com.yp.common.pojo.Parkassets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//�ʲ��Ĳ���
public interface ParkassetsMapper {

    //����id�鿴�ʲ�
    public Parkassets selectOneParkassetsByid(@Param("assetId") int assetId);

    //���ݷ���id�鿴�ʲ�
    public Parkassets selectOneParkassetsByroomId(@Param("roomId") int roomId);

    //�鿴�����ʲ���
    public List<Parkassets> selectAllParkassets();

    //¼���ʲ�
    public boolean insertOneParkassets(Parkassets parkassets);

    //�޸��ʲ�
    public boolean updateOneParkassets(Parkassets parkassets);

    //����idɾ���ʲ�
    public int delectOneParkassetsByid(@Param("assetId") int assetId);

    //����roomIdɾ���ʲ���
    public int deleteParkassetsByRoomId(@Param("roomId") int roomId);
}
