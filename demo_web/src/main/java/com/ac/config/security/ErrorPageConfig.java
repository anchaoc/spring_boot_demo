package com.ac.config.security;

import com.google.common.collect.Sets;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.HashSet;

/**
 * @author anchao
 * @date 2020/1/21 12:58
 */
@Configuration
public class ErrorPageConfig {

    /**
     * sb2.0替代EmbeddedServletContainerConsumer
     * 错误异常跳转页
     */
    @Bean
    public WebServerFactoryCustomizer web() {
        WebServerFactoryCustomizer<ConfigurableWebServerFactory> web = new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                ErrorPage errorPage = new ErrorPage(HttpStatus.FORBIDDEN,"/403");
                HashSet<ErrorPage> errors = Sets.newHashSet(errorPage);
                factory.setErrorPages(errors);
            }
        };
        return web;
    }
}
