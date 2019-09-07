package com.threecat.springboot.provider.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceApplicationTest
{
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception
	{
		this.base = new URL("http://127.0.0.1:" + port + "/service-provider/hello");
	}

	@Test
	public void getHello() throws Exception
	{
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		Assert.hasText(response.getBody(), "Hello, provider service.");
	}
}
