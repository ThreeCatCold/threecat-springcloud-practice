package com.threecat.springboot.sso.decorator;

public class Test
{
	public static void main(String[] args)
	{
		// 如下所示，可以不停地加入新的功能，但是由没必要继承其他子类，只需传入一个BaseService的对象即可。
		BaseService serviceImpl = new BaseServiceImpl();
		BaseService serviceExt1 = new BaseServiceExt1(serviceImpl);
		BaseService serviceExt2 = new BaseServiceExt2(serviceExt1);
	}
}
