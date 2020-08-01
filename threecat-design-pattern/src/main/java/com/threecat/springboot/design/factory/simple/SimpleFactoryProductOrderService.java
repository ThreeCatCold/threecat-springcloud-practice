package com.threecat.springboot.design.factory.simple;

import com.threecat.springboot.design.factory.model.Product;

/**
 * 对外暴露服务，这里简单点就不写接口了
 */
public class SimpleFactoryProductOrderService
{
	private SimpleProductFactory productFactory;

	public SimpleFactoryProductOrderService(SimpleProductFactory productFactory)
	{
		this.productFactory = productFactory;
	}

	/**
	 * 产品订单接口，这里假设就order就是产品名称
	 *
	 * @param order
	 * @return
	 */
	public Product processOrder(String order)
	{
		return productFactory.createProduct(order);
	}

}
