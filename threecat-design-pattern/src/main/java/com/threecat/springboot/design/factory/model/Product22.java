package com.threecat.springboot.design.factory.model;

public class Product22 implements Product
{
	@Override
	public void prepare()
	{
		System.out.println("product22 prepare.");
	}

	@Override
	public void create()
	{
		System.out.println("product22create.");
	}

	@Override
	public void doPackage()
	{
		System.out.println("product22 doPackage.");
	}
}
