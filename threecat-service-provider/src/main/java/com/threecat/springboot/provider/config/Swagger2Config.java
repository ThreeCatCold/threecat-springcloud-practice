package com.threecat.springboot.provider.config;

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
 * 注意swagger2的所有api访问路径也要在该项目路径下
 * 比如：http://localhost:8081/provider-service/swagger-ui.html
 * 项目路径为/provider-service
 */
@Configuration
//@EnableSwagger2
public class Swagger2Config
{
	@Bean
	public Docket createtRestApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.threecat.springboot.provider.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("spring boot swagger document").description("restful api")
				.termsOfServiceUrl("localhost:8081").version("1.0").build();
	}
}
