package com.threecat.springboot.redpacket.service;

import com.threecat.springboot.redpacket.model.RedPacketOrder;

/**
 * 红包服务
 */
public interface RedPacketService
{
	long createOrderId();

	String createOrder(RedPacketOrder order);

	int grabRedPacket(String userId, long orderId);
}
