package com.testng.tests;

public class DemoReturn {

	public static void main(String[] args) {
		DemoReturn obj = new DemoReturn();
//		obj.examName();
		System.out.println(obj.examName());
	}

	public String examName() {

		return "English Exam";
	}
}
