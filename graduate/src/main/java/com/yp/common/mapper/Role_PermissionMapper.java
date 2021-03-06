package com.yp.common.mapper;

import com.yp.common.pojo.Role_Permission;
import org.apache.ibatis.annotations.Param;

public interface Role_PermissionMapper {

    public Role_Permission selecteOneRole_PermissionById(@Param("id") int id);

    public boolean insertOneRole_Permission(Role_Permission role_permission);

    public int deleteOneRole_Permission(@Param("id") int id);

    //根据角色id权限id删除
    public int deleteRole_PermissionByroleIdAndId(@Param("roleId") int roleId,@Param("id") int id);
}
