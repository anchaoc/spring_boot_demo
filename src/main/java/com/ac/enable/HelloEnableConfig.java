package com.ac.enable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义enable模块配置
 * @author anchao
 * @date 2019/10/9 14:05
 */
@Slf4j
@Configuration
public class HelloEnableConfig {

    @Bean("helloEnable")
    public String helloEnable(){
        log.info("自定义enable模块配置: hello Enable");
        return "hello Enable";
    }
}
