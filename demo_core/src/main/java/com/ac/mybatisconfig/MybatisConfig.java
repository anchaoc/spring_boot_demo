package com.ac.mybatisconfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author anchao
 * @date 2020/1/20 18:30
 */
@Configuration
@MapperScan(basePackages = {"com.ac.dao"})
public class MybatisConfig{
}
