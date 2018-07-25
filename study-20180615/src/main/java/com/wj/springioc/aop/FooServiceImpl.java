package com.wj.springioc.aop;

public class FooServiceImpl implements FooService {

	@Override
	public void getFoo() {
		System.out.println("target mothod");
	}

}
