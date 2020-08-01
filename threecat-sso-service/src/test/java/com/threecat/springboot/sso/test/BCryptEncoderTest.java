package com.threecat.springboot.sso.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
