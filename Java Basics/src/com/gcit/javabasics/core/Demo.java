package com.gcit.javabasics.core;

import java.util.HashMap;
import java.util.Map;

public class Demo {
	public static void main(String[] args) {
		
		Person p1 = new Person(1, "John");
		Person p2 = new Person(1, "John");
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		if(p1.equals(p2)){
			System.out.println("Objects are equal ");
		}else{
			
			System.out.println("Objects are not equal");
		}
		
		Map<Person, String> testMap = new HashMap<>();
		testMap.put(p1, "Object 1");
		testMap.put(p2, "Object 2");
		
		System.out.println("Size of my Map: " +testMap.size());
		System.out.println(testMap.get(p1));
		
	}

}