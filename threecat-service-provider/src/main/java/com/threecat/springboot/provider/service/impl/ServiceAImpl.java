package com.threecat.springboot.provider.service.impl;

import com.threecat.springboot.provider.service.ServiceA;
import com.threecat.springboot.provider.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAImpl implements ServiceA
{
	@Autowired
	private ServiceB serviceB;

	@Override public void invoke()
	{
		System.out.println(serviceB);
	}
}
