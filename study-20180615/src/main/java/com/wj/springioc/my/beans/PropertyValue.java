package com.wj.springioc.my.beans;
/**
* @Description <property>��ǩ��
* @author w.j
* @date 2018��7��8�� ����3:39:08
*/
public class PropertyValue {
	private final String name;
	private final Object value;
	
	public PropertyValue(String name, Object value) {
		this.name =  name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public Object getValue() {
		return value;
	}
	
	
}
