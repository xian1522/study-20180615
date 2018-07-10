package com.wj.springioc.my;

import com.wj.springioc.my.beans.MyBeanDefinition;

/**
 * BeanDefinition��װ��
 * @author Administrator
 * 2018��6��19������8:25:45
 */
public class MyBeanDefinitionHolder {
	
	private final MyBeanDefinition beanDefinition;
	private final String beanName;
	
	public MyBeanDefinitionHolder(MyBeanDefinition beanDefinition,String beanName){
		this.beanDefinition = beanDefinition;
		this.beanName = beanName;
	}

	public MyBeanDefinition getBeanDefinition() {
		return beanDefinition;
	}

	public String getBeanName() {
		return beanName;
	}
	
	
}
