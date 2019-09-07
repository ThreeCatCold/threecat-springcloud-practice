package com.threecat.springboot.rpc.client;

import com.threecat.springboot.rpc.service.CommonService;

public class RpcClientMain
{
	public static void main(String[] args)
	{
		CommonService<String> commonService = RpcProxyClient.getProxyClient(CommonService.class, "127.0.0.1", 8080);
		String result = commonService.service();
		System.out.println(result);
	}
}
