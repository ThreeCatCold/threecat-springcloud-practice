package com.threecat.springboot.provider.service.impl;

import com.threecat.springboot.provider.aop.log.po.OperationRecord;
import com.threecat.springboot.provider.service.LogRecordService;
import org.springframework.stereotype.Service;

@Service
public class LogRecordServiceImpl implements LogRecordService
{
	@Override
	public boolean saveOpLog(OperationRecord record)
	{
		//TODO 实现dao层的存储
		return true;
	}
}
