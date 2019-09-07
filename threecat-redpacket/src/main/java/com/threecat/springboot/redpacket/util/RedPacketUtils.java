package com.threecat.springboot.redpacket.util;

import com.threecat.springboot.redpacket.commons.RedPacketConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPacketUtils
{
	/**
	 * 简单的红包划分算法，待提升
	 * 二倍均值法
	 * @param amount
	 * @param peopleCount
	 * @return
	 */
	public static List<Integer> divideRedPacket(int amount, int peopleCount)
	{
		List<Integer> divideResults = new ArrayList<>();
		Random random = new Random();

		int restAmount = amount;
		int restPeopleCount = peopleCount;
		// 前n-1个人每人随机从（剩余总数/剩余人数总数 * 2 - 1）中尝试获取红包钱。最后一个位置拿下剩余所有红包。
		for (int i = 0; i < peopleCount - 1; i++)
		{
			int money = random.nextInt(restAmount/restPeopleCount * 2 - 1) + 1;
			restAmount -= money;
			restPeopleCount--;
			divideResults.add(money);
		}
		divideResults.add(restAmount);

		return divideResults;
	}

	/**
	 * 红包key生成：rp:{userId}:{orderId}
	 *
	 * @param orderId
	 * @return
	 */
	public static String genRedPacketKey(long orderId)
	{
		return RedPacketConstants.RED_PACKET_POOL_LIST + orderId;
	}
}
