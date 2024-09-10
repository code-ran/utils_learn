package com.ransibi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        //http://ip地址:端口/项目名/swagger-ui.html#/
        ApiInfo apiInfo = new ApiInfoBuilder()
                //网站标题
                .title("swagger测试项目")
                //网站描述
                .description("测试.")
                //版本
                .version("9.0")
                //友链
//                .contact(new Contact("冉思碧","http:www.baidu.com","https://code-ran.github.io/"))
                //协议
                .license("The Apache License")
                //协议url
                .licenseUrl("http://www.baidu.com")
                .build();

        return new Docket(DocumentationType.SWAGGER_2) //swagger版本
                .pathMapping("/")
                .select()
                //扫描那些controller
                .apis(RequestHandlerSelectors.basePackage("com.ransibi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }
}
