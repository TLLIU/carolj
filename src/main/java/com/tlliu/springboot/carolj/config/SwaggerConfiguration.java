package com.tlliu.springboot.carolj.config;

import org.springdoc.core.Constants;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;

// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public GroupedOpenApi usersGroup(@Value("${springdoc.version}") String appVersion) {
		return GroupedOpenApi.builder().group("Carolj")
				.addOperationCustomizer((operation, handlerMethod) -> {
					operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
					return operation;
				})
				.addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Carolj Application API").version(appVersion)))
				.packagesToScan("com.tlliu.springboot.carolj.controller")
				.build();
	}

    @Bean
	@Profile("!prod")
	public GroupedOpenApi actuatorApi(OpenApiCustomiser actuatorOpenApiCustomiser,
			OperationCustomizer actuatorCustomizer,
			WebEndpointProperties endpointProperties,
			@Value("${springdoc.version}") String appVersion) {
		return GroupedOpenApi.builder()
				.group("Actuator")
				.pathsToMatch(endpointProperties.getBasePath() + Constants.ALL_PATTERN)
				.addOpenApiCustomiser(actuatorOpenApiCustomiser)
				.addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Actuator API").version(appVersion)))
				.addOperationCustomizer(actuatorCustomizer)
				.pathsToExclude("/rest/actuator/health/**")
				.pathsToExclude("/rest/actuator/health/*")
				.build();
    }
    
    // @Bean
    // public Docket createRestApi() {
    //     return new Docket(DocumentationType.SWAGGER_2)
    //         .apiInfo(apiInfo())
    //         .select()
    //         .apis(RequestHandlerSelectors.basePackage("com.tlliu.springboot.carolj.controller"))
    //         .paths(PathSelectors.any())
    //         .build();
    // }
 
    // private ApiInfo apiInfo() {
    //     return new ApiInfoBuilder()
    //         .title("RESTFUL API DOC")
    //         .description("Spring-Boot--RESTFUL API documentation generated automatically")
    //         //.termsOfServiceUrl("http://blog.csdn.net/appleyk")
    //         .version("1.0")
    //         //.licenseUrl("http://localhost:8181/")
    //         .build();
    // }     	

}