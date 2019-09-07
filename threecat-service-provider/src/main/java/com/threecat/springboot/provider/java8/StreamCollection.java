package com.threecat.springboot.provider.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCollection
{
	public static void main(String[] args)
	{
		List<User> userList = new ArrayList<>();

		userList.add(new User("1"));
		userList.add(new User("2"));
		userList.forEach(User::showUser);

		Stream<User> userStream = userList.stream();

		long count = userStream.filter(user -> user.getId().equals("1")).count();
		userStream.close();
		System.out.println(count);
		userList.forEach(User::showUser);

		/*userList.stream()*/userStream.map(user -> {
			user.setId(user.getId() + "1");
			return user;
		}).forEach(User::showUser);
		userList.forEach(User::showUser);

		Map<String, String> map = new HashMap<>();

	}
}

class User
{
	private String id;

	public User(String id)
	{
		this.id = id;
	}

	public void showUser()
	{
		System.out.println("user:" + id);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
