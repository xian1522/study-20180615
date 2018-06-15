package com.wj.springioc;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerTest extends TestCase{
	
	@SuppressWarnings("resource")
	public void testContainer(){
		ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
		PetStoreService service = context.getBean("petStore",PetStoreService.class);
		service.say();
	}
}
