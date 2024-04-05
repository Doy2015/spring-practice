package com.spring.practice.infra.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

	@Value("${server.servlet.context-path}")
	private String contextPath;
	private static final String API_VERSION = "0.0.1";
	private static final String API_NAME = "ACCOUNT";
	private static final String API_DESCRIPTION = "Account API 명세서";
	private static final String API_DOCS = "/v3/api-docs/";

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.addServersItem(new Server().url(contextPath))
				.components(new Components()
				)
				.info(apiInfo());
	}

	private Info apiInfo() {
		return new Info().title(API_NAME).description(API_DESCRIPTION).version(API_VERSION);
	}
}
