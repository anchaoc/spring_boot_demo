package com.ac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @author anchao
 * @date 2019/12/18 18:09
 */
@Configuration
public class RestTemplateConfig {



    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate(factory());
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }


    private SimpleClientHttpRequestFactory factory(){
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(10000);
        simpleClientHttpRequestFactory.setReadTimeout(10000);
        return simpleClientHttpRequestFactory;
    }

//    /**
//     * thymeself
//     */
//    @Bean
//    public ITemplateResolver templateResolver(ServletContext servletContext) {
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
//        templateResolver.setPrefix("/page/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML");
//        return templateResolver;
//    }

}
