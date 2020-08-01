package com.threecat.springboot.design.factory.model;

public interface Product
{
	/**
	 * 材料准备
	 */
	void prepare();

	/**
	 * 创建
	 */
	void create();

	/**
	 * 包装
	 */
	void doPackage();
}
