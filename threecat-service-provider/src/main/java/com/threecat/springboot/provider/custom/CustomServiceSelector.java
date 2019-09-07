package com.threecat.springboot.provider.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomServiceSelector implements ImportSelector
{
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata)
	{
		System.out.println(CustomService.class.getName());
		return new String[]{CustomService.class.getName()};
	}
}
