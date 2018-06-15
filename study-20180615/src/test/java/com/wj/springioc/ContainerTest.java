package com.wj.springioc;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerTest extends TestCase{
	
	public void testContainer(){
		ApplicationContext conext = new ClassPathXmlApplicationContext("service.xml");
	}
}
