package com.springboot.test.shiro.oauthclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wangsaichao
 * @date: 2018/4/16
 * @description: 授权中心启动类
 */
@SpringBootApplication
//@ImportResource("classpath:spring/*.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
