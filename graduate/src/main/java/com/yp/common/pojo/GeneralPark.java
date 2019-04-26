package com.yp.common.pojo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeneralPark  implements Serializable {
    private int generalParkId;     //��԰������
    private String generalName;//��԰������
    private String generalIntroduce;//��԰������
    private String generalPicture;//��԰��ƽ��ͼ
    private String generalPhone;//��԰���绰
    private int userId;//��԰��������
    private List<SubPark> subParkList;//��԰������
    private List<Room> roomList; //������
    private List<Building> buildingList; //�����
    private List<Patent> patentList; //��԰�������ר������
    private List<Software> softwareList; //��������
    private List<Paper> paperList;  //���ļ���
    private List<Competition> competitionList; //��������
    private List<Admissioncontract> admissioncontractList;//��԰��ͬ����
    private List<Managementagreement> managementagreementList;//�ʲ�������
    private List<Responsibilityagreement> responsibilityagreementList;//����Э�鼯��
    private  List<User> userList;//��԰�������˼���
    private List<Performance> performanceList;//��Ч����

    @Override
    public String toString() {
        return "GeneralPark{" +
                "generalParkId=" + generalParkId +
                ", generalName='" + generalName + '\'' +
                ", generalIntroduce='" + generalIntroduce + '\'' +
                ", generalPicture='" + generalPicture + '\'' +
                ", generalPhone='" + generalPhone + '\'' +
                ", userId=" + userId +
                ", subParkList=" + subParkList +
                ", roomList=" + roomList +
                ", buildingList=" + buildingList +
                ", patentList=" + patentList +
                ", softwareList=" + softwareList +
                ", paperList=" + paperList +
                ", competitionList=" + competitionList +
                ", admissioncontractList=" + admissioncontractList +
                ", managementagreementList=" + managementagreementList +
                ", responsibilityagreementList=" + responsibilityagreementList +
                ", userList=" + userList +
                ", performanceList=" + performanceList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<Performance> performanceList) {
        this.performanceList = performanceList;
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

    public List<SubPark> getSubParkList() {
        return subParkList;
    }

    public void setSubParkList(List<SubPark> subParkList) {
        this.subParkList = subParkList;
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

    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public String getGeneralName() {
        return generalName;
    }

    public void setGeneralName(String generalName) {
        this.generalName = generalName;
    }

    public String getGeneralIntroduce() {
        return generalIntroduce;
    }

    public void setGeneralIntroduce(String generalIntroduce) {
        this.generalIntroduce = generalIntroduce;
    }

    public String getGeneralPicture() {
        return generalPicture;
    }

    public void setGeneralPicture(String generalPicture) {
        this.generalPicture = generalPicture;
    }

    public String getGeneralPhone() {
        return generalPhone;
    }

    public void setGeneralPhone(String generalPhone) {
        this.generalPhone = generalPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
