package com.threecat.springboot.sso.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LifecycleBeanProcessor implements BeanPostProcessor
{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println("bean post processor before initialization. 加解密等.");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println("bean post processor after initialization.");
		return bean;
	}
}
