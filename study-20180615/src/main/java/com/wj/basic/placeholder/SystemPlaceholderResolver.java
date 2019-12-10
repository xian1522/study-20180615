package com.wj.basic.placeholder;

public class SystemPlaceholderResolver implements PlaceholderResolver {

	@Override
	public String resolvePlaceholder(String placeholderName) {
		
		return System.getProperty(placeholderName);
	}

}
