package com.java.finalKeyword;

public class DemoFinalKeyword extends AA {

	final int val = 99;

	void testmethod() {
		val = 101;
		System.out.println(val);
	}

	final void demo() {

		System.out.println("FinalMethod_Java Class Method");

	}

	public static void main(String[] args) {
		DemoFinalKeyword dd = new DemoFinalKeyword();

		System.out.println(dd.val);
//		dd.testmethod();
		dd.demo();

	}
}
