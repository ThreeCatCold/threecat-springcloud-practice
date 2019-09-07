package com.threecat.springboot.provider.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring应用上下文
 */
public class SpringApplicationContext
{
	private static ApplicationContext ctx;

	public static void set(ApplicationContext applicationContext)
	{
		ctx = applicationContext;
	}

	public static ApplicationContext get()
	{

		ApplicationContext ctx = new AnnotationConfigApplicationContext();
		return ctx;
	}
}
