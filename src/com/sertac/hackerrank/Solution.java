package com.sertac.hackerrank;

import java.util.Scanner;

public class Solution {
	static Scanner in = new Scanner(System.in);
	private static boolean flag = true;
	private static int B = initializeClassVariable();
	private static int H = initializeClassVariable();

	private static int initializeClassVariable() {

		int i = in.nextInt();
		if (flag && i <= 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
			flag = false;
		}
		return i;
	}

	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}// end of main

}// end of class
