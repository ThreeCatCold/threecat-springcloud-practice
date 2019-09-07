package com.threecat.springboot.provider.service.impl;

import com.threecat.springboot.provider.service.ServiceA;
import com.threecat.springboot.provider.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBImpl implements ServiceB
{
	@Autowired
	private ServiceA serviceA;

	@Override public void invoke()
	{
		System.out.println(serviceA);
	}
}
