package com.threecat.springboot.starter.spring.context;

import com.threecat.springboot.sso.spring.beans.config.CatBeanDefinition;
import com.threecat.springboot.sso.spring.beans.supports.CatBeanDefinitionReader;
import com.threecat.springboot.sso.spring.beans.supports.CatDefaultListableBeanFactory;

import java.util.List;

public class CatApplicationContext extends CatDefaultListableBeanFactory
{
	private String[] configLocations;

	public CatApplicationContext(String[] configLocations)
	{
		this.configLocations = configLocations;
	}

	@Override
	public Object getBean(String beanName)
	{
		return null;
	}

	public void refresh()
	{
		//1.定位资源配置文件
		CatBeanDefinitionReader reader = new CatBeanDefinitionReader();

		//2.加载配置文件，扫描相关的类，并封装到beanDefinition
		List<CatBeanDefinition> beanDefinitions = reader.loadBeanDefinitions(configLocations);


		//3.注册，将配置信息放到容器里面（真正的ioc容器是BeanWrapper）
		doRegisterBeanDefinitions(beanDefinitions);

		//4、把不是延时加载的类提前初始化至单例缓存
		doAutowired();
	}

	private void doAutowired()
	{
	}

	private void doRegisterBeanDefinitions(List<CatBeanDefinition> beanDefinitions)
	{
	}

}
