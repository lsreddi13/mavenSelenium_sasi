package com.testng.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeTestDemo {

	@BeforeClass
	public void openBrowser() {
		System.out.println("open browser chrome browser");
		System.out.println("open applicaiton");
	}

	@BeforeMethod
	public void login() {
		System.out.println("Login as user");
	}

	@AfterMethod
	public void testLogout() {
		System.out.println("Logout as user");
	}

	@Test
	public void testLogin() {
//		System.out.println("open browser chrome browser");
//		System.out.println("open applicaiton");
//		System.out.println("Login as Admin user");
		System.out.println("Logout as Admin user.");
	}

	@Test(priority = 1)
	public void testVerifyDashboard() {
//		System.out.println("open browser chrome browser");
//		System.out.println("open applicaiton");
//		System.out.println("Login as user");
		System.out.println("Verify Dashboard page");
//		System.out.println("Logout as user");

	}

	@Test(priority = 2)
	public void testVerifyAdmin() {
//		System.out.println("open browser chrome browser");
//		System.out.println("open applicaiton");
//		System.out.println("Login as Admin user");
		System.out.println("Verify Admin page");
//		System.out.println("Logout as Admin user");

	}

}
