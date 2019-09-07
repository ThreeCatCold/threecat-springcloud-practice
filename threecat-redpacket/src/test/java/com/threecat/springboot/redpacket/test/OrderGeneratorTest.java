package com.threecat.springboot.redpacket.test;

import com.alibaba.fastjson.JSON;
import com.threecat.springboot.redpacket.model.RedPacketOrder;

public class OrderGeneratorTest
{
	public static String genOrderJson()
	{
		RedPacketOrder order = new RedPacketOrder();
		order.setAmount(1000);
		order.setOrderId(359887045780709376L);
		order.setUserId("fucker-123456");
		order.setPeopleCount(10);
		order.setContext("食屎了");
		return JSON.toJSONString(order);
	}

	public static void main(String[] args)
	{
		System.out.println(genOrderJson());
	}

}
