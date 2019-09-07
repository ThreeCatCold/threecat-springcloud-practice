package com.threecat.springboot.commons.drivers.registrar;

import com.threecat.springboot.commons.drivers.selectors.ServerImportSelector;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar
{
	@Override public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry)
	{
		ImportSelector importSelector = new ServerImportSelector();

		String[] selectedClassNames = importSelector.selectImports(importingClassMetadata);

		Stream.of(selectedClassNames)
				.map(BeanDefinitionBuilder::genericBeanDefinition)
				.map(BeanDefinitionBuilder::getBeanDefinition)
				.forEach(beanDefinition->{
					BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
				});
	}
}
