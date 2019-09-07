package com.threecat.springboot.provider.java8;

/**
 * 解决接口的修改与接口实现类不兼容的问题，作为代码向前兼容的一个方法，
 * 所有实现该接口的子类没必要都去写该方法实现
 */
public interface DefaultMethodInterface
{
	default void method()
	{
		System.out.println("Default method.");
	}
}
