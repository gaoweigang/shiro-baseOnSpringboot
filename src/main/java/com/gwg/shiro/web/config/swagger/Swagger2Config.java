package com.gwg.shiro.web.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("market系统 API")//
				.description("")//
				.license("")//
				.licenseUrl("http://unlicense.org")//
				.termsOfServiceUrl("")//
				.version("0.0.1")//
				.contact(new Contact("", "", ""))//
				.build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("com.houbank.market.controller"))//
				.build()//
				.apiInfo(apiInfo());
	}

}
