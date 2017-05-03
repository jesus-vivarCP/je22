package com.gcit.javabasics.core;

public class Man implements Animal{

	@Override
	public void walks() {
		System.out.println("walks on 2 legs");
		
	}

	@Override
	public void sound() {
		System.out.println("talks");
		
	}

}
