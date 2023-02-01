package com.backbase.moviesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MoviesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesapiApplication.class, args);
	}

}
