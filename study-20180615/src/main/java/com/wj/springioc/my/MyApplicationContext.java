package com.wj.springioc.my;

/**
 * spring容器类
 * @author Administrator
 * 2018年6月15日下午4:24:14
 */
public class MyApplicationContext {
	//配置文件路径
	private String[] configurations;
	
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
}
