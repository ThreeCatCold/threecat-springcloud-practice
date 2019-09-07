package com.threecat.springboot.sso.decorator;

/**
 * 装饰器模式在于功能的拓展，需要将原本的实例对象传递进去（子类构造函数开辟一个父类（接口）的构造参数）
 * 这样无需继承其他相同的子类，便可实现功能拓展，
 */
public interface BaseService
{
	void baseService();
}
