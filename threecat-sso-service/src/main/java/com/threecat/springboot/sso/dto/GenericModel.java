package com.threecat.springboot.sso.dto;

public class GenericModel<T>
{
	private T data;

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}
}
