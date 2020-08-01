package com.threecat.springboot.rpc.nio.buffer;

import java.nio.IntBuffer;

public class BasicBuffer
{
	public static void main(String[] args)
	{
		// 创建一个buffer，大小为5，即可以存放5个int
		int bufferCapacity = 5;
		IntBuffer intBuffer = IntBuffer.allocate(bufferCapacity);
		for (int i = 0; i < intBuffer.capacity(); i++)
		{
			intBuffer.put(i);
		}
		// 从buffer读取数据,其实也就是调整了内部position和limit的位置
		intBuffer.flip();
		while (intBuffer.hasRemaining())
		{
			System.out.println(intBuffer.get());
		}

	}
}
