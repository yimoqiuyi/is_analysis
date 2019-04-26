package com.yp.common.service;

import com.yp.common.pojo.Patent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PatentService {
    //ͨ�������鿴ר��
    public Patent selectOnePatentByid(@Param("patentId") int patentId);

    //�ù��Ŷ������ѯר������
    public int selectPatentsByGroupId(@Param("groupId") int groupId);

    //ͨ���Ŷ�����鿴ר��
    public List<Patent> selectAllPatentBygroupId(@Param("groupId") int groupId);

    //ͨ����԰������鿴ר��
    public List<Patent> selectAllPatentBysubParkId(int subParkId);

    //ͨ���Ŷ�����Լ�״̬��鿴ר��
    public List<Patent> selectPatentByGroupIdAndState(@Param("groupId") int groupId, @Param("patentState") int patentState);

    //ͨ����԰������鿴ר��
    public List<Patent> selectAllPatentBygeneralParkId(@Param("generalParkId") int generalParkId);

    public List<Patent> selectPatentByLimit(@Param("map") Map<String, Object> map);

    //��ѯ���е�ר����
    public List<Patent> selectAllPatent();

    public List<Patent> selectPatentByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //¼��ר����
    public boolean insertOnePatent(Patent patent);

    //�޸�ר����
    public boolean updateOnePatent(Patent patent);

    //ɾ��ר����
    public int delectOnePatentByid(int patentId);

    //ɾ������ר��ͨ��achievementsId
    public int deletePatentByAchievementsId(@Param("achievementsId") int achievementsId);

}
