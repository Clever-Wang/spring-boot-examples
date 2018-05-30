package com.springboot.test.shiro.oauthserver.service;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wangsaichao
 * @date: 2018/5/27
 * @description:
 */
@Service("authorizeService")
public class AuthorizeService {

    private Cache cache;

    @Autowired
    private ClientService clientService;

    @Autowired
    public AuthorizeService(CacheManager ehCacheManager) {
        this.cache = ehCacheManager.getCache("code-cache");
    }


    /**
     * 根据客户端id 查询客户端是否存在
     * @param clientId
     * @return
     */
    public boolean checkClientId(String clientId) {
        return clientService.findByClientId(clientId) != null;
    }

    /**
     * 添加 auth code
     * @param authCode
     * @param username
     */
    public void addAuthCode(String authCode, String username) {
        cache.put(authCode, username);
    }

    /**
     * 检查客户端安全Key是否正确
     * @param clientSecret
     * @return
     */
    public boolean checkClientSecret(String clientSecret) {
        return clientService.findByClientSecret(clientSecret) != null;
    }

    /**
     * 检查authCode是否可用
     * @param authCode
     * @return
     */
    public boolean checkAuthCode(String authCode) {
        return cache.get(authCode) != null;
    }

    /**
     * 根据 authCode 获取用户名
     * @param authCode
     * @return
     */
    public String getUsernameByAuthCode(String authCode) {
        return (String)cache.get(authCode);
    }

    /**
     * 添加accessToken
     * @param accessToken
     * @param username
     */
    public void addAccessToken(String accessToken, String username) {
        cache.put(accessToken, username);
    }

    /**
     * access token 过期时间
     * @return
     */
    public long getExpireIn() {
        return 3600L;
    }

    /**
     * 检查 accessToken 是否可用
     * @param accessToken
     * @return
     */
    public boolean checkAccessToken(String accessToken) {
        return cache.get(accessToken) != null;
    }

    /**
     * 根据 accessToken 获取用户名
     * @param accessToken
     * @return
     */
    public String getUsernameByAccessToken(String accessToken) {
        return (String)cache.get(accessToken);
    }

}
