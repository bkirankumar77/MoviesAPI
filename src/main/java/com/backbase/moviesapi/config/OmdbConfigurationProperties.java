package com.backbase.moviesapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.backbase.moviesapi")
public class OmdbConfigurationProperties {

	private OMDB omdb = new OMDB();

	@Data
	public class OMDB {
		private String apiKey;
		private String url;
		private String imageUrl;
	}

}
