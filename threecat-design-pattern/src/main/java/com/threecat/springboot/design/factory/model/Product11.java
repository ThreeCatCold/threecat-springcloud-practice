package com.threecat.springboot.design.factory.model;

public class Product11 implements Product
{
	@Override
	public void prepare()
	{
		System.out.println("product11 prepare.");
	}

	@Override
	public void create()
	{
		System.out.println("product11 create.");
	}

	@Override
	public void doPackage()
	{
		System.out.println("product11 doPackage.");
	}
}
