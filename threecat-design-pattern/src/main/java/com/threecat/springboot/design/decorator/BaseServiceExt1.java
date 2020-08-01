package com.threecat.springboot.design.decorator;

public class BaseServiceExt1 implements BaseService
{
	private BaseService delegate;


	public BaseServiceExt1(BaseService delegate)
	{
		this.delegate = delegate;
	}

	@Override
	public void baseService()
	{

	}

	public void extraService1()
	{

	}
}
