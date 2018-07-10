package com.wj.springioc.my;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wj.springioc.my.beans.MyBeanDefinition;
import com.wj.springioc.my.beans.PropertyValue;
import com.wj.springioc.my.beans.RuntimeReferenceBean;

/**
 * spring容器类
 * @author Administrator
 * 2018年6月15日下午4:24:14
 */
public class MyApplicationContext {
	//配置文件路径
	private String[] configurations;
	
	private final Map<String,MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,MyBeanDefinition>(256);
	
	private volatile List<String> beanDefinitionNames = new ArrayList<String>(256); 
	
	public MyApplicationContext(String[] configurations){
		this.configurations = configurations;
		loadBeanDefinitions(this);
	}
	
	/**
	 * 加载并解析配置文件 
	 * 2018年6月15日下午4:30:52
	 */
	public void loadBeanDefinitions(MyApplicationContext registry){
		MyBeanDefinitionReader beanDefinitionReader = new MyBeanDefinitionReader(registry); 
		beanDefinitionReader.loadBeanDefinitions();
	}

	public String[] getConfigurations() {
		return configurations;
	}

	public void registBeanDefinition(MyBeanDefinitionHolder bdHolder) {
		String beanName = bdHolder.getBeanName();
		MyBeanDefinition beanDefinition = bdHolder.getBeanDefinition();
		this.beanDefinitionNames.add(beanName);
		this.beanDefinitionMap.put(beanName, beanDefinition);
	}
	
	/**
	 *  获取spring 管理的bean实例
	 * @param beanName
	 * @param requiredType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName, Class<T> requiredType){
		
		
		
		MyBeanDefinition bd = this.beanDefinitionMap.get(beanName);
		
		Object beanInstance = null;
		
		try {
			String beanClassName = bd.getBeanClassName().toString();
			Class<?> beanClass = Class.forName(beanClassName);
			beanInstance = beanClass.newInstance();
			
			//处理依赖对象
			populateBean(bd,beanInstance,beanClass);
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T) beanInstance;
	}
	
	/**
	 * 处理property标签对象
	* @Description
	* @user w.j
	* @date 2018年7月10日 下午11:14:42
	* @throws
	 */
	private void populateBean(MyBeanDefinition bd, Object beanInstance,Class<?> beanClass) {
		List<PropertyValue> pvs = bd.getPropertyValues();
		for(PropertyValue pv: pvs) {
			String propertyName = pv.getName();
			Object propertyValue = pv.getValue();
			
			if(propertyValue instanceof RuntimeReferenceBean) {
				String beanName = ((RuntimeReferenceBean) propertyValue).getName();
				Object refOjbect = getBean(beanName,null);
				try {
					BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
					PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
					for(PropertyDescriptor pd : pds) {
						if(propertyName.equals(pd.getName())) {
							Method writeMethod = pd.getWriteMethod();
							writeMethod.invoke(beanInstance, refOjbect);
						}
					}
				} catch (IntrospectionException e) {
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
	}
}
