package com.yp.common.pojo;


import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private int userId;
    private String userName; //�û�
    private String userPwd; //����
    private String joinTime;  //���빫˾ʱ��
    private String awayTime;  //�뿪��˾ʱ��
    private String sex;        //�Ա�
    private String age;       //����
    private String phone;        //�绰
    private String cardNumber;  //���֤��
    private String email;     //�ʼ�
    private String address;   //��ס��ַ
    private int sanitationScore;    //��������÷�
    private int attendanceScore;    //��������÷�
    private String workRatio;       //��λ������
    private String workSanitation;//��λ����״��
    private int state;         //�ϰ�״̬
    private int workId;    //��λ���
    private int groupId;     //�Ŷ����
    private int subParkId;  //��԰�����
    private String salt;//��
    private WorkPosition workPosition=null; //�û��빤λ��Ӧ��ϵ
    private List<Role> roleList;  // �û����ɫ��Ӧ��ϵ
   private List<Sanitation>  sanitationList;
   private List<Attendance>  attendanceList;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", joinTime='" + joinTime + '\'' +
                ", awayTime='" + awayTime + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", sanitationScore=" + sanitationScore +
                ", attendanceScore=" + attendanceScore +
                ", workRatio='" + workRatio + '\'' +
                ", workSanitation='" + workSanitation + '\'' +
                ", state=" + state +
                ", workId=" + workId +
                ", groupId=" + groupId +
                ", subParkId=" + subParkId +
                ", salt='" + salt + '\'' +
                ", workPosition=" + workPosition +
                ", roleList=" + roleList +
                ", sanitationList=" + sanitationList +
                ", attendanceList=" + attendanceList +
                '}';
    }

    public int getSubParkId() {
        return subParkId;
    }

    public void setSubParkId(int subParkId) {
        this.subParkId = subParkId;
    }

    public String getWorkSanitation() {
         return workSanitation;
    }

    public void setWorkSanitation(String workSanitation) {
        if(getSanitationScore()==100){
            this.workSanitation = "100%";
        }
        else {
            int k = getSanitationScore() % 100;
            this.workSanitation = (String.valueOf(k)+"%");
        }
     }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialsSalt() {
        return userName + salt;
    }


    public List<Sanitation> getSanitationList() {
        return sanitationList;
    }

    public void setSanitationList(List<Sanitation> sanitationList) {
        this.sanitationList = sanitationList;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public WorkPosition getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(WorkPosition workPosition) {
        this.workPosition = workPosition;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getAwayTime() {
        return awayTime;
    }

    public void setAwayTime(String awayTime) {
        this.awayTime = awayTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSanitationScore() {
        return sanitationScore;
    }

    public void setSanitationScore(int sanitationScore) {
        this.sanitationScore = sanitationScore;
    }

    public int getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(int attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public String getWorkRatio() {
        return workRatio;
    }

    public void setWorkRatio(String workRatio) {
        if(getAttendanceScore()==100){
            this.workRatio ="100%";
        }else {
            int k = getAttendanceScore() % 100;
            this.workRatio = (String.valueOf(k)+"%");
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
