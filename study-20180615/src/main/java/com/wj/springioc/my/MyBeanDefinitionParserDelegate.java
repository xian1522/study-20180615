package com.wj.springioc.my;

import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.wj.springioc.my.beans.MyBeanDefinition;
import com.wj.springioc.my.beans.PropertyValue;
import com.wj.springioc.my.beans.RuntimeReferenceBean;

/**
 * Bean����������
 * @author Administrator
 * 2018��6��19������8:09:07
 */
public class MyBeanDefinitionParserDelegate {
	
	private static final String PROPERTY_ELEMENT = "property";
	private static final String REF_ATTRIBUTE = "ref";
	private static final String NAME_ATTRIBUTE = "name";
	
	public static final String BEANS_NAMESPACE_URI = "http://www.springframework.org/schema/beans";
	
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
		
		parsePropertyValues(ele,bd);
		
		return new MyBeanDefinitionHolder(bd,beanName);
	}
	
	/**
	* @Description ����property��ǩ
	* @user w.j
	* @date 2018��7��8�� ����3:44:34
	* @throws
	*/
	private void parsePropertyValues(Element ele, MyBeanDefinition bd) {
		NodeList nodeList = ele.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element) {
				Element element = (Element)node;
				if(PROPERTY_ELEMENT.equals(element.getNodeName())) {
					String name = element.getAttribute(NAME_ATTRIBUTE);
					boolean hasRefAttribute = element.hasAttribute(REF_ATTRIBUTE);
					if(hasRefAttribute) {
						String refVal = element.getAttribute(REF_ATTRIBUTE);
						RuntimeReferenceBean ref = new RuntimeReferenceBean(refVal);
						PropertyValue pv = new PropertyValue(name,ref);
						bd.getPropertyValues().add(pv);
					}
				}
			}
		}
	}
	
	public String getNamespaceURI(Node node) {
		return node.getNamespaceURI();
	}
	
	public boolean isDefaultNamespace(Node node) {
		String namespaceURI = this.getNamespaceURI(node);
		return !StringUtils.hasLength(namespaceURI) || BEANS_NAMESPACE_URI.equals(namespaceURI); 
	}
	/**
	 * �������Ի�����
	* @Description
	* @user w.j
	* @date 2018��7��24�� ����12:02:19
	* @throws
	 */
	public void parseCustomElement(Node node) {
		// TODO Auto-generated method stub
		
	}

}
