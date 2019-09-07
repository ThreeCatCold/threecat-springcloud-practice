package com.threecat.springboot.provider.custom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class DefineServiceRegistry implements ImportBeanDefinitionRegistrar
{
	@Override public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry)
	{
		Class<?> beanClass = DefineService.class;
		RootBeanDefinition beanDefinition = new RootBeanDefinition(beanClass);
		String beanName = StringUtils.uncapitalize(beanClass.getSimpleName());
		registry.registerBeanDefinition(beanName, beanDefinition);
	}
}
