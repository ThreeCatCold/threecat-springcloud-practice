package com.threecat.springboot.design.decorator;

public class BaseServiceExt2 implements BaseService
{
	private BaseService delegate;


	public BaseServiceExt2(BaseService delegate)
	{
		this.delegate = delegate;
	}

	@Override
	public void baseService()
	{

	}

	public void extraService2()
	{

	}
}
