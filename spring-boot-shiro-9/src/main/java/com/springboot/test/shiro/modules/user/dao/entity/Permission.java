package com.springboot.test.shiro.modules.user.dao.entity;

import com.springboot.test.shiro.modules.user.dao.entity.Role;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangsaichao
 * @date: 2018/5/10
 * @description: 权限实体
 */
public class Permission {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 父编号,本权限可能是该父编号权限的子权限
     */
    private Integer parent_id;

    /**
     * 父编号列表
     */
    private String parent_ids;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 资源类型，[menu|button]
     */
    private String resource_type;

    /**
     * 资源路径 如：/userinfo/list
     */
    private String url;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 是否可用0可用  1不可用
     */
    private String available;

    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", parent_ids='" + parent_ids + '\'' +
                ", permission='" + permission + '\'' +
                ", resource_type='" + resource_type + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", available='" + available + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(String parent_ids) {
        this.parent_ids = parent_ids;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
