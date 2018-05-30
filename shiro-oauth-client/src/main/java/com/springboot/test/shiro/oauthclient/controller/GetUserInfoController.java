package com.springboot.test.shiro.oauthclient.controller;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wangsaichao
 * @date: 2018/5/29
 * @description: 通过access_token获取用户信息
 */
@Controller
@RequestMapping("/oauth-client")
public class GetUserInfoController {

    @Value("${userInfoUrl}")
    private String userInfoUrl;


    //接受服务端传回来的access token，由此token去请求服务端的资源（用户信息等）
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String accessToken(String accessToken) {

        OAuthClient oAuthClient =new OAuthClient(new URLConnectionClient());
        try {
            OAuthClientRequest userInfoRequest =new OAuthBearerClientRequest(userInfoUrl)
                    .setAccessToken(accessToken).buildQueryMessage();

            OAuthResourceResponse resourceResponse =oAuthClient.resource(userInfoRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
            String body = resourceResponse.getBody();
            System.out.println("==> 客户端通过accessToken："+accessToken +"  从服务端获取用户信息为："+body);
            return body;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
