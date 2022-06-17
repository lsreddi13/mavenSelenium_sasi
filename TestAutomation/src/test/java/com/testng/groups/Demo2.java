package com.testng.groups;

import org.testng.annotations.Test;

public class Demo2 {

	@Test(groups = { "smoke" })
	public void testMethod11() {

		System.out.println("Smoke group ");
	}

	@Test(groups = { "functional" })
	public void testMethod12() {
		System.out.println("functional group");
	}

	@Test(groups = { "regression" })
	public void testMethod13() {

		System.out.println("regression group");
	}

}
