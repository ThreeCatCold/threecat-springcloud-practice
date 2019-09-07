package com.threecat.springboot.sso.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class LifecycleBeanFactoryAware extends LifecycleBeanNameAware implements BeanFactoryAware
{
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException
	{
		System.out.println("bean factory aware.");
	}
}
