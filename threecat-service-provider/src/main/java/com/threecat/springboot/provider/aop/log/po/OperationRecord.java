package com.threecat.springboot.provider.aop.log.po;

import lombok.Data;

@Data
public class OperationRecord
{
	private long id;

	private String description;

	private int level;

	private int type;

	private String recordContent;

	private long operateTime;

	private String url;

	private String ipAndPort;
}
