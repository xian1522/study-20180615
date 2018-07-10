package com.wj.springioc.my.beans;
/**
* @Description <property>标签类
* @author w.j
* @date 2018年7月8日 下午3:39:08
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
