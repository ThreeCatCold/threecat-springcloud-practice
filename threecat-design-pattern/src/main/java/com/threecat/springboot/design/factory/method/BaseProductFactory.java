package com.threecat.springboot.design.factory.method;

import com.threecat.springboot.design.factory.model.Product;

public interface BaseProductFactory
{
	Product create(String type);
}
