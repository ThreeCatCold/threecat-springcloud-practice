package com.threecat.springboot.provider;

import com.threecat.factories.CustomBean;
import com.threecat.springboot.commons.traceid.annotation.EnableTraceId;
import com.threecat.springboot.provider.custom.CustomService;
import com.threecat.springboot.provider.custom.DefineService;
import com.threecat.springboot.provider.custom.EnableCustomService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 2.0不需要EnableEurekaClient之类的注解，有包就行
 */

/**
 * Springboot原理：JavaConfig->AutoConfiguration(Import注解)，ComponentScan
 */
@SpringBootApplication
@EnableCustomService
//@EnableTraceId
public class ServiceApplication implements ApplicationContextAware
{
	private ApplicationContext ctx;

	public static void main(String[] args)
	{
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.ctx = applicationContext;
		System.out.println(ctx.getBean(CustomService.class));
		System.out.println(ctx.getBean(DefineService.class));
		System.out.println(ctx.getBean(CustomBean.class));
	}
}
