package com.threecat.springboot.webapp.feign.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig
{
	@Bean
	public Retryer retryer()
	{
		return new Retryer.Default(100, 1000, 5);
	}

	@Bean
	Logger.Level feignLoggerLevel()
	{
		return Logger.Level.FULL;
	}
}
