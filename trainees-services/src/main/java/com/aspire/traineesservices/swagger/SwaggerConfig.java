package com.aspire.traineesservices.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author vinoth.madhu
 * Swwagger configuration for Swagger UI.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * 
	 * @return
	 */
	 @Bean
	 public Docket api() {
	 return new Docket(DocumentationType.SWAGGER_2).select()
	 .apis(RequestHandlerSelectors.basePackage("com.aspire.traineesservices.controllers"))
	 .paths(regex("/training-dept.*")).build()
	 .apiInfo(apiInfo());
	 }
	 /**
	  * 
	  * @return
	  */
	 private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "Trainee Management", 
	       "Keep track of trainee details with review history", 
	       "1.0", 
	       "Terms of service", 
	       new Contact("Vinothkumar Madhu", "mydatabase-d2f08.firebaseapp.com", "vinoth,madhu@aspiresys.com"), 
	       "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}
}
