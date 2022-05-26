package com.testng.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider1 {
	@Test(enabled = false, priority = 0, description = "print values from data provider", dataProvider = "test1")
	public void verifyData1(String a, Integer n2) {
		System.out.println(a + " " + n2);
	}

	@DataProvider(name = "test1")
	public Object[][] createData1() {

		return new Object[][] { { "Cedric", new Integer(36) }, { "Anne", new Integer(37) }, };
	}

	@DataProvider(name = "userdata")
	public Object[][] getTestData() {

		return new Object[][] { { "Admin", "admin123" }, // first row
				{ "Annette", "password123" }, // second row
				{ "Ramesh", "ramesh123" }, // third row
				{ "Santhosh", "santhosh123" }, // third row
		};
	}

	@DataProvider(name = "createUSer")
	public Object[][] getCreateUserTestData() {

		return new Object[][] {
				{ "Admin", "peter", "Enabled", "Ramesh", "ramesh123", "ramesh123" }, // first row
				{ "ESS", "daniel", "Enabled", "Vikram", "vikram123", "vikram123" }, // second row
				{ "Admin", "peter", "Enabled", "santhos", "santhos", "santhos" }, // third row
				{ "ESS", "daniel", "Enabled", "Raju", "raju123", "raju123" } // third row
		};
	}

	@Test(dataProvider = "createUSer")
	public void printNewUserData(String a, String b, String c, String d, String e, String f) {
		System.out.println(a + " : " + b + " : " + c + " : " + d + " : " + e + " : " + f);
		
		

	}

	@Test(dataProvider = "userdata", enabled = false)
	public void printUserLogindata(String name, String password) {
		System.out.println(name + " : " + password);
	}

}
