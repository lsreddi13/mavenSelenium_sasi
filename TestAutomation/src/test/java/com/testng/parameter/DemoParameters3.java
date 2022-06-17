package com.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters3 {

	@Parameters({ "name", "id"})
	@Test
	public void testLogin(String x, String u) {
		System.out.println(x + " : "+u);
	}

}
