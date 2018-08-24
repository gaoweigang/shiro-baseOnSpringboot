package com.gwg.shiro.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *
 * 我们的Application类上使用的第一个注解是@RestController。这被称为一个构造型注解。
 * 它为阅读代码的人们提供建议。对于Spring,该类扮演了一个特殊角色。在本示例中，我们的
 * 类是一个web @Controller,所以当处理进来的web请求时，Spring会询问他.
 *
 * @SpringBootApplication 等价于 @Configuration, @EnableAntoConfiguration 和 @ComponentScan。
 *
 */
@SpringBootApplication//启动了自动配置，如果配置文件中有数据库的配置，则会自动创建dataSource
@MapperScan("com.gwg.shiro.web.mapper")
public class Application{

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception{
        LOGGER.info("启动服务开始 start.......");
        SpringApplication.run(Application.class, args);
    }

}
