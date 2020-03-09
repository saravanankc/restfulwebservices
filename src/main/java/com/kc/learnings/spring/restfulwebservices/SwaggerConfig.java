package com.kc.learnings.spring.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*To update below default API info documentation use ApiInfo object
       "info": {
        "description": "Api Documentation",
                "version": "1.0",
                "title": "Api Documentation",
                "termsOfService": "urn:tos",
                "contact": {},
        "license": {
            "name": "Apache 2.0",
                    "url": "http://www.apache.org/licenses/LICENSE-2.0"
        }
    },
    */

    private static final Contact DEFAULT_CONTACT = new Contact(
            "Rest Admin",
            "http://kc.com",
            "rest-admin@kc.com"
    );
    private static final Collection<VendorExtension> DEFAULT_VENDOR_EXTENSIONS = new ArrayList<>();

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Restful webservice API", //String title,
            "KC Learning - restful webservice API", //String description,
            "1.0", //String version,
            "Some Terms and Conditions URL", //String termsOfServiceUrl,
            DEFAULT_CONTACT, // Contact contact,
            "Apache 2.0", //String license,
            "http://www.apache.org/licenses/LICENSE-2.0", //String licenseUrl,
            DEFAULT_VENDOR_EXTENSIONS
    );

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>();

    static {
        DEFAULT_PRODUCES_AND_CONSUMES.add("application/xml");
        DEFAULT_PRODUCES_AND_CONSUMES.add("application/json");
    }


    //Bean - Docket
    // All paths
    // All apis
    @Bean
    public Docket api(){
        //Enables following endpoints once configured
        //http://localhost:8080/swagger-ui.html
        //http://localhost:8080/v2/api-docs
        return new Docket(DocumentationType.SWAGGER_2)
                //.apiInfo(ApiInfo.DEFAULT)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
