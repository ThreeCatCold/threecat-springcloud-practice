package com.threecat.springboot.rpc.service.impl;

import com.threecat.springboot.rpc.service.CommonService;

public class CommonServiceImpl implements CommonService<String>
{
	@Override
	public String service()
	{
		return "common service";
	}
}
