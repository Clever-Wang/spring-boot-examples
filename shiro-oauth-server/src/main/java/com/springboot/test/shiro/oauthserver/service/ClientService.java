package com.springboot.test.shiro.oauthserver.service;

import com.springboot.test.shiro.oauthserver.dao.ClientMapper;
import com.springboot.test.shiro.oauthserver.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: wangsaichao
 * @date: 2018/5/27
 * @description:
 */
@Service("clientService")
public class ClientService {

    @Autowired
    private ClientMapper clientMapper;

    public Client findByClientId(String clientId) {
        return clientMapper.findByClientId(clientId);
    }

    public Client findByClientSecret(String clientSecret) {
        return clientMapper.findByClientSecret(clientSecret);
    }
}
