package com.gcit.javabasics.core;

public class AnimalFactory {
	
	public Animal getAnimal(String name){
		if("Man".equalsIgnoreCase(name)){
			return new Man();
		}else if("Snake".equalsIgnoreCase(name)){
			return new Snake();
		}else if("Dog".equalsIgnoreCase(name)){
			return new Dog();
		}
		return null;
	}
}
