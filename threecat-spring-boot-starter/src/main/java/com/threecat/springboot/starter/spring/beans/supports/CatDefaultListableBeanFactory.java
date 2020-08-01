package com.threecat.springboot.starter.spring.beans.supports;

import com.threecat.springboot.sso.spring.beans.CatBeanFactory;
import com.threecat.springboot.sso.spring.beans.config.CatBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class CatDefaultListableBeanFactory implements CatBeanFactory
{
	protected Map<String, CatBeanDefinition> beanDefinitionsMap = new ConcurrentHashMap<>();
}
