package com.threecat.springboot.rpc;

import com.threecat.springboot.rpc.server.RpcProxyServer;

public class RpcServerMain
{
	public static void main(String[] args)
	{
		RpcProxyServer.publish(8080);
		System.out.println("Server started.");
	}
}
