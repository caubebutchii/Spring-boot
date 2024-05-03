package com.namvu.projectfinal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Project Final")
                .description("API for Project Final")
                .contact(new Contact("Vũ Hải Nam", "https://github.com/caubebutchii", "vuhainam1506@gmail.com"))
                .license("Apache 2.0")
                .version("1.0")
                .build();

    }
}
