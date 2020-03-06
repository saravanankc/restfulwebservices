package com.kc.learnings.spring.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //Bean - Docket
    // All paths
    // All apis
    @Bean
    public Docket api(){
        //Enables following endpoints once configured
        //http://localhost:8080/swagger-ui.html
        //http://localhost:8080/v2/api-docs
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
