package com.threecat.springboot.provider.service.impl;

import com.threecat.springboot.provider.service.SpringTxTestService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class SpringTxTestServiceImpl implements SpringTxTestService
{
	/**
	 * 默认配置的doService
	 * @param params
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void doDefaultService(String... params)
	{

	}
}
