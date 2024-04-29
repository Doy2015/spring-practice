package com.spring.practice.infra.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf(AbstractHttpConfigurer::disable)
				.formLogin(Customizer.withDefaults())
				.authorizeHttpRequests(authorizeRequest ->
						authorizeRequest
								.requestMatchers(
										AntPathRequestMatcher.antMatcher("/auth/**")
								).authenticated()
								.requestMatchers(
										AntPathRequestMatcher.antMatcher("/h2-console/**")
								).permitAll()
				)
				.headers(
						headersConfigurer ->
								headersConfigurer
										.frameOptions(
												HeadersConfigurer.FrameOptionsConfig::sameOrigin
										)
				); // h2-console 사용을 위한 설정

		return httpSecurity.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		// 정적 리소스 spring security 대상에서 제외
		return (web) ->
				web
						.ignoring()
						.requestMatchers(
								PathRequest.toStaticResources().atCommonLocations()
						);
	}
}
