package com.threecat.springboot.provider.test.loadprint;

public class ClassB extends ClassA
{
	public ClassB()
	{
		System.out.println("ClassB");
	}

	{
		System.out.println("I'm B class");
	}

	static
	{
		System.out.println("static B");
	}

	public static void main(String[] args)
	{
		new ClassB();
	}
}
