package com.threecat.factories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SPI拓展点，spring.factories配置文件配置
 */
@Configuration
public class BeanConfig
{
	@Bean
	public CustomBean bean()
	{
		return new CustomBean();
	}
}
