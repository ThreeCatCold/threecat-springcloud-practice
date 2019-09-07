package com.threecat.springboot.sso.spring;

import org.springframework.beans.factory.BeanNameAware;

public class LifecycleBeanNameAware implements BeanNameAware
{
	@Override
	public void setBeanName(String name)
	{
		System.out.println("bean name aware.");
	}
}
