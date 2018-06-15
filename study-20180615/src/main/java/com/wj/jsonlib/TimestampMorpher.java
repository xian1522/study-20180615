package com.wj.jsonlib;

import java.sql.Timestamp;

import net.sf.ezmorph.ObjectMorpher;

@SuppressWarnings("rawtypes")
public class TimestampMorpher implements ObjectMorpher {
	
	private final Class<?> beanClass;
	//private MorpherRegistry morpherRegistry;
	
	
	public TimestampMorpher(Class beanClass){
		this.beanClass = beanClass;
		//this.morpherRegistry = morpherRegistry;
	}

	@Override
	public Class<?> morphsTo() {
		return beanClass;
	}

	@Override
	public boolean supports(Class paramClass) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object morph(Object paramObject) {
		//return paramObject.toString();
		String str = paramObject.toString().replace("T", " ");
		return Timestamp.valueOf(str);  
	}

}
