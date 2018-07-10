package com.wj.springioc.my.beans;

import java.util.ArrayList;
import java.util.List;

/**
* @Description <bean>��ǩ��  
* @author w.j
* @date 2018��7��8�� ����3:36:13
*/
public class MyBeanDefinition {
	private Object beanClass;
	
    private List<PropertyValue> propertyValues;
    
    public MyBeanDefinition() {
    	List<PropertyValue> pvList = new ArrayList<PropertyValue>(0);
    	setPropertyValues(pvList);
    }

	public Object getBeanClassName() {
		return beanClass;
	}

	public void setBeanClassName(Object beanClass) {
		this.beanClass = (String)beanClass;
	}

	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}
	
	public Class<?> getBeanClass(){
		return (Class<?>) beanClass;
	}
	
	
}
