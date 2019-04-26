package com.yp.common.service;

import com.yp.common.pojo.Achievements;
import com.yp.common.pojo.AchievementsNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AchievementsNumberService {
    public List<AchievementsNumber> getAllAchievementsNumber();//��ȡ�����Ŷӵĳɹ���ʾ

    public AchievementsNumber selectOneAchievementsNumber(@Param("groupId") int groupId);//ͨ���Ŷ�idѡ���Ŷӳɹ�

    public boolean updateOneAchievementsNumber(AchievementsNumber achievementsNumber);
    //�����Ŷ�id���гɹ���¼��
    public boolean insertAchievementsNumber(AchievementsNumber achievementsNumber);

    public int delectOneAchievementsNumber(@Param("groupId") int groupId);//�����Ŷ�idɾ���Ŷӳɹ�

    public int delectOneAchievementsNumberById(@Param("achievementsNumId")int achievementsNumId);//ɾ�������Ŷӳɹ���
}
