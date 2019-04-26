package com.yp.common.service;

import com.yp.common.pojo.Competition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CompetitionService {
    //���ݾ���id�鿴����
    public Competition selectOneCompetitionBycompetitionId(@Param("competitionId") int competitionId);

    //�����Ŷ�id�鿴�ŶӾ�������
    public int selctCompetitionsBygroupId(@Param("groupId") int groupId);

    //�����Ŷ�id�鿴�ŶӾ�������
    public List<Competition> selectAllCompetitionBygroupId(@Param("groupId") int groupId);

    //�鿴���о���
    public List<Competition> selectAllCompetition();

    //���ݷ�԰���鿴���о���
    public List<Competition> selectAllCompetitionBysubParkId(@Param("subParkId") int subParkId);

    //������԰������鿴���о���
    public List<Competition> selectAllCompetitionBygeneralParkId(@Param("generalParkId") int generalParkId);

    //�����Ŷ�id�Լ��ļ�״̬��ѯ
    public List<Competition> selectCompetionByGroupIdAndcompetitionState(@Param("groupId") int groupId, @Param("competitionState") int competitionState);

    public List<Competition> selectCompetitionByLimit(@Param("map") Map<String, Object> map);

    public List<Competition> selectCompetitionByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //¼�뾺��
    public boolean insertCompetition(Competition competition);

    //����id�޸ľ���
    public boolean updateCompetition(Competition competition);

    //ɾ���ŶӾ�����Ϣ
    public int deleteComptitionById(@Param("competitionId") int competitionId);

    //ɾ���ŶӾ�����Ϣͨ��achievementsId
    public int deleteCompitionByAchievementsId(@Param("achievementsId") int achievementsId);
}
