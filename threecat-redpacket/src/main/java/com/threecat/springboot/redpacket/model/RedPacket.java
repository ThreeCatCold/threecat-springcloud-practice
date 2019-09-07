package com.threecat.springboot.redpacket.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RedPacket implements Serializable
{
	private String id;
	private int money;

	public RedPacket(String id, int money)
	{
		this.id = id;
		this.money = money;
	}
}
