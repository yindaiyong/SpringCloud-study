package com.ydy.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy  //该注解把该模块注册成网关层
@SpringBootApplication
public class YdyZuulApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(YdyZuulApplication.class);

    public static void main(String[] args) {
        LOGGER.info("网管服务启动...");
        SpringApplication.run(YdyZuulApplication.class, args);
    }

}
