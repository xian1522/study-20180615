package com.wj.springaop;

public class SimpleProfiler {
	
	public void profile() {
		System.out.println("aop before");
	}
	
	public void profileAfter() {
		System.out.println("aop after");
	}
	
}
