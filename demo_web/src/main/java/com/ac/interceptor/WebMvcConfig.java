package com.ac.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author anchao
 * @date 2020/1/7 14:25
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //针对所有请求进行拦截
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**");
    }

}
