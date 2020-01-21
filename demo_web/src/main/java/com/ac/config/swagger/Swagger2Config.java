package com.ac.config.swagger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  swagger ui
 * @author anchao
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Value("${spring.profiles.active}")
    private String profile;


    @Bean
    public Docket createRestApi() {
        boolean mark = !(StringUtils.isNotBlank(profile) && profile.contains("prd"));
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("spring_boot_demo")
                .description("api service")
                .version("1.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .enable(mark)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ac.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
