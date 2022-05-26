package com.testng.tests;

public class DemoPassParameters {
	
	public static void main(String[] args) {
		DemoPassParameters obj = new DemoPassParameters();
		obj.testdata("Admin", "admin123");
		obj.testdata("Anntte", "password123");
		obj.testdata("Ramesh", "ramesh123");
		
		
	}
	
	public void testdata(String name, String password) {
		
//		String userName = "Admin";
//		String password = "admin123";
		
		System.out.println(name + " : "+ password);
		
//		String userName1 = "Anntte";
//		String password1 = "password123";
		
//		System.out.println(userName1 + " : "+ password1);
		
//		String userName2 = "Ramesh";
//		String password2 = "ramesh123";
		
//		System.out.println(userName2 + " : "+ password2);
	}

}
