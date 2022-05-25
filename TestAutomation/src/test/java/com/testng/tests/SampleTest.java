package com.testng.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {

	@BeforeClass
	public void setUp() {
		System.out.println("open browser");
	}

	@Test
	public void aFastTest() {
		System.out.println("Fast test");
	}

	@Test
	public void aElowTest() {
		System.out.println("Slow test");
	}

}
