package com.wj.springioc.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * spring容器类
 * @author Administrator
 * 2018年6月15日下午4:24:14
 */
public class MyApplicationContext {
	//配置文件路径
	private String[] configurations;
	
	private final Map<String,MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,MyBeanDefinition>(256);
	
	private volatile List<String> beanDefinitionNames = new ArrayList<String>(256); 
	
	public MyApplicationContext(String[] configurations){
		this.configurations = configurations;
	}
	
	/**
	 * 加载并解析配置文件 
	 * 2018年6月15日下午4:30:52
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
