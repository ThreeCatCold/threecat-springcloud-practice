package com.threecat.springboot.design.builder;

public class Main
{
	public static void main(String[] args)
	{
		Product product = new Product.Builder().description("desc").name("product").function("func").price(1.1).build();
	}
}
