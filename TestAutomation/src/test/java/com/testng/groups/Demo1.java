package com.testng.groups;

import org.testng.annotations.Test;

public class Demo1 {

	@Test(groups = { "smoke", "regression" })
	public void testMethod1() {
		
		System.out.println("Smoke group and regression group");
	}

	@Test(groups = { "smoke", "functional" })
	public void testMethod2() {
		System.out.println("Smoke group and functional group");
	}

	@Test(groups = { "regression", "funcitonal" })
	public void testMethod3() {
		
		System.out.println("functional group and regression group");
	}

}
