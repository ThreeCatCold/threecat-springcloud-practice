package com.threecat.springboot.provider.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ThreadLocalWeakRefTest
{
	private static ThreadLocal<String> STR_CACHE = new ThreadLocal<>();

	public static void main(String[] args) throws Exception
	{
		STR_CACHE.set(new String("test"));
		System.gc();
		System.out.println(STR_CACHE.get());

		// strong reference
//		String s = new String("str1");
//		WeakReference<String> weakRef1 = new WeakReference<>(s);
//		SoftReference<String> softRef = new SoftReference<>(s);
//		s = null;
//		WeakReference<String> weakRef2 = new WeakReference<>("str2");
//		WeakReference<String> weakRef3 = new WeakReference<>(new String("str3"));
//		System.gc();
//		System.out.println(weakRef1.get());
//		System.out.println(weakRef2.get());
//		System.out.println(weakRef3.get());

		String s = new String("str1");
		WeakReference<String> weakRef1 = new WeakReference<>(new String("str1").intern());
		System.gc();
		System.out.println(weakRef1.get());
	}
}
