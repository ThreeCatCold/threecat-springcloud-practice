package com.threecat.springboot.netty.nio;

import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer implements InitializingBean
{
	private int port;

	private Selector selector;

	private ByteBuffer buffer = ByteBuffer.allocate(1024);

	public NIOServer(int port)
	{
		this.port = port;
	}

	/**
	 * 初始化
	 * @throws Exception
	 */
	@Override public void afterPropertiesSet() throws Exception
	{
		ServerSocketChannel server = ServerSocketChannel.open();
		server.bind(new InetSocketAddress(port));

		// BIO升级版本NIO，为了兼容BIO，NIO模型默认采用阻塞式
		server.configureBlocking(false);

		selector = Selector.open();
		server.register(selector, SelectionKey.OP_ACCEPT);
	}

	public void listen()
	{
		try
		{
			while (true)
			{
				selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iter = keys.iterator();
				while (iter.hasNext())
				{
					SelectionKey key = iter.next();
					process(key);
					iter.remove();
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 针对每一种状态给一种反应
	 * @param key
	 */
	private void process(SelectionKey key) throws IOException
	{
		if (key.isAcceptable())
		{
			ServerSocketChannel server = (ServerSocketChannel)key.channel();
			SocketChannel channel = server.accept();
			channel.configureBlocking(false);
			key = channel.register(selector, SelectionKey.OP_READ);
		}
		if (key.isReadable())
		{
			// 从多路复用器中拿到客户端的引用
			SocketChannel channel = (SocketChannel)key.channel();
			int len = channel.read(buffer);
			if (len > 0)
			{
				buffer.flip();
				String message = new String(buffer.array(), 0, len);
				System.out.println("read message:" + message);
				key = channel.register(selector, SelectionKey.OP_WRITE);
				message += "finish read it!";
				key.attach(message);
			}
		}

		if (key.isWritable())
		{
			SocketChannel channel = (SocketChannel)key.channel();
			String message = (String)key.attachment();
			channel.write(ByteBuffer.wrap(("output: " + message).getBytes()));
			channel.close();
		}
	}
}
