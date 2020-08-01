package com.threecat.springboot.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController
{
	@Autowired
	private Environment environment;
	@GetMapping("/env/{name}")
	public Map<String, String> environment(@PathVariable String propertyName)
	{
		Map<String, String> envProperties = new HashMap<>();
		envProperties.put(propertyName, environment.getProperty(propertyName));
		return envProperties;
	}
}
