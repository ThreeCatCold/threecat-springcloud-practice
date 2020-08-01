package com.threecat.springboot.starter.spring;

import org.springframework.beans.factory.BeanNameAware;

public class LifecycleBeanNameAware implements BeanNameAware
{
	@Override
	public void setBeanName(String name)
	{
		System.out.println("bean name aware.");
	}
}
