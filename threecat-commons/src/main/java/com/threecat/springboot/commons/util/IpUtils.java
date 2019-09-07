package com.threecat.springboot.commons.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IpUtils
{
	public static String ip()
	{
		String localIP = "127.0.0.1";
		try
		{
			for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces
					.hasMoreElements(); )
			{
				NetworkInterface networkInterface = interfaces.nextElement();
				if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp())
				{
					continue;
				}
				Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
				while (addresses.hasMoreElements())
				{
					InetAddress address = addresses.nextElement();
					if (address instanceof Inet4Address)
					{
						localIP = address.getHostAddress();
						break;
					}
				}
			}
		}
		catch (SocketException e)
		{
			// do nothing
		}
		return localIP;
	}

}
