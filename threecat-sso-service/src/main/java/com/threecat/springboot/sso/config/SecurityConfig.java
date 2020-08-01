package com.threecat.springboot.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	//基于内存的用户认证
	@Bean
	public UserDetailsService userDetailsService()
	{
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("threecat1").password("123").authorities("p1").build());
		manager.createUser(User.withUsername("threecat2").password("123").authorities("p2").build());
		return manager;
	}

	/**
	 * 安全拦截机制
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				//为每个登录成功的用户新创建一个session
				.sessionManagement()
				//如果设置成STATELESS，代表无状态模式，适用于rest风格api
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

				//关闭跨站请求伪造
				.and()
				.csrf().disable()
				.authorizeRequests()
				//匹配路径
				.antMatchers("/path1").hasAuthority("p1")
				.antMatchers("/path2").hasAuthority("p2")
				//出去上面的匹配路径，其他请求都可以访问
				.anyRequest().authenticated()
				//这种汇总的应当放至最后
				//.anyRequest().permitAll()

				//允许表单登录
				.and()
				.formLogin().successForwardUrl("/login-success")
				.and()
				.httpBasic()

				// logout
				.and()
				.logout()
				.logoutUrl("")
				.logoutSuccessUrl("")
				.logoutSuccessHandler(null)
				.addLogoutHandler(null)
				.invalidateHttpSession(true);
		super.configure(http);
	}

	/**
	 * 密码编辑器
	 * @return
	 */
	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}

	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}
