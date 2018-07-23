package com.wj.springaop;

public class FooServiceImpl implements FooService {

	@Override
	public void getFoo() {
		System.out.println("target mothod");
	}

}
