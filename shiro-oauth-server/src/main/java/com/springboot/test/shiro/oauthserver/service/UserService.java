package com.springboot.test.shiro.oauthserver.service;

import com.springboot.test.shiro.oauthserver.dao.UserMapper;
import com.springboot.test.shiro.oauthserver.entity.User;
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
     * 根据用户名 查询用户
     * @param username
     * @return
     */
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
