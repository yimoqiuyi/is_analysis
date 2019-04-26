package com.yp.common.mapper;

import com.yp.common.pojo.Group;
import com.yp.common.pojo.Sanitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//�ŶӲ���
public interface GroupMapper {

    //ѡ���ŶӸ����Ŷ�id
    public Group selectOneGroupById(int groupId);

    //���ݸ�����ѡ���Ŷ�
    public Group selectOneGroupByuserId(@Param("userId") int userId);

    //���ݷ�԰��idѡ���Ŷ�
    public List<Group> selectAllGroupBysubParkId(int subParkId);

    //ѡ�������Ŷ�
    public List<Group> selectAllGroup();

    //������԰״̬�鿴�Ŷ�
    public List<Group> selectAllGroupByState(@Param("state") int state);

    //������԰״̬���԰��idѡ��鿴�Ŷ�
    public List<Group> selectAllGroupBystateAndsubParkId(@Param("state") int state, @Param("subParkId") int subParkId);
    //ģ����ѯ
    public List<Group> selectGroupByCondition(@Param("map")Map<String,Object> map);
    //¼���Ŷ�
    public boolean insertOneGroup(Group group);

    //�޸��Ŷ�
    public boolean updateOneGroup(Group group);

    //����groupIDɾ���Ŷ�
    public int delectOneGroupByid(int groupId);

    //���ݷ��������ҳ��ѯ
    public List<Group> selectGroupByLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

}
