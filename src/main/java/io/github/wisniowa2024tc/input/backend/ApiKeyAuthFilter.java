package io.github.wisniowa2024tc.input.backend;

import org.springframework.web.filter.OncePerRequestFilter;

public abstract class ApiKeyAuthFilter extends OncePerRequestFilter {
	private static final String apiKeyHeader = "X-Api-Key";
	private final String apiKey = "test";
}
