package com.gcit.javabasics.core;

public class SingletonExample {
	
	private static SingletonExample instance = null; 
	
	private SingletonExample(){
		
	}
	
	public SingletonExample getInstance(){
		synchronized (instance) {
			if(instance == null){
				instance = new SingletonExample();
			}
		}
		return instance;
	}
	
	public void method1(){
		synchronized (Integer.class) {
			System.out.println("Got lock on Integer");
			synchronized (String.class) {
				System.out.println("Got lock on String");
			}
			
		}
	}
	
	public void method2(){
		synchronized (Integer.class) {
			System.out.println("Got lock on String");
			synchronized (String.class) {
				System.out.println("Got lock on Integer");
			}
			
		}
	}

}
