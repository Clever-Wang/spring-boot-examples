package com.springboot.test.shiro.oauthserver.dao;

import com.springboot.test.shiro.oauthserver.entity.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author: WangSaiChao
 * @date: 2018/5/27
 * @description: 客户端dao层
 */
@Mapper
public interface ClientMapper {

    /**
     * 根据clientId查询客户端信息
     * @param clientId
     * @return
     */
    Client findByClientId(@Param("clientId") String clientId);

    /**
     * 根据clientSecret查询客户端信息
     * @param clientSecret
     * @return
     */
    Client findByClientSecret(@Param("clientSecret") String clientSecret);
}
