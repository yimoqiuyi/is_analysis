package com.yp.common.mapper;

import com.yp.common.pojo.Patent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//ר����Ĳ���
public interface PatentMapper {
    //ͨ�������鿴ר��
    public Patent selectOnePatentByid(int patentId);

    //�ù��Ŷ������ѯר������
    public int selectPatentsByGroupId(int groupId);

    //ͨ���Ŷ�����鿴ר��
    public List<Patent> selectAllPatentBygroupId(int groupId);

    //ͨ���Ŷ�����Լ�״̬��鿴ר��
    public List<Patent> selectPatentByGroupIdAndState(@Param("groupId") int groupId, @Param("patentState") int patentState);

    //ͨ����԰������鿴ר��
    public List<Patent> selectAllPatentBysubParkId(int subParkId);

    //��ҳ�鿴ר��
    public List<Patent> selectPatentByLimit(@Param("map") Map<String, Object> map);

    //ͨ����԰������鿴ר��
    public List<Patent> selectAllPatentBygeneralParkId(@Param("generalParkId") int generalParkId);

    //��ҳ��ѯ�����Ŷ�Id
    public List<Patent> selectPatentByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //��ѯ���е�ר����
    public List<Patent> selectAllPatent();

    //¼��ר����
    public boolean insertOnePatent(Patent patent);

    //�޸�ר����
    public boolean updateOnePatent(Patent patent);

    //ɾ��ר����
    public int delectOnePatentByid(int patentId);

    //ɾ������ר��ͨ��achievementsId
    public int deletePatentByAchievementsId(@Param("achievementsId") int achievementsId);
}
