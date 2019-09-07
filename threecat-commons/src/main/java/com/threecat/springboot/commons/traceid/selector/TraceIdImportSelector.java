package com.threecat.springboot.commons.traceid.selector;

import com.threecat.springboot.commons.traceid.TraceIdFilter;
import com.threecat.springboot.commons.traceid.TraceIdPostProcessor;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class TraceIdImportSelector implements ImportSelector
{
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata)
	{
		return new String[]{ TraceIdFilter.class.getName()};
	}
}
