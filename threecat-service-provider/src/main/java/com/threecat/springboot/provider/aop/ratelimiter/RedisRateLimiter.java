package com.threecat.springboot.provider.aop.ratelimiter;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisRateLimiter
{
	int perSecondPermits() default 10;
}
