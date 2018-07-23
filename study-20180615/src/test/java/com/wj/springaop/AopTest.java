package com.wj.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class AopTest extends TestCase{
	
	public void testAop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("plain.xml");
		FooService service = (FooService)context.getBean("fooService");
		service.getFoo();
	}
}
