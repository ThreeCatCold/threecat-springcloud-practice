package com.threecat.springboot.provider.custom;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CustomServiceSelector.class, DefineServiceRegistry.class})
public @interface EnableCustomService
{
}
