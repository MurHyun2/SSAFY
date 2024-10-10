package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Desktop desktop() {
		return new Desktop();
	}

	@Bean
	public Programmer programmer() {
		Programmer p = new Programmer(desktop());
		return p;
	}
}