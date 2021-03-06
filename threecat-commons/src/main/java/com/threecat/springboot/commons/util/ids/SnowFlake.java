package com.threecat.springboot.commons.util.ids;

import java.util.ArrayList;
import java.util.List;

public class SnowFlake
{
	/**
	 * 起始的时间戳
	 */
	private static final long START_STMP = 1480166465631L;

	/**
	 * 每一部分占用的位数
	 */
	private static final long SEQUENCE_BIT = 12; //序列号占用的位数
	private static final long MACHINE_BIT = 5;   //机器标识占用的位数
	private static final long DATACENTER_BIT = 5;//数据中心占用的位数

	/**
	 * 每一部分的最大值
	 */
	private static final long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
	private static final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
	private static final long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

	/**
	 * 每一部分向左的位移
	 */
	private static final long MACHINE_LEFT = SEQUENCE_BIT;
	private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
	private static final long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

	private long dataCenterId;  //数据中心
	private long machineId;     //机器标识
	private long sequence = 0L; //序列号
	private long lastStamp = -1L;//上一次时间戳

	public SnowFlake(long dataCenterId, long machineId)
	{
		if (this.dataCenterId > MAX_DATACENTER_NUM || this.dataCenterId < 0)
		{
			throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
		}
		if (machineId > MAX_MACHINE_NUM || machineId < 0)
		{
			throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
		}
		this.dataCenterId = dataCenterId;
		this.machineId = machineId;
	}

	/**
	 * 产生下一个ID
	 *
	 * @return
	 */
	public synchronized long nextId()
	{
		return getNextId();
	}

	private long getNextId()
	{
		long currStmp = getNewstmp();
		if (currStmp < lastStamp)
		{
			throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
		}

		if (currStmp == lastStamp)
		{
			//相同毫秒内，序列号自增
			sequence = (sequence + 1) & MAX_SEQUENCE;
			//同一毫秒的序列数已经达到最大
			if (sequence == 0L)
			{
				currStmp = getNextMill();
			}
		}
		else
		{
			//不同毫秒内，序列号置为0
			sequence = 0L;
		}

		lastStamp = currStmp;

		return (currStmp - START_STMP) << TIMESTAMP_LEFT //时间戳部分
				| dataCenterId << DATACENTER_LEFT       //数据中心部分
				| machineId << MACHINE_LEFT             //机器标识部分
				| sequence;                             //序列号部分
	}

	private long getNextMill()
	{
		long mill = getNewstmp();
		while (mill <= lastStamp)
		{
			mill = getNewstmp();
		}
		return mill;
	}

	private long getNewstmp()
	{
		return System.currentTimeMillis();
	}

	/**
	 * 获取连续个数的id
	 * @param count
	 * @return
	 */
	public synchronized List<Long> continueIds(int count)
	{
		List<Long> ids = new ArrayList<>(count);
		for (int i = 0; i < count; i++)
		{
			ids.add(nextId());
		}
		return ids;
	}

}
