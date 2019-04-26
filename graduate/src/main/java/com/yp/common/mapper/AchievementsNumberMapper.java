package com.yp.common.mapper;

import com.yp.common.pojo.AchievementsNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//�Ŷӳɹ�������Ĳ���
public interface AchievementsNumberMapper {

    public List<AchievementsNumber> getAllAchievementsNumber();//��ȡ�����Ŷӵĳɹ���ʾ

    public AchievementsNumber selectOneAchievementsNumber( int groupId);//ͨ���Ŷ�idѡ���Ŷӳɹ�

    public boolean updateOneAchievementsNumber(AchievementsNumber achievementsNumber);
    //�����Ŷ�id���гɹ���¼��
    public boolean insertAchievementsNumber(AchievementsNumber achievementsNumber);

    public int delectOneAchievementsNumber(@Param("groupId") int groupId);//�����Ŷ�idɾ���Ŷӳɹ�

    public int delectOneAchievementsNumberById(@Param("achievementsNumId")int achievementsNumId);//ɾ�������Ŷӳɹ���
}
