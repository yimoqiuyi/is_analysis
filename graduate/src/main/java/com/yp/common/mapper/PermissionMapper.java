package com.yp.common.mapper;

import com.yp.common.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//Ȩ�����ò���
public interface PermissionMapper {

    //ѡ�񵥸�Ȩ��
    public Permission selectOnePermissionById(@Param("id") int id);

    //ѡ��Ȩ��
    public List<Permission> selectAllPermission();

    //��ҳ�鿴Ȩ��
    public List<Permission> selectPermissionByLimit(@Param("page") int page, @Param("limit") int limit);

    //ͨ���û�idѡ��Ȩ��
    public List<Permission> selctAllPermissionByUserId(@Param("userId") int userId);

    //¼��Ȩ������
    public boolean insertPermission(Permission permission);

    //�޸�Ȩ��
    public boolean updatePermission(Permission permission);

    //ɾ��Ȩ������
    public int delectOnePermission(@Param("id") int id);

    //ͨ��roleѡ��permission
    public List<Permission> selectAllPermissionByRoleId(@Param("id") int id);
}
