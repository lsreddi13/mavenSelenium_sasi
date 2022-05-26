package com.testng.tests;

import java.util.Arrays;

public class D2 {

	public static void main(String[] args) {

		int[][] twoD_arr = new int[10][20];
//		System.out.println(twoD_arr.length);
		twoD_arr[0][0] = 1;
		twoD_arr[0][1] = 23;
		twoD_arr[0][2] = 13;
		twoD_arr[0][3] = 43;
		twoD_arr[0][4] = 53;
		for(int i=0; i <twoD_arr.length; i++) {
			for(int j=0; j<twoD_arr.length; j++) {
				System.out.println(twoD_arr[i][j]);
			}
		}
		// String[] ar = new String[3];
//		
//		String[] ar2 = {"ss", "d2", "d3", "d4"};
//		
//		System.out.println(Arrays.toString(ar2));
//		
//		ar2[3]="dd";
//		
//		System.out.println(Arrays.toString(ar2));
//		
	}
}
