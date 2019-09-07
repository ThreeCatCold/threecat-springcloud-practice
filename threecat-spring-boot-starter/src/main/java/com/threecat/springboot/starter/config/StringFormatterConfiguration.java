package com.threecat.springboot.starter.config;

import com.alibaba.fastjson.JSON;
import com.threecat.springboot.starter.bean.formatter.Formatter;
import com.threecat.springboot.starter.bean.formatter.JsonFormatter;
import com.threecat.springboot.starter.bean.formatter.StringFormatter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StringFormatterConfiguration
{
	@ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
	@Primary
	@Bean
	public Formatter strFormatter()
	{
		return new StringFormatter();
	}

	@ConditionalOnClass(JSON.class)
	@Bean
	public Formatter jsonFormatter()
	{
		return new JsonFormatter();
	}
}
