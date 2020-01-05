package com.ac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author anchao
 * @date 2019/12/18 18:09
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
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
