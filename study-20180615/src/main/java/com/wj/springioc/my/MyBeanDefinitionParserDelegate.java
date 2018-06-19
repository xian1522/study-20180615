package com.wj.springioc.my;

import org.w3c.dom.Element;

/**
 * Bean����������
 * @author Administrator
 * 2018��6��19������8:09:07
 */
public class MyBeanDefinitionParserDelegate {
	
	/**
	 * ������ע��BeanDefinition
	 * @param node
	 * @return
	 * 2018��6��19������8:28:03
	 */
	public MyBeanDefinitionHolder parseBeanDefinitionElement(Element ele) {
		String beanName = ele.getAttribute("id");
		String beanClass = ele.getAttribute("class");
		
		MyBeanDefinition bd = new MyBeanDefinition();
		bd.setBeanClassName(beanClass);
		
		return new MyBeanDefinitionHolder(bd,beanName);
	}

}
