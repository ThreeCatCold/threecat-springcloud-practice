package com.threecat.springboot.provider.aop.log;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
@Documented
public @interface LogRecord
{
	/**
	 * 操作描述
	 * @return
	 */
	String description();

	/**
	 * 操作类型
	 * @return
	 */
	LogOpType operationType() default LogOpType.QUERY;

	/**
	 * 级别
	 * @return
	 */
	LogOpLevel level() default LogOpLevel.COMMON;

	/**
	 * 需要记录的Key
	 * @return
	 */
	String[] recordKey();
}
