package com.yp.common.mapper;

import com.yp.common.pojo.Achievements;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//�ɹ����ñ�
public interface AchievementsMapper {

    //��ȡ���гɹ�������
    public List<Achievements> getAllachievements();

    //���³ɹ�����
    public boolean updateAchievement(Achievements achievements);

    //��ӳɹ���
    public boolean insertAchievements(Achievements achievements);

    //���ݳɹ�id��ѯ�ɹ�
    public int delectAchievements(@Param("achievementsId") int achievementsId);

    //����id��ѯ�ɹ�
    public Achievements selectAchievementsByachievementsId(@Param("achievementsId") int achievementsId);

    //����competitionId��ѯ�ɹ�
    public Achievements selectAchievementsBycompetitionId(@Param("competitionId") int competitionId);

    //����PaperId��ѯ�ɹ�
    public Achievements selectAchievementsBypaperId(@Param("paperId") int paperId);

    //����patentId��ѯ�ɹ�
    public Achievements selectAchievementsBypatentId(@Param("patentId") int patentId);

    //�������id��ѯ�ɹ�
    public Achievements selectAchievementsBysoftId(@Param("softId") int softId);

    //�������ֲ�ѯ�ɹ�
    public Achievements selectAchievementsByName(@Param("achievementsName") String achievementsName);

}
