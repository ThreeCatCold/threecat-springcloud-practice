package com.threecat.springboot.redpacket.util;

import com.threecat.springboot.commons.enumeration.EnumService;
import com.threecat.springboot.commons.util.ids.SnowFlake;

import java.util.List;

/**
 * 这里的实现只能用于单点服务，machineId和dataCenterId需要自己想办法设置且服务于服务之间不同。
 */
public class IdGenerator
{
	private static SnowFlake snowFlake = new SnowFlake(getDataCenterId(), getMachineId());

	private static long getMachineId()
	{
		return 2L;
	}

	private static long getDataCenterId()
	{
		return 3L;
	}

	public static long nextId()
	{
		return snowFlake.nextId();
	}

	public static List<Long> nextIds(int count)
	{
		return snowFlake.continueIds(count);
	}
}
