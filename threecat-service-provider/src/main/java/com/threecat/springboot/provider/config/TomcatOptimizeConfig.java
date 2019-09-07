package com.threecat.springboot.provider.config;

import org.apache.catalina.LifecycleListener;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.coyote.http11.Http11AprProtocol;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatOptimizeConfig
{
	private boolean aprEnabled;

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory()
	{
		TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();

		tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizerImpl());
		if (aprEnabled)
		{
			LifecycleListener aprLifecycle = new AprLifecycleListener();
			tomcatFactory.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
			tomcatFactory.addContextLifecycleListeners(aprLifecycle);
		}
		return tomcatFactory;
	}

	class TomcatConnectorCustomizerImpl implements TomcatConnectorCustomizer
	{

		@Override public void customize(Connector connector)
		{
			if (aprEnabled)
			{
				Http11AprProtocol protocol = (Http11AprProtocol) connector.getProtocolHandler();
				// 最大连接数
				protocol.setMaxConnections(500);
				// 初始化时创建的线程数
				protocol.setMinSpareThreads(20);
				// 设置最大线程数
				protocol.setMaxThreads(500);
				protocol.setConnectionTimeout(30000);
				// 指定当所有可以使用的处理请求的线程数都被使用时，可以放到处理队列中的请求数，超过这个数的请求将不予处理
				protocol.setAcceptCount(700);
				return;
			}

			Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
			// 最大连接数
			protocol.setMaxConnections(500);
			// 初始化时创建的线程数
			protocol.setMinSpareThreads(20);
			// 设置最大线程数
			protocol.setMaxThreads(500);
			protocol.setConnectionTimeout(30000);
			// 指定当所有可以使用的处理请求的线程数都被使用时，可以放到处理队列中的请求数，超过这个数的请求将不予处理
			protocol.setAcceptCount(700);
		}
	}
}
