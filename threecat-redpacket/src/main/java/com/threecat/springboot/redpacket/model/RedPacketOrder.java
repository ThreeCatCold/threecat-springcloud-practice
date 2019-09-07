package com.threecat.springboot.redpacket.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RedPacketOrder
{
	@NotNull
	private String userId;

	/**
	 * 单位是分
	 */
	@Min(1)
	private int amount;

	@Min(1)
	private int peopleCount;

	private long orderId;

	@NotNull
	private String context;
}
