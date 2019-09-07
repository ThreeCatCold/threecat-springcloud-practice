package com.threecat.springboot.provider.config;

import com.threecat.springboot.provider.listener.ContextInitListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig
{
	@Bean
	public ServletListenerRegistrationBean<ContextInitListener> servletListenerRegistrationBean()
	{
		ServletListenerRegistrationBean<ContextInitListener> servletListenerRegistrationBean =
				new ServletListenerRegistrationBean<>();
		servletListenerRegistrationBean.setListener(new ContextInitListener());
		return servletListenerRegistrationBean;
	}
}
