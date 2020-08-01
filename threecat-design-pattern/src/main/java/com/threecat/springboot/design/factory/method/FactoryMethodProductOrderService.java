package com.threecat.springboot.design.factory.method;

import com.threecat.springboot.design.factory.model.Product;

/**
 * 工厂方法模式的核心就是，对产品进行进一步划分，比如product1, product11 都属于product1系列
 * product2, product22都属于product22系列（假设），这样就可以为之创建专门的工厂来处理，product1系列
 * 一个工厂，product2系列一个工厂。
 * 其实就是专门对工厂又做了一层抽象
 */
public class FactoryMethodProductOrderService
{
	public Product processOrder(String order)
	{
		return getFactory(order).create(order);
	}

	/**
	 * 根据传入的订单类型选择是哪个产品工厂。
	 * @param order
	 * @return
	 */
	private BaseProductFactory getFactory(String order)
	{
		return null;
	}
}
