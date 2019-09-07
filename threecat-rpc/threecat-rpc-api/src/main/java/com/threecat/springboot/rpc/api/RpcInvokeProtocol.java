package com.threecat.springboot.rpc.api;

import java.io.Serializable;

public class RpcInvokeProtocol implements Serializable
{
	private String serviceClazz;
	private String methodName;
	private Object[] params;

	public String getServiceClazz()
	{
		return serviceClazz;
	}

	public void setServiceClazz(String serviceClazz)
	{
		this.serviceClazz = serviceClazz;
	}

	public String getMethodName()
	{
		return methodName;
	}

	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}

	public Object[] getParams()
	{
		return params;
	}

	public void setParams(Object[] params)
	{
		this.params = params;
	}
}
