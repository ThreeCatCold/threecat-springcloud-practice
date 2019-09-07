package com.threecat.springboot.sso.mapper;

import com.threecat.springboot.sso.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper
{
	User selectByPrimaryKey(@Param("user_id") long userId);
}
