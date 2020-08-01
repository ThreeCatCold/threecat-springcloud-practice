package com.threecat.springboot.provider.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CheckRange
{
	private static Class[] checkParamType = new Class[] { Integer.class, Float.class, Long.class, Short.class,
			Double.class };

	public static <T> boolean checkRange(T min, T max, T value)
	{
		if (min == null || max == null || value == null)
		{
			throw new RuntimeException("CheckRangeNullValueException.");
		}
		if (min.getClass() != max.getClass() || max.getClass() != value.getClass())
		{
			throw new RuntimeException("CheckRangeNoSameTypeException.");
		}
		Class<?> checkParamType = getParamType(value);
		if (checkParamType == null)
		{
			throw new RuntimeException("CheckRangeUnknownTypeException.");
		}
		return invokeCompareToMethod(value, max, checkParamType) <= 0
				&& invokeCompareToMethod(value, min, checkParamType) > 0;
	}

	private static <T> int invokeCompareToMethod(T o1, T o2, Class<?> checkParamType)
	{
		Method compereToMethod = null;
		try
		{
			compereToMethod = o1.getClass().getMethod("compareTo", checkParamType);
			return (int) compereToMethod.invoke(o1, o2);
		}
		catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	private static Class<?> getParamType(Object object)
	{
		for (Class clazz : checkParamType)
		{
			if (clazz == object.getClass())
			{
				return clazz;
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		System.out.println(checkRange(1, 30, 2));
	}
}
