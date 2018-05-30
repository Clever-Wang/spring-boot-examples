package com.springboot.test.shiro.oauthserver.dao;

import com.springboot.test.shiro.oauthserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

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
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);
}
