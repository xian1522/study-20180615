package com.wj.springioc.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * spring������
 * @author Administrator
 * 2018��6��15������4:24:14
 */
public class MyApplicationContext {
	//�����ļ�·��
	private String[] configurations;
	
	private final Map<String,MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,MyBeanDefinition>(256);
	
	private volatile List<String> beanDefinitionNames = new ArrayList<String>(256); 
	
	public MyApplicationContext(String[] configurations){
		this.configurations = configurations;
	}
	
	/**
	 * ���ز����������ļ� 
	 * 2018��6��15������4:30:52
	 */
	public void loadBeanDefinitions(MyApplicationContext registry){
		MyBeanDefinitionReader beanDefinitionReader = new MyBeanDefinitionReader(registry); 
		beanDefinitionReader.loadBeanDefinitions();
	}

	public String[] getConfigurations() {
		return configurations;
	}

	public void registBeanDefinition(MyBeanDefinitionHolder bdHolder) {
		String beanName = bdHolder.getBeanName();
		MyBeanDefinition beanDefinition = bdHolder.getBeanDefinition();
		this.beanDefinitionNames.add(beanName);
		this.beanDefinitionMap.put(beanName, beanDefinition);
	}
}
