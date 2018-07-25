package com.wj.springaop;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wj.springioc.aop.FooService;
import com.wj.springioc.my.MyApplicationContext;

import junit.framework.TestCase;

public class AopTest extends TestCase{
	
	@SuppressWarnings("resource")
	public void testAop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("plain.xml");
		FooService service = (FooService)context.getBean("fooService");
		service.getFoo();
	}
	
	public void testMyAop() {
		MyApplicationContext context = new MyApplicationContext(new String[]{"service.xml"});
		FooService service = context.getBean("fooService", FooService.class);
		service.getFoo();
	}
	
	public void testHandlers() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Enumeration<URL> urls = classLoader.getResources("meta/spring.handlers");
			Properties pro = new Properties();
			while(urls.hasMoreElements()) {
				URL url = urls.nextElement();
				URLConnection connection = url.openConnection();
				InputStream inputStream = connection.getInputStream();
				try {
					pro.load(inputStream);
				}finally {
					inputStream.close();
				}
			}
			System.out.println(pro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
