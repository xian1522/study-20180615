package com.wj.springioc;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wj.springioc.my.MyApplicationContext;

import junit.framework.TestCase;

public class ContainerTest extends TestCase{
	
	@SuppressWarnings("resource")
	public void testContainer(){
		ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
		PetStoreService service = context.getBean("petStore",PetStoreService.class);
		service.say();
		PetDao petDao = service.getPetdao();
		petDao.say();
	}
	
	public void testMyContainer() {
		MyApplicationContext mycontext = new MyApplicationContext(new String[] {"service.xml"});
		PetStoreService service = mycontext.getBean("petStore", PetStoreService.class);
		if(null != service) {
			service.say();
			PetDao petDao = service.getPetdao();
			petDao.say();
		}
	}
	
	public void testTemp() {
		Properties ps = System.getProperties();
		System.out.println(ps.getProperty("java.class.path"));
	}
	
}
