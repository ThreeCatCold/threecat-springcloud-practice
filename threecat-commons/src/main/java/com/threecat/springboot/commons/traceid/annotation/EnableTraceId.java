package com.threecat.springboot.commons.traceid.annotation;

import com.threecat.springboot.commons.traceid.selector.TraceIdImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启traceId注解，利用spring-spi机制自动装配(/resource/META-INF/spring.factories)。
 * 待优化
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TraceIdImportSelector.class)
public @interface EnableTraceId
{
	/**
	 * 是否使用默认配置，
	 * @return
	 */
	boolean useDefaultConfig() default true;
}
