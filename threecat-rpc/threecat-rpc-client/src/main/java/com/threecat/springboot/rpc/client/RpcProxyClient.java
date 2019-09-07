package com.threecat.springboot.rpc.client;

import com.threecat.springboot.rpc.api.RpcInvokeProtocol;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RpcProxyClient
{
	private static Map<Class<?>, Object> cache = new ConcurrentHashMap<>();

	public static synchronized <T> T getProxyClient(Class<T> interfaceClass, String host, int port)
	{
		Object proxyService = cache.get(interfaceClass);
		if (proxyService == null)
		{
			proxyService = doRegister(interfaceClass, host, port);
		}
		return (T)proxyService;
	}

	private static Object doRegister(Class<?> interfaceClass, String host, int port)
	{
		Object service = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },
				new RemoteProxyHandler(host, port));
		cache.put(interfaceClass, service);
		return service;
	}

	private static class RemoteProxyHandler implements InvocationHandler
	{
		private String host;

		private int port;

		public RemoteProxyHandler(String host, int port)
		{
			this.host = host;
			this.port = port;
		}

		@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
		{
			RpcInvokeProtocol protocol = new RpcInvokeProtocol();
			protocol.setServiceClazz(method.getDeclaringClass().getName());
			protocol.setMethodName(method.getName());
			protocol.setParams(args);

			return RpcNetTransporter.send(protocol, host, port);
		}
	}
}
