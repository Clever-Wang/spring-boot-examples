package com.springboot.test.shiro.config;

import com.springboot.test.shiro.global.utils.SerializeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: wangsaichao
 * @date: 2017/11/23
 * @description: redis配置
 */
@Configuration
public class RedisConfig {

    /**
     * redis地址
     */
    @Value("${spring.redis.host}")
    private String host;

    /**
     * redis端口号
     */
    @Value("${spring.redis.port}")
    private Integer port;

    /**
     * redis密码
     */
    @Value("${spring.redis.password}")
    private String password;

    /**
     * JedisPoolConfig 连接池
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //最大空闲数
        jedisPoolConfig.setMaxIdle(300);
        //连接池的最大数据库连接数
        jedisPoolConfig.setMaxTotal(1000);
        //最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(1000);
        //逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTimeMillis(300000);
        //每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
        jedisPoolConfig.setNumTestsPerEvictionRun(10);
        //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
        //是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(true);
        //在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(true);
        return jedisPoolConfig;
    }

    /**
     * 配置工厂
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
        //连接池
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        //IP地址
        jedisConnectionFactory.setHostName(host);
        //端口号
        jedisConnectionFactory.setPort(port);
        //如果Redis设置有密码
        jedisConnectionFactory.setPassword(password);
        //客户端超时时间单位是毫秒
        jedisConnectionFactory.setTimeout(5000);
        return jedisConnectionFactory;
    }

    /**
     * shiro redis缓存使用的模板
     * 实例化 RedisTemplate 对象
     * @return
     */
    @Bean("shiroRedisTemplate")
    public RedisTemplate shiroRedisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new SerializeUtils());
        redisTemplate.setValueSerializer(new SerializeUtils());
        //开启事务
        //stringRedisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
