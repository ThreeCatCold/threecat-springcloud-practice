package com.threecat.springboot.commons.enumeration;

public enum EnumService
{
	SSO("00001", "sso-service"),
	RED_PACKET("00010", "red-packet-service");

	private String id;

	private String message;

	EnumService(String id, String message)
	{
		this.id = id;
		this.message = message;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
