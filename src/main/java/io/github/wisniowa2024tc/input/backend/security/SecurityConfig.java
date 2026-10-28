package io.github.wisniowa2024tc.input.backend.security;

import io.github.wisniowa2024tc.input.backend.ApiKeyAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/**").authenticated()
				.anyRequest().permitAll()
			)
			.httpBasic(Customizer.withDefaults())
			.addFilterBefore(new ApiKeyAuthFilter(), )
	}
}
