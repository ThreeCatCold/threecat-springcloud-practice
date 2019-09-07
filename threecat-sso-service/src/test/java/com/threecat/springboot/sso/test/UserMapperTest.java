package com.threecat.springboot.sso.test;

import com.threecat.springboot.sso.SSOApplication;
import com.threecat.springboot.sso.entity.User;
import com.threecat.springboot.sso.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = { SSOApplication.class })
public class UserMapperTest
{
	@Autowired
	private BeanFactory beanFactory;

	@Test
	public void testSelectByPrimaryKey()
	{
		System.out.println(beanFactory.getBean(SqlSessionFactoryBean.class));
		UserMapper userMapper = beanFactory.getBean(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
	}
}
