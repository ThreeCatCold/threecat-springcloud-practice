package com.threecat.springboot.starter.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifecycleInitializingBean extends LifecycleBeanFactoryAware implements InitializingBean, DisposableBean
{
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("InitializingBean");
	}

	@Override public void destroy() throws Exception
	{

	}
}
