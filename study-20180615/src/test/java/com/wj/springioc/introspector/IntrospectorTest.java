package com.wj.springioc.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.TestCase;

public class IntrospectorTest extends TestCase{
	
	public void testIntrosepector(){
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(Peoper.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			Object obj = Peoper.class.newInstance();
			
			for(PropertyDescriptor pd : pds){
				//System.out.println(pd.getName()+":"+pd.getReadMethod() + "----" + pd.getWriteMethod());
				if("cat".equals(pd.getName())){
					Object obj1 = new Cat();
					Method method = pd.getWriteMethod();
					method.invoke(obj, obj1);
				}
			}
			Cat cat = ((Peoper)obj).getCat();
			cat.say();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
