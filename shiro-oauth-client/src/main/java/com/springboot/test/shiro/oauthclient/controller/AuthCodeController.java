package com.springboot.test.shiro.oauthclient.controller;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wangsaichao
 * @date: 2018/5/29
 * @description:
 * 1、拼接url然后访问，获取code
 * 2、服务端检查成功,然后会回调到 另一个接口 /oauth-client/callbackCode
 */
@Controller
@RequestMapping("/oauth-client")
public class AuthCodeController {

    @Value("${clientId}")
    private String clientId;

    @Value("${authorizeUrl}")
    private String authorizeUrl;

    @Value("${redirectUrl}")
    private String redirectUrl;

    @Value("${response_type}")
    private String response_type;

    @RequestMapping("/getCode")
    public String getCode() throws OAuthProblemException {
        String requestUrl = null;
        try {

            //配置请求参数，构建oauthd的请求。设置请求服务地址（authorizeUrl）、clientId、response_type、redirectUrl
            OAuthClientRequest accessTokenRequest = OAuthClientRequest.authorizationLocation(authorizeUrl)
                    .setResponseType(response_type)
                    .setClientId(clientId)
                    .setRedirectURI(redirectUrl)
                    .buildQueryMessage();

            requestUrl = accessTokenRequest.getLocationUri();
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }

        System.out.println("==> 客户端重定向到服务端获取auth_code： "+requestUrl);
        return "redirect:"+requestUrl ;
    }

}
