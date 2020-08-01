package com.threecat.springboot.design.factory.simple;

import com.threecat.springboot.design.factory.model.Product;
import com.threecat.springboot.design.factory.model.Product1;
import com.threecat.springboot.design.factory.model.Product2;

public class SimpleProductFactory
{
	public static Product createProduct(String type)
	{
		Product product = null;

		if ("product1".equals(type))
		{
			product = new Product1();
		}
		if ("product2".equals(type))
		{
			product = new Product2();
		}

		return product;
	}
}
