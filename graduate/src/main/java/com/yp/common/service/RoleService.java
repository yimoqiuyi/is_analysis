package com.yp.common.service;

import com.yp.common.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    //�������ֲ��ҽ�ɫ
    public Role selectRoleByName(@Param("name") String name);

    //��ɫѡ�񣬸��ݽ�ɫidselectRoleByUserId
    public Role selectOneRoleById(@Param(value = "id") int id);

    //��ɫѡ�񣬸���idѡ���ɫ
    public List<Role> selectAllRoleById(@Param("id") int id);

    //��ҳ�鿴Ȩ���б�
    public List<Role> selectRoleByLimit(@Param("page") int page, @Param("limit") int limit);

    //ѡ�����н�ɫ
    public List<Role> selectAllRole();

    //��ɫѡ�񣬸����û�Idѡ���ɫ
    public List<Role> selectRoleByUserId(@Param(value = "userId") int userId);

    //��ɫ¼��
    public boolean insertOneRole(Role role);

    //��ɫ�޸�
    public boolean updateOneRole(Role role);

    //��ɫɾ��
    public int delectOneRoleById(@Param(value = "id") int id);
}
