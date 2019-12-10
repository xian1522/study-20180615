package com.wj.springioc;

public class PetStoreService {
	
	private PetDao petdao;
	
	public PetStoreService() {
		System.out.println("init");
	}
	
	public void say(){
		System.out.println("hello");
	}

	public PetDao getPetdao() {
		return petdao;
	}

	public void setPetdao(PetDao petdao) {
		this.petdao = petdao;
	}

	
}
