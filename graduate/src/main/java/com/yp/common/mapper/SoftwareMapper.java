package com.yp.common.mapper;

import com.yp.common.pojo.Software;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//������Ĳ���
public interface SoftwareMapper {
    //��������ѡ������
    public Software selectOneSoftwareById(@Param("softId") int softId);

    //�����Ŷ����ѡ����������
    public int selectSoftWaresByGroupId(int groupId);

    //�����Ŷ����ѡ������
    public List<Software> selectAllSoftwareBygroupId(int groupId);

    //���ݷ�԰���鿴����
    public List<Software> selectAllSoftwareBysubParkId(int subParkId);

    //������԰���鿴����
    public List<Software> selectAllSoftwareBygeneralParkId(@Param("generalParkId") int generalParkId);

    //����groupId��state��ѯ����
    public List<Software> selectSoftWareByGroupIdAndsoftwareState(@Param("groupId") int groupId, @Param("softwareState") int softwareState);

    //��ҳ��ѯ
    public List<Software> selectSoftwareByLimit(@Param("map") Map<String, Object> map);

    //�����Ŷ�id��ҳ�鿴����
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
