package com.springboot.test.shiro.modules.user.dao;

import com.springboot.test.shiro.modules.user.dao.entity.Permission;
import com.springboot.test.shiro.modules.user.dao.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author: WangSaiChao
 * @date: 2018/5/12
 * @description: 权限操作dao层
 */
@Mapper
public interface PermissionMapper {

    /**
     * 根据角色查询用户权限
     * @param roles
     * @return
     */
    Set<Permission> findPermissionsByRoleId(@Param("roles") Set<Role> roles);
}
