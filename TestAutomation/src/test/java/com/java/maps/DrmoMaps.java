package com.java.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DrmoMaps {

	public static void main(String[] args) {

		Map<Integer, String> course = new HashMap<>();
		System.out.println(course.size()); // 0
		course.put(1, "selenium");
		course.put(2, "Tosca");
		System.out.println(course.size()); // 2
		for (Entry<Integer, String> fff : course.entrySet()) {
			// Printing key-value pairs
			System.out.println(fff.getKey() + " - " + fff.getValue());
		}
		course.put(3, "UFT");
//		System.out.println(course.size()); // 3
//		System.out.println(course.get(4)); //null
//		course.clear();
//		System.out.println(course.size()); // 0
		System.out.println("print before update value : "+course.get(2));
		course.put(4, "Provar");
		
//		boolean b = course.containsValue("Provar");
//		System.out.println(b);
//		System.out.println("print updated value : "+course.get(2));

//		if map contains 4 course then print else print there is no 4 th course.
		
		
		//find 4th item exists or not
		boolean s1 = course.containsKey(4);
		
		//if exists then print the value for 4 th item
		if(s1==true) {
			System.out.println("4 th item value : "+course.get(4));
		}else {
			System.out.println("no 4th item");
		}
		
		//else print no 4 th item
		
		
		
		
		
	}

}
