package com.threecat.springboot.commons.traceid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 自动拓展traceid环境
 */
public class TraceIdPostProcessor implements EnvironmentPostProcessor
{
	public static final String PROPERTY_SOURCE_NAME = "defaultProperties";

	@Override public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application)
	{
		Map<String, Object> map = new HashMap<>();

		// making sure the tracing is not disabled
		if (Boolean.parseBoolean(environment.getProperty("tracing.enabled", "true"))) {
			// the pattern of the logging is changed to include trace-id
//			map.put("logging.pattern.level", "%5p [X-TRACE-ID: %X{xtraceid}]"); //平时不用，注释掉
		}
		map.put("spring.aop.proxyTargetClass", "true");
		// add the new set of properties to environment variables
		appendOrWrite(environment.getPropertySources(), map);
	}

	private void appendOrWrite(MutablePropertySources propertySources, Map<String, Object> map) {
		MapPropertySource target = null;
		if (propertySources.contains(PROPERTY_SOURCE_NAME)) {
			PropertySource<?> source = propertySources.get(PROPERTY_SOURCE_NAME);
			if (source instanceof MapPropertySource) {
				target = (MapPropertySource) source;
				for (String key : map.keySet()) {
					if (!target.containsProperty(key)) {
						target.getSource().put(key, map.get(key));
					}
				}
			}
		}
		if (target == null) {
			target = new MapPropertySource(PROPERTY_SOURCE_NAME, map);
		}
		if (!propertySources.contains(PROPERTY_SOURCE_NAME)) {
			propertySources.addLast(target);
		}
	}
}
