package com.threecat.springboot.provider.test;

import jodd.crypt.BCrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BCryptEncoderTest
{
	@Test
	public void testBCrypt()
	{
		String originPassword = "123";
		String encryptPassword = BCrypt.hashpw(originPassword, BCrypt.gensalt());

		System.out.println(encryptPassword);
		System.out.println(BCrypt.checkpw(originPassword, encryptPassword));
	}
}
