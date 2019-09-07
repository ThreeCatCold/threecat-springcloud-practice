package com.threecat.springboot.rpc.server;

import com.threecat.springboot.rpc.api.RpcInvokeProtocol;
import com.threecat.springboot.rpc.service.impl.CommonServiceImpl;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class SocketRequestHandler implements Runnable
{
	private Socket socket;

	public SocketRequestHandler(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		// do socket
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		try
		{
			ois = new ObjectInputStream(socket.getInputStream());
			RpcInvokeProtocol request = (RpcInvokeProtocol)ois.readObject();
			Object result = doRequest(request);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(result);
			oos.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(ois);
			IOUtils.closeQuietly(oos);
		}
	}

	private Object doRequest(RpcInvokeProtocol request)
	{
		Object result = null;
		try
		{
			Object[] args = request.getParams();
			Class<?>[] types = null;
			if (args != null)
			{
				types = new Class[args.length];
				for (int i = 0; i < args.length; i++)
				{
					types[i] = args[i].getClass();
				}
			}
			Class serviceClass = Class.forName(request.getServiceClazz());

			// 此处可以优化为从spring容器获取，这里为了例子直接写实现类了
//			Object service = serviceClass.newInstance();
			Object service = new CommonServiceImpl();
			String methodName = request.getMethodName();
			Method method = service.getClass().getMethod(methodName, types);
			result = method.invoke(service, args);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
//		catch (InstantiationException e)
//		{
//			e.printStackTrace();
//		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
