package com.travel.laizheli.common.config;

import com.travel.laizheli.common.domain.SwaggerProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger基础配置
 * Created by macro on 2020/7/16.
 */
public abstract class BaseSwaggerConfig {

//    @Bean
//    public Docket createRestApi() {
//        SwaggerProperties swaggerProperties = swaggerProperties();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo(swaggerProperties))
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage()))
//                .paths(PathSelectors.any())
//                .build();
//        if (swaggerProperties.isEnableSecurity()) {
//            docket.securitySchemes(securitySchemes()).securityContexts(securityContexts());
//        }
//        return docket;
//    }
//
//    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
//        return new ApiInfoBuilder()
//                .title(swaggerProperties.getTitle())
//                .description(swaggerProperties.getDescription())
//                .contact(new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail()))
//                .version(swaggerProperties.getVersion())
//                .build();
//    }
//
//    private List<ApiKey> securitySchemes() {
//        //设置请求头信息
//        List<ApiKey> result = new ArrayList<>();
//        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
//        result.add(apiKey);
//        return result;
//    }
//
//    private List<SecurityContext> securityContexts() {
//        //设置需要登录认证的路径
//        List<SecurityContext> result = new ArrayList<>();
//        result.add(getContextByPath("/*/.*"));
//        return result;
//    }
//
//    private SecurityContext getContextByPath(String pathRegex) {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex(pathRegex))
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        List<SecurityReference> result = new ArrayList<>();
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        result.add(new SecurityReference("Authorization", authorizationScopes));
//        return result;
//    }

    /**
     * 自定义Swagger配置
     */
    public abstract SwaggerProperties swaggerProperties();
}