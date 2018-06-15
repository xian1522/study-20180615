package com.wj.springioc.my;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * 资源文件解析器
 * @author Administrator
 * 2018年6月15日下午4:37:21
 */
public class MyBeanDefinitionReader {
	//spring容器
	private MyApplicationContext registry;
	
	public MyBeanDefinitionReader(MyApplicationContext registry){
		this.registry = registry;
	}
	
	/**
	 * 解析资源文件
	 * 
	 * 2018年6月15日下午4:40:57
	 */
	public void loadBeanDefinitions(){
		
		String []configurations = this.getRegistry().getConfigurations();
		
		for(String location : configurations){
			loadBeanDefinition(location);
		}
	}
	
	private void loadBeanDefinition(String location) {
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder docBuiler = builderFactory.newDocumentBuilder();
			
			Document doc = docBuiler.parse(location);
			
			registerBeanDefinitions(doc);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 解析doc为beanDefinition,向容器中注册beanDefinition
	 * @param doc
	 * 2018年6月15日下午5:01:49
	 */
	public void registerBeanDefinitions(Document doc) {
		Element root = doc.getDocumentElement();
		doRegisterBeanDefinitions(root);
	}
	
	
	public void doRegisterBeanDefinitions(Element root) {
		
	}

	public MyApplicationContext getRegistry() {
		return registry;
	}
	
}
