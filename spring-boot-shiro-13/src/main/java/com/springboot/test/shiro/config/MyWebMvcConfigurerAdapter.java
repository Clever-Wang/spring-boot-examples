package com.springboot.test.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.resource.ResourceUrlProviderExposingInterceptor;

/**
 * @author: wangsaichao
 * @date: 2018/4/16
 * @description: SpringMVC的配置文件
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Bean
    public ResourceUrlProvider resourceUrlProvider(){
        ResourceUrlProvider resourceUrlProvider = new ResourceUrlProvider();
        return resourceUrlProvider;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new ResourceUrlProviderExposingInterceptor(resourceUrlProvider())).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 设置自己的path匹配规则
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        // 常用的两种
        // 匹配结尾 / :会识别 url 的最后一个字符是否为 /
        // 设置为true: localhost:8080/test 与 localhost:8080/test/ 等价
        configurer.setUseTrailingSlashMatch(true);
        // 匹配后缀名：会识别 xx.* 后缀的内容
        // 设置为true: localhost:8080/test 与 localhost:8080/test.jsp 等价
        configurer.setUseSuffixPatternMatch(true);
    }


    /**
     * 静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
