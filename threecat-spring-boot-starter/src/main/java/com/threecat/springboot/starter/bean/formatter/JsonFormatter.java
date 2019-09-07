package com.threecat.springboot.starter.bean.formatter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonFormatter implements Formatter
{
	@Override public <T> String format(T t)
	{
		return "JsonFormatter:" + JSON.toJSONString(t);
	}
}
