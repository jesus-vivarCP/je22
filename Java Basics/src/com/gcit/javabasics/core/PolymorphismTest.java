package com.gcit.javabasics.core;

public class PolymorphismTest {
	
	public Integer add(Integer a, Integer b){
		System.out.println("add integers" +a+b);
		return a+b;
	}
	
	public String add(String a, String b){
		System.out.println("add integers" +a+b);
		return a+b;
	}
	
	public void add(){
		System.out.println("add integers void");
	}
	
	protected int getLocalCode(String value, boolean isVal){
		return 1;
	}

}
