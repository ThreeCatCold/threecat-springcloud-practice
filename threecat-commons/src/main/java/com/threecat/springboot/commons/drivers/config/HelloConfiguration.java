package com.threecat.springboot.commons.drivers.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration
{
	public String hello()
	{
		return "hello";
	}

}
