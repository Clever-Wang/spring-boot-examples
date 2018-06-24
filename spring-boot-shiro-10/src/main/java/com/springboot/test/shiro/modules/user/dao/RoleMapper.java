package com.springboot.test.shiro.modules.user.dao;

import com.springboot.test.shiro.modules.user.dao.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author: WangSaiChao
 * @date: 2018/5/12
 * @description: 角色操作dao层
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据用户id查询角色信息
     * @param uid
     * @return
     */
    Set<Role> findRolesByUserId(@Param("uid") Integer uid);

    /**
     * 给admin用户添加 userInfo:del 权限
     * @param roleId
     * @param permissionId
     * @return
     */
    int addPermission(@Param("roleId") int roleId,@Param("permissionId") int permissionId);

    /**
     * 删除admin用户 userInfo:del 权限
     * @param roleId
     * @param permissionId
     * @return
     */
    int delPermission(@Param("roleId") int roleId,@Param("permissionId") int permissionId);
}
