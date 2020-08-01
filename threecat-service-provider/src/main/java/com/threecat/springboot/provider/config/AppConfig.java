package com.threecat.springboot.provider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
	@Value("${application.rate.per-second-request}")
	Double perSecondRequest;

	@Value("${server.port}")
	int serverPort;

	@Value("${spring.application.name}")
	String serverName;
}
