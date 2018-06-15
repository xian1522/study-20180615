package com.wj.springioc.my;

/**
 * spring������
 * @author Administrator
 * 2018��6��15������4:24:14
 */
public class MyApplicationContext {
	//�����ļ�·��
	private String[] configurations;
	
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
}
