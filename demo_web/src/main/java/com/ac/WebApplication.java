package com.ac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 1.开启异步
 * 2.开启事务管理
 * 3.开启定时
 * 4.mybatis扫描dao
 * 5.swagger2 api
 * 6. aop代理
 * 7.servlet3.0
 * @author anchao
 */
@SpringBootApplication
//@EnableAspectJAutoProxy
//@EnableAsync
@EnableTransactionManagement
//@EnableScheduling
//@EnableHello
@MapperScan("com.ac.dao")
//@ServletComponentScan(basePackages = "com.ac.servlet3")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
