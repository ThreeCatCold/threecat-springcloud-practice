package com.threecat.springboot.commons.drivers.component;

import org.springframework.stereotype.Component;

@Component
public class HttpServer implements Server
{
	@Override public void start()
	{
		System.out.println("http server start.");
	}
}
