package com.threecat.springboot.commons.drivers.component;

public interface Server
{
	void start();

	enum Type
	{
		FTP, HTTP;
	}
}
