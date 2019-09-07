package com.threecat.springboot.commons.drivers.selectors;

import com.threecat.springboot.commons.drivers.annotation.EnableServer;
import com.threecat.springboot.commons.drivers.component.FtpServer;
import com.threecat.springboot.commons.drivers.component.HttpServer;
import com.threecat.springboot.commons.drivers.component.Server;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class ServerImportSelector implements ImportSelector
{
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata)
	{
		Map<String, Object> annotationAttributes = importingClassMetadata
				.getAnnotationAttributes(EnableServer.class.getName());
		Server.Type type = (Server.Type) annotationAttributes.get("type");
		String[] classNames = new String[0];
		switch (type)
		{
			case FTP:
				classNames = new String[]{ FtpServer.class.getName()};
				break;
			case HTTP:
				classNames = new String[]{ HttpServer.class.getName()};
				break;
		}
		return classNames;
	}
}
