package com.yp.common.pojo;

import java.io.Serializable;

//���óɹ�����
public class Achievements implements Serializable {
    private int achievementsId;
    private String achievementsName;//�ɹ�����
    private String achievementsIntroduction;//�ɹ����
    private String achievementsCategory;//�ɹ����
    private int achievementsScore;//����Ӧ����

    public int getAchievementsId() {
        return achievementsId;
    }

    public void setAchievementsId(int achievementsId) {
        this.achievementsId = achievementsId;
    }

    public String getAchievementsName() {
        return achievementsName;
    }

    public void setAchievementsName(String achievementsName) {
        this.achievementsName = achievementsName;
    }

    public String getAchievementsIntroduction() {
        return achievementsIntroduction;
    }

    public void setAchievementsIntroduction(String achievementsIntroduction) {
        this.achievementsIntroduction = achievementsIntroduction;
    }

    public String getAchievementsCategory() {
        return achievementsCategory;
    }

    public void setAchievementsCategory(String achievementsCategory) {
        this.achievementsCategory = achievementsCategory;
    }

    public int getAchievementsScore() {
        return achievementsScore;
    }

    public void setAchievementsScore(int achievementsScore) {
        this.achievementsScore = achievementsScore;
    }
}
