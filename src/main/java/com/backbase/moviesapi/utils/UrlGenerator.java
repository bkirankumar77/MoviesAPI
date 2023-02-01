package com.backbase.moviesapi.utils;

import com.backbase.moviesapi.config.OmdbConfigurationProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(value = OmdbConfigurationProperties.class)
public class UrlGenerator {

	private final OmdbConfigurationProperties omdbConfigurationProperties;

	public String generateUrl(final String movieTitle) {
		final var properties = omdbConfigurationProperties.getOmdb();
		return properties.getUrl().replace("{key}", properties.getApiKey()).replace("{title}", movieTitle).trim()
				.replace(" ", "_");
	}
	public String generateImageUrl(final String imdb) {
		final var properties = omdbConfigurationProperties.getOmdb();
		return properties.getImageUrl().replace("{key}", properties.getApiKey()).replace("{imdb}", imdb).trim()
				.replace(" ", "_");
	}
}
