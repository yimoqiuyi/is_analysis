package com.yp.common.pojo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Serializable {
    private int buildId;
    private String floorPicture;//¥��ƽ��ͼ
    private int roomNumber;//��������
    private String buildStation;//������λ��
    private int subParkId;//��԰�����
    private int generalParkId;//��԰�����
    private List<Room> roomList;

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    public String getFloorPicture() {
        return floorPicture;
    }

    public void setFloorPicture(String floorPicture) {
        this.floorPicture = floorPicture;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuildStation() {
        return buildStation;
    }

    public void setBuildStation(String buildStation) {
        this.buildStation = buildStation;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildId=" + buildId +
                ", floorPicture='" + floorPicture + '\'' +
                ", roomNumber=" + roomNumber +
                ", buildStation='" + buildStation + '\'' +
                ", subParkId=" + subParkId +
                ", generalParkId=" + generalParkId +
                ", roomList=" + roomList +
                ", Rooms=" + Rooms +
                '}';
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public int getGeneralParkId() {
        return generalParkId;
    }

    public void setGeneralParkId(int generalParkId) {
        this.generalParkId = generalParkId;
    }

    public ArrayList<Room> getRooms() {
        return Rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        Rooms = rooms;
    }

    private ArrayList<Room> Rooms;   //���伯��




}
