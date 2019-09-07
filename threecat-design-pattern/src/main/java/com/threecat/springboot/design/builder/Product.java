package com.threecat.springboot.design.builder;

/**
 * 遇到多个构造器参数时，要考虑使用构建器（Builder模式）
 */
public class Product
{
	private String name;

	private String description;

	private String function;

	private double price;

	private Product(Builder builder)
	{
		this.name = builder.name;
		this.description = builder.description;
		this.function = builder.function;
		this.price = builder.price;
	}

	public static class Builder
	{
		private String name;

		private String description;

		private String function;

		private double price;

		public Builder name(String name)
		{
			this.name = name;
			return this;
		}

		public Builder description(String description)
		{
			this.description = description;
			return this;
		}

		public Builder function(String function)
		{
			this.function = function;
			return this;
		}

		public Builder price(double price)
		{
			this.price = price;
			return this;
		}

		public Product build()
		{
			return new Product(this);
		}
	}
}
