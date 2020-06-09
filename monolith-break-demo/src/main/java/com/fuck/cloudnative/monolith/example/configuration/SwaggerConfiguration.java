package com.fuck.cloudnative.monolith.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午4:31
* created by fuck~
**/
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.fuck"))
                .build().apiInfo(new ApiInfoBuilder()
                        .title("API文档标题")
                        .description("这里填写接口文档的描述")
                        .contact(new Contact("联系者名称","联系者url地址","联系者邮箱@email.hello.com"))
                        .build());
    }
}
