package com.gcit.javabasics.core;

public class Dog implements Animal{

	@Override
	public void walks() {
		System.out.println("walks on 4 legs");
		
	}

	@Override
	public void sound() {
		System.out.println("barks");
		
	}

}
