package com.backbase.moviesapi.config;

import com.backbase.moviesapi.model.User;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger spring fox configuration settings
 *
 * @version 0.0.1
 * @author KB
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiEndPointsInfo())
                .securityContexts(Collections.singletonList(
                        SecurityContext.builder()
                                .securityReferences(defaultAuth())
                                .operationSelector(
                                        o -> o.requestMappingPattern().startsWith("/movies/")
                                )
                                .build()
                ))
                .securitySchemes(List.of(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/movies/*.*")
                        .or(PathSelectors.regex("/auth/*.*")))
                .build()
                .protocols(Set.of("http"))
                .ignoredParameterTypes(User.class);
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Backbase - Swagger Configuration")
                .description("\" Backbase Movies API \"").version("0.0.1")
                .contact(new Contact("Kiran Bollam", "https://github.com/b.kirankumar77", "b.kirankumar77@gmail.com"))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("token", HttpHeaders.AUTHORIZATION,SecurityScheme.In.HEADER.name());
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference("token", authorizationScopes));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/")
                .resourceChain(false);

    }
}
