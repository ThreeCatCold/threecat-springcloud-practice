package com.threecat.springboot.commons.drivers.annotation;

import com.threecat.springboot.commons.drivers.config.HelloConfiguration;
import com.threecat.springboot.commons.drivers.selectors.ServerImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloConfiguration.class)
public @interface EnableHelloConfig
{
}
