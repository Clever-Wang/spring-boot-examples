package com.springboot.test.shiro.modules.user.dao;

import com.springboot.test.shiro.modules.user.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: WangSaiChao
 * @date: 2018/5/9
 * @description: 用户操作dao层
 */
@Mapper
public interface UserMapper {

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据用户名删除用户信息
     * @param username
     * @return
     */
    int del(@Param("username") String username);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update(User user);
}
