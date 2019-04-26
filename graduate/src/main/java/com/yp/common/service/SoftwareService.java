package com.yp.common.service;

import com.yp.common.pojo.Software;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SoftwareService {
    //��������ѡ������
    public Software selectOneSoftwareById(@Param("softId") int softId);

    //�����Ŷ����ѡ����������
    public int selectSoftWaresByGroupId(@Param("groupId") int groupId);

    //�����Ŷ����ѡ������
    public List<Software> selectAllSoftwareBygroupId(@Param("groupId") int groupId);

    //���ݷ�԰���鿴����
    public List<Software> selectAllSoftwareBysubParkId(@Param("subParkId") int subParkId);

    //������԰���鿴����
    public List<Software> selectAllSoftwareBygeneralParkId(@Param("generalParkId") int generalParkId);

    //����groupId��state��ѯ����
    public List<Software> selectSoftWareByGroupIdAndsoftwareState(@Param("groupId") int groupId, @Param("softwareState") int softwareState);

    //��ҳ��ѯ
    public List<Software> selectSoftwareByLimit(@Param("map") Map<String, Object> map);

    public List<Software> selectSoftwareByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //¼������
    public boolean insertOneSoftware(Software software);

    //�޸�����
    public boolean updateOneSoftware(Software software);

    //ɾ������
    public int deleteOneSoftwareById(@Param("softId") int softId);

    //ɾ����������achievementsId
    public int deleteSoftWareByAchievementsId(@Param("achievementsId") int achievementsId);
}
