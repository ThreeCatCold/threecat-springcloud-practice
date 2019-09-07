package com.threecat.springboot.sso.entity;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User
{
	private Long userId;

	private String username;

	private String userPassword;

	private String gender;

	private String create;

	private String lastUpdate;

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getCreate()
	{
		return create;
	}

	public void setCreate(String create)
	{
		this.create = create;
	}

	public String getLastUpdate()
	{
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate)
	{
		this.lastUpdate = lastUpdate;
	}

	@Override public String toString()
	{
		return "User{" + "userId=" + userId + ", username='" + username + '\'' + ", userPassword='" + userPassword
				+ '\'' + ", gender='" + gender + '\'' + ", create='" + create + '\'' + ", lastUpdate='" + lastUpdate
				+ '\'' + '}';
	}
}
