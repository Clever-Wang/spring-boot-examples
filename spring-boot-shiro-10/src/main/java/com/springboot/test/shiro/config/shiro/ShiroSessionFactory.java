package com.springboot.test.shiro.config.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.DefaultWebSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wangsaichao
 * @date: 2018/6/23
 * @description:
 */
public class ShiroSessionFactory implements SessionFactory {
    private static final Logger logger = LoggerFactory.getLogger(ShiroSessionFactory.class);

    @Override
    public Session createSession(SessionContext initData) {
        ShiroSession session = new ShiroSession();
        HttpServletRequest request = (HttpServletRequest)initData.get(DefaultWebSessionContext.class.getName() + ".SERVLET_REQUEST");
        session.setHost(getIpAddress(request));
        return session;
    }

    public static String getIpAddress(HttpServletRequest request) {
        String localIP = "127.0.0.1";
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
