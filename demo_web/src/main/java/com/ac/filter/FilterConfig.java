package com.ac.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anchao
 * @date 2020/1/7 14:12
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<UserFilter> testFilterRegistration() {
        FilterRegistrationBean<UserFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new UserFilter());
        registration.addUrlPatterns("/*");
        //registration.addInitParameter("paramName", "paramValue");//添加初始值
        registration.setName("myFilter");
        registration.setOrder(1);
        return registration;
    }

}
