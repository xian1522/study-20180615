package com.wj.springioc.my;

public class MyBeanDefinition {
	private Object beanClass;

	public Object getBeanClassName() {
		return beanClass;
	}

	public void setBeanClassName(Object beanClass) {
		this.beanClass = (String)beanClass;
	}
	
	
	
}
