package com.yp.common.mapper;

import com.yp.common.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//�û�����
public interface UserMapper {

    //�����û����鿴�û�
    public User selectOneUserByName(@Param("userName") String userName);

    //ͨ���û������鿴�û�
    public User selectOneUserById(@Param("userId") int userId);

    //���ݹ�λ�����ѯ�û�
    public User seletcOneUserByworkId(@Param("workId") int workId);

    //�鿴���е��û�
    public List<User> selectAllUser(@Param("page") int page, @Param("limit") int limit);

    //��ҳ��ѯ�û�
    public List<User> selectUserBygrouIdAndPage(@Param(value = "groupId") int groupId, @Param("page") int page, @Param("limit") int limit);

    //�����Ŷ������ѯ�û�
    public List<User> selectGroupBygroupId(int groupId);   //�����ŶӸ�����

    //�����Ŷ�����鿴�û�
    public List<User> selectAllUserBygroupId(int groupId);

    //�ù�״̬��ȡ�û�
    public List<User> selectAllUserBystate(@Param("state") int state);

    //ͨ��groupId���û�״̬��ȡ�û�
    public List<User> selectAllUserBystateAndgroupId(@Param("state") int state, @Param(value = "groupId") int groupId);

    //ͨ��subParkId��ѯ�û�
    public List<User> selectAllUserBySubParkId(int subParkId);

    //��ȡ���е���Ա
    public List<User> selectAllUsers();

    //ģ����ѯ�û�
    public List<User> selectUserByCondition(@Param("map") Map<String, Object> map);

    //¼���û�
    public int insertOneUser(User user);

    //�޸��û�
    public int updateOneUser(User user);

    //ɾ���û�
    public int deleteOneUserById(@Param("userId") int userId);

    //�����û�
    public List<User> selectUserByAttendanceId(@Param("attendanceId") int attendanceId);

    //ͨ����ɫId�����û�
    public List<User> selectUserByroleId(@Param("roleId") int roleId);

    //ͨ������sId�鿴�û�
    public List<User> selectUserBysId(@Param("sId") int sId);

    //ͨ����԰��id�鿴������
    public List<User> selectUserbygeneralParkId(@Param("generalParkId") int generalParkId);

}
