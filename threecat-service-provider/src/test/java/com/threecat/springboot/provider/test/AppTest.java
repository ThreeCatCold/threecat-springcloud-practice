package com.threecat.springboot.provider.test;

import com.threecat.springboot.commons.drivers.annotation.EnableServer;
import com.threecat.springboot.commons.drivers.component.Server;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@EnableServer(type = Server.Type.FTP)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest
{
	@Autowired
	private ApplicationContext context;

	@Test
	public void testServer()
	{
		context.getBean(Server.class).start();
	}
}
