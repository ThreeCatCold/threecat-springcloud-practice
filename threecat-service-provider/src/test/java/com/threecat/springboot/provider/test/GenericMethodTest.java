package com.threecat.springboot.provider.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class GenericMethodTest
{
	private static final Map<Class<?>, Class<?>> BASIC_TYPE_CLASS_MAP = new HashMap<>(8);

	static
	{
		registerBasicTypes();
	}

	private static void registerBasicTypes()
	{
		BASIC_TYPE_CLASS_MAP.put(Boolean.class, boolean.class);
		BASIC_TYPE_CLASS_MAP.put(Byte.class, byte.class);
		BASIC_TYPE_CLASS_MAP.put(Character.class, char.class);
		BASIC_TYPE_CLASS_MAP.put(Double.class, double.class);
		BASIC_TYPE_CLASS_MAP.put(Float.class, float.class);
		BASIC_TYPE_CLASS_MAP.put(Integer.class, int.class);
		BASIC_TYPE_CLASS_MAP.put(Long.class, long.class);
		BASIC_TYPE_CLASS_MAP.put(Short.class, short.class);
	}

	public static <T> T getValue(String str, Class<T> clazz)
	{
		Class<?> basicTypeClass = getSimpleValueType(clazz);
		// 不是八种基础数据类型
		if (basicTypeClass == null)
		{
			try
			{
				return JSON.parseObject(str, new TypeReference<T>(){});
			}
			catch (Exception e)
			{
				System.err.println(e);
			}
		}
		try
		{
			Method method = basicTypeClass.getMethod("valueOf", String.class);
			return (T)method.invoke(basicTypeClass, str);
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static Class<?> getSimpleValueType(Class<?> clazz)
	{
		Assert.notNull(clazz, "Class is null!");
		for (Map.Entry<Class<?>, Class<?>> entry : BASIC_TYPE_CLASS_MAP.entrySet())
		{
			if (clazz == entry.getKey() || clazz == entry.getValue())
			{
				return entry.getKey();
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		String integerValue = getValue("P123", String.class);
		System.out.println("integerValue:" + integerValue);
	}
}
