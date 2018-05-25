package com.springboot.test.shiro.modules.user.dao.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangsaichao
 * @date: 2018/5/10
 * @description: 角色
 */
public class Role {

    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色标识程序中判断使用,如"admin"
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;

    /**
     * 是否可用0可用  1不可用
     */
    private String available;

    /**
     * 某个角色对应的所有用户
     */
    private Set<User> users = new HashSet<>();

    /**
     * 某个角色对应的所有权限
     */
    private Set<Permission> permissions = new HashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available='" + available + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
