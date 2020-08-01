package com.threecat.springboot.design.factory.model;

public class Product1 implements Product
{
	@Override
	public void prepare()
	{
		System.out.println("product1 prepare.");
	}

	@Override
	public void create()
	{
		System.out.println("product1 create.");
	}

	@Override
	public void doPackage()
	{
		System.out.println("product1 doPackage.");
	}
}
