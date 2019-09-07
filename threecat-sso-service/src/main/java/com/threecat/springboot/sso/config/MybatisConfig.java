package com.threecat.springboot.sso.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.threecat.springboot.sso.mapper"})
public class MybatisConfig
{
}
