package com.yp.common.pojo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubPark implements Serializable {
    private int subParkId;//��԰������
    private String subParkName;//��԰������
    private String subParkIntroduce;//��԰������
    private String subParkPhone;//��԰����ϵ�绰
    private String subParkPicture;//��԰��ƽ��ͼ
    private int generalParkId;//��԰�����
    private int userId;//�û����
    private List<User> userList;//��԰�������˼���
    private ArrayList<Building> Buildings;  //������
    private List<Group> groupList;//�ŶӼ���
    private List<Room> roomList; //���伯��
    private List<Building> buildingList;  //������
    private List<Patent> patentList; //��԰�������ר������
    private List<Software> softwareList; //��������
    private List<Paper> paperList;  //���ļ���
    private List<Competition> competitionList; //��������
    private List<Admissioncontract> admissioncontractList;//��԰��ͬ����
    private List<Managementagreement> managementagreementList;//�ʲ�������
    private List<Responsibilityagreement> responsibilityagreementList;//����Э�鼯��
    private List<Performance> performanceList;//��Ч����

    @Override
    public String toString() {
        return "SubPark{" +
                "subParkId=" + subParkId +
                ", subParkName='" + subParkName + '\'' +
                ", subParkIntroduce='" + subParkIntroduce + '\'' +
                ", subParkPhone='" + subParkPhone + '\'' +
                ", subParkPicture='" + subParkPicture + '\'' +
                ", generalParkId=" + generalParkId +
                ", userId=" + userId +
                ", userList=" + userList +
                ", Buildings=" + Buildings +
                ", groupList=" + groupList +
                ", roomList=" + roomList +
                ", buildingList=" + buildingList +
                ", patentList=" + patentList +
                ", softwareList=" + softwareList +
                ", paperList=" + paperList +
                ", competitionList=" + competitionList +
                ", admissioncontractList=" + admissioncontractList +
                ", managementagreementList=" + managementagreementList +
                ", responsibilityagreementList=" + responsibilityagreementList +
                ", performanceList=" + performanceList +
                '}';
    }

    public List<Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<Performance> performanceList) {
        this.performanceList = performanceList;
    }

    public String getSubParkPicture() {
        return subParkPicture;
    }

    public void setSubParkPicture(String subParkPicture) {
        this.subParkPicture = subParkPicture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public String getSubParkName() {
        return subParkName;
    }

    public void setSubParkName(String subParkName) {
        this.subParkName = subParkName;
    }

    public String getSubParkIntroduce() {
        return subParkIntroduce;
    }

    public void setSubParkIntroduce(String subParkIntroduce) {
        this.subParkIntroduce = subParkIntroduce;
    }

    public String getSubParkPhone() {
        return subParkPhone;
    }

    public void setSubParkPhone(String subParkPhone) {
        this.subParkPhone = subParkPhone;
    }



    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Building> getBuildings() {
        return Buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        Buildings = buildings;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public List<Patent> getPatentList() {
        return patentList;
    }

    public void setPatentList(List<Patent> patentList) {
        this.patentList = patentList;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setSoftwareList(List<Software> softwareList) {
        this.softwareList = softwareList;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }

    public void setCompetitionList(List<Competition> competitionList) {
        this.competitionList = competitionList;
    }

    public List<Admissioncontract> getAdmissioncontractList() {
        return admissioncontractList;
    }

    public void setAdmissioncontractList(List<Admissioncontract> admissioncontractList) {
        this.admissioncontractList = admissioncontractList;
    }

    public List<Managementagreement> getManagementagreementList() {
        return managementagreementList;
    }

    public void setManagementagreementList(List<Managementagreement> managementagreementList) {
        this.managementagreementList = managementagreementList;
    }

    public List<Responsibilityagreement> getResponsibilityagreementList() {
        return responsibilityagreementList;
    }

    public void setResponsibilityagreementList(List<Responsibilityagreement> responsibilityagreementList) {
        this.responsibilityagreementList = responsibilityagreementList;
    }
}
