package com.threecat.springboot.design.factory.model;

public class Product2 implements Product
{
	@Override
	public void prepare()
	{
		System.out.println("product2 prepare.");
	}

	@Override
	public void create()
	{
		System.out.println("product2 create.");
	}

	@Override
	public void doPackage()
	{
		System.out.println("product2 doPackage.");
	}
}
