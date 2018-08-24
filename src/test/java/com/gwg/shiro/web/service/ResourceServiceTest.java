package com.gwg.shiro.web.service;


import com.alibaba.fastjson.JSON;
import com.gwg.shiro.web.model.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceTest.class);

    @Autowired
    private ResourceService resourceService;


    @Test
    public void testQueryAllResources(){
        List<Resource> resourceList = resourceService.queryAllResources();

        logger.info("参数：{}， 结果：{}", null, JSON.toJSON(resourceList));
    }

    @Test
    public void testQueryCurrentUserMenu(){
        List<Resource> resourceList = resourceService.queryCurrentUserMenu("00000012");
        logger.info("参数：{}， 结果：{}", null, JSON.toJSON(resourceList));

    }
}
