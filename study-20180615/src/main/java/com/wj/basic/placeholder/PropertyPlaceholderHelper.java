package com.wj.basic.placeholder;

/**
* 点位符解析工具
* @Description 
* @author w.j
* @date 2019年11月25日 下午8:23:27
*/
public class PropertyPlaceholderHelper {
	
	private String prefix = "${";
	private String sufferfix = "}";
	
	public String resloveRequiredPlaceHolder(String path) {
		
		StringBuilder result = new StringBuilder(path);
		
		int startIndex = path.indexOf(prefix);
		int endIndex = path.indexOf(sufferfix);
		
		PlaceholderResolver pr = new SystemPlaceholderResolver();
		
		String placeholder = result.substring(startIndex+prefix.length(),endIndex);
		
		// 策略模式
		String placeHoderValue = doReslovePlaceholder(placeholder,pr);
		
		result.replace(startIndex, endIndex+sufferfix.length(), placeHoderValue);
		
		return result.toString();
	}
	
	private String doReslovePlaceholder(String placeholder, PlaceholderResolver pr) {
		
		return pr.resolvePlaceholder(placeholder);
	}
	
	public static void main(String args[]) {
		System.setProperty("spring", "xxx");
		String value = new PropertyPlaceholderHelper().resloveRequiredPlaceHolder("${spring}:app");
		
		System.out.println(value);
	}
}
