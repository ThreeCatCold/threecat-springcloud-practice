package com.threecat.springboot.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class TimeChannelHandler extends ChannelInitializer<SocketChannel>
{
	@Override protected void initChannel(SocketChannel ch) throws Exception
	{
		ch.pipeline().addLast(new TimeServerHandler());
	}
}
