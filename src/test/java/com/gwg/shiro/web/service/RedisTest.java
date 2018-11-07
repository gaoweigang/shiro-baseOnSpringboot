package com.gwg.shiro.web.service;

import com.alibaba.fastjson.JSON;
import com.gwg.shiro.web.config.shiro.ShiroCache;
import org.apache.ibatis.javassist.tools.web.Webserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
        //ShiroCache cache = new ShiroCache<>(redisTemplate);
        //cache.values();
        redisTemplate.opsForValue().set("test-shiro-session:1234", "gaoweigang");

        Set set = redisTemplate.keys("est-shiro-session:1234");
        System.out.println(JSON.toJSONString(set));
        Object object = redisTemplate.opsForValue().get("test-shiro-session:1234");
        System.out.println(JSON.toJSON(object));
    }


}
