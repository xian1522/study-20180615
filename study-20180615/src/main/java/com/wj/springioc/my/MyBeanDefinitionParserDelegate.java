package com.wj.springioc.my;

import org.w3c.dom.Element;

/**
 * Bean解析代理类
 * @author Administrator
 * 2018年6月19日下午8:09:07
 */
public class MyBeanDefinitionParserDelegate {
	
	/**
	 * 解析并注册BeanDefinition
	 * @param node
	 * @return
	 * 2018年6月19日下午8:28:03
	 */
	public MyBeanDefinitionHolder parseBeanDefinitionElement(Element ele) {
		String beanName = ele.getAttribute("id");
		String beanClass = ele.getAttribute("class");
		
		MyBeanDefinition bd = new MyBeanDefinition();
		bd.setBeanClassName(beanClass);
		
		return new MyBeanDefinitionHolder(bd,beanName);
	}

}
