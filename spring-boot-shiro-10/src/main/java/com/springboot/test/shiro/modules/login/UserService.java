package com.springboot.test.shiro.modules.login;

import com.springboot.test.shiro.modules.user.dao.UserMapper;
import com.springboot.test.shiro.modules.user.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wangsaichao
 * @date: 2018/5/12
 * @description:
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     * @param user
     */
    public int insert(User user) {

       return userMapper.insert(user);

    }

    /**
     * 根据用户名删除用户信息
     * @param username
     */
    public int del(String username) {
       return userMapper.del(username);
    }
}
