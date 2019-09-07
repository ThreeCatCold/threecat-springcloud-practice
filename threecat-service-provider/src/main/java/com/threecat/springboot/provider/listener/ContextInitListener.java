package com.threecat.springboot.provider.listener;

import com.threecat.springboot.provider.spring.SpringApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * web容器初始化监听器
 */
public class ContextInitListener implements ServletContextListener
{
	@Override public void contextInitialized(ServletContextEvent sce)
	{
		ServletContext sc = sce.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		SpringApplicationContext.set(ctx);
	}

	@Override public void contextDestroyed(ServletContextEvent sce)
	{

	}
}
