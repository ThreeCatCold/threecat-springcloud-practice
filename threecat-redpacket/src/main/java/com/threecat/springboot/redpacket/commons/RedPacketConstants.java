package com.threecat.springboot.redpacket.commons;

public class RedPacketConstants
{
	/**
	 * 红包键常量，red packet首字母缩写。
	 */
	public static final String BASE_KEY = "rp:";

	/**
	 * Redis key连接符
	 */
	public static final String KEY_CONNECTOR = ":";

	/**
	 * 红包池
	 */
	public static final String RED_PACKET_POOL_LIST = BASE_KEY + KEY_CONNECTOR + "pool:list:";

	/**
	 * 红包明细
	 */
	public static final String RED_PACKET_DETAIL_LIST = BASE_KEY + KEY_CONNECTOR + "details:list:";

	/**
	 * 已抢红包用户
	 */
	public static final String RED_PACKET_HOLD_HASH = BASE_KEY + KEY_CONNECTOR + "hold:hash:";
}
