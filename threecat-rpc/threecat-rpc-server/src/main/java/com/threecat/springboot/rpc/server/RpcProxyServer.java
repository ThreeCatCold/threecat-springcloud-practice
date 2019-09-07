package com.threecat.springboot.rpc.server;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer
{
	static ExecutorService threadPool = Executors.newCachedThreadPool();

	public static void publish(int port)
	{
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket(port);
			while (true)
			{
				Socket socket = serverSocket.accept();
				threadPool.submit(new SocketRequestHandler(socket));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(serverSocket);
		}
	}
}
