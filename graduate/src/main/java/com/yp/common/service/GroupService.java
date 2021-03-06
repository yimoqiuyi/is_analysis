package com.yp.common.service;

import com.yp.common.pojo.Group;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GroupService {
    //选择团队根据团队id
    public Group selectOneGroupById(@Param("groupId") int groupId);

    //根据负责人选择团队
    public Group selectOneGroupByuserId(@Param("userId") int userId);

    //根据分园区id选择团队
    public List<Group> selectAllGroupBysubParkId(@Param("subParkId") int subParkId);

    //选择所有团队
    public List<Group> selectAllGroup();

    //根据入园状态查看团队
    public List<Group> selectAllGroupByState(@Param("state") int state);

    //根据入园状态与分园区id选择查看团队
    public List<Group> selectAllGroupBystateAndsubParkId(@Param("state") int state, @Param("subParkId") int subParkId);
 //模糊查询
    public List<Group> selectGroupByCondition(Map<String, Object> map);

    //录入团队
    public boolean insertOneGroup(Group group);

    //修改团队
    public boolean updateOneGroup(Group group);

    //根据groupID删除团队
    public int delectOneGroupByid(@Param("groupId") int groupId);

    //根据分区外键分页查询
    public List<Group> selectGroupByLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);


}
