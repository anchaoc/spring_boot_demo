package com.ac.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 * @author anchao
 * @date 2020/1/7 14:12
 */
@Configuration
public class FilterConfig {
    /**
     * 加入到容器
     */
    @Bean
    public FilterRegistrationBean<UserFilter> testFilterRegistration() {
        FilterRegistrationBean<UserFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new UserFilter());
        //过滤所有请求
        registration.addUrlPatterns("/*");
        registration.setName("myFilter");
        registration.setOrder(1);
        return registration;

    }

}
