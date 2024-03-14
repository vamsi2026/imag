package com.imag.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configures security settings for a web application using Spring Security.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	// This method configures a security filter chain to disable CSRF protection and
	// permit all requests, while requiring authentication for all other requests.
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)
			throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(
						requests -> requests.requestMatchers("/**").permitAll().requestMatchers("/**").authenticated())
				.build();
	}
}
