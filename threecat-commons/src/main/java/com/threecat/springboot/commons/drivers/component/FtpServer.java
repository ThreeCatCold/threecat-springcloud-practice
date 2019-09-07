package com.threecat.springboot.commons.drivers.component;

import org.springframework.stereotype.Component;

@Component //不加该注解也可以，遵守spring规范
public class FtpServer implements Server
{
	@Override public void start()
	{
		System.out.println("ftp server start.");
	}
}
