package com.threecat.springboot.provider.service;

import com.threecat.springboot.provider.aop.log.po.OperationRecord;

public interface LogRecordService
{
	boolean saveOpLog(OperationRecord record);
}
