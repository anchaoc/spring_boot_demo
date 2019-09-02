package com.ac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 1.开启异步
 * 2.开启事务管理
 * 3.开启定时
 * 4.mybatis扫描dao
 * 5.swagger2 api
 * 6. aop代理
 * @author anchao
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
@EnableSwagger2
@MapperScan("com.ac.dao")
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
