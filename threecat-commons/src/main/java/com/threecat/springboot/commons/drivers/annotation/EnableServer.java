package com.threecat.springboot.commons.drivers.annotation;

import com.threecat.springboot.commons.drivers.component.Server;
import com.threecat.springboot.commons.drivers.registrar.ServerImportBeanDefinitionRegistrar;
import com.threecat.springboot.commons.drivers.selectors.ServerImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportSelector.class)
//@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer
{
	Server.Type type();
}
