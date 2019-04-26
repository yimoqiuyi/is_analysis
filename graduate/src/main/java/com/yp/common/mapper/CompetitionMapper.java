package com.yp.common.mapper;

import com.yp.common.pojo.Competition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//�����Ĳ���
public interface CompetitionMapper {
    //���ݾ���id�鿴����
    public Competition selectOneCompetitionBycompetitionId(@Param("competitionId") int competitionId);

    //�����Ŷ�id�鿴�ŶӾ�������
    public int selctCompetitionsBygroupId(int groupId);

    //�����Ŷ�id�鿴�ŶӾ�������
    public List<Competition> selectAllCompetitionBygroupId(int groupId);

    //�鿴���о���
    public List<Competition> selectAllCompetition();

    //���ݷ�԰���鿴���о���
    public List<Competition> selectAllCompetitionBysubParkId(int subParkId);

    //������԰������鿴���о���
    public List<Competition> selectAllCompetitionBygeneralParkId(@Param("generalParkId") int generalParkId);

    //�����Ŷ�id�Լ��ļ�״̬��ѯ
    public List<Competition> selectCompetionByGroupIdAndcompetitionState(@Param("groupId") int groupId, @Param("competitionState") int competitionState);

    //ͨ��groupId��ҳ��ѯ
    public List<Competition> selectCompetitionByGroupIdandLimit(@Param("map") Map<String, Object> map);

    //��ҳ��ѯ
    public List<Competition> selectCompetitionByLimit(@Param("map") Map<String, Object> map);

    //¼�뾺��
    public boolean insertCompetition(Competition competition);

    //����id�޸ľ���
    public boolean updateCompetition(Competition competition);

    //ɾ���ŶӾ�����Ϣ
    public int deleteComptitionById(@Param("competitionId") int competitionId);

    //ɾ���ŶӾ�����Ϣͨ��achievementsId
    public int deleteCompitionByAchievementsId(@Param("achievementsId") int achievementsId);
}
