package com.rafik.employeeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket newApi(){
        Set produce= new HashSet<>(Arrays.asList("application/json","application/xml"));
        Set consume= new HashSet<>(Arrays.asList("application/json","application/xml"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(produce)
                .consumes(consume);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Service")
                .description("Employee ServiceWith Swagger Documentation")
                .termsOfServiceUrl("http://www.rafik.com?etc")
                .contact(SUPPORTED_CONTACTS)
                .license("Employee Licence Version 1.0")
                .licenseUrl("http://www.rafik.com/licence")
                .version("3.0")
                .build();
    }
    public static final Contact SUPPORTED_CONTACTS = new Contact("rafik", "http://www.rafik.com",
            "support@mail.com");
}
