package com.wj.springioc.my.beans;

/**
 * <ref/>标签类
* @Description 
* @author w.j
* @date 2018年7月8日 下午3:56:41
 */
public class RuntimeReferenceBean {
	
	private String name;
	
	public RuntimeReferenceBean(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
