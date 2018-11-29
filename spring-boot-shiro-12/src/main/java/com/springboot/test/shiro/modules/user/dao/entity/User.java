package com.springboot.test.shiro.modules.user.dao.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangsaichao
 * @date: 2018/5/11
 * @description: 用户信息
 */
public class User implements Serializable{

    /**
     * 用户id(主键 自增)
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String id_card_num;

    /**
     * 用户状态：0:正常状态,1：用户被锁定
     */
    private String state;

    /**
     * 用户所拥有的所有角色
     */
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", id_card_num='" + id_card_num + '\'' +
                ", state='" + state + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card_num() {
        return id_card_num;
    }

    public void setId_card_num(String id_card_num) {
        this.id_card_num = id_card_num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
