package com.threecat.springboot.provider.monitor;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PerformanceMonitor
{
}
