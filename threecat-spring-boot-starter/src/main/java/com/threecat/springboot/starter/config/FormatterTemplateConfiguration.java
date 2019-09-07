package com.threecat.springboot.starter.config;

import com.threecat.springboot.starter.bean.formatter.Formatter;
import com.threecat.springboot.starter.bean.formatter.FormatterTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(StringFormatterConfiguration.class)
@Configuration
public class FormatterTemplateConfiguration
{
	@Bean
	public FormatterTemplate formatterTemplate(Formatter formatter)
	{
		return new FormatterTemplate(formatter);
	}
}
