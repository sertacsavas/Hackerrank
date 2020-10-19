package com.sertac.hackerrank.JavaExceptionHandling2;

import java.util.Scanner;

class MyCalculator {

	public char[] power(int n, int p) throws Exception {
		if (n == 0 && p == 0) {
			throw new Exception("n and p should not be zero.");
		}
		if (n < 0 || p < 0) {
			throw new Exception("n or p should not be negative.");
		}

		if (p == 0) {
			return String.valueOf(1).toCharArray();
		}

		int result = n;
		for (int i = 1; i < p; i++) {
			result *= n;
		}

		return String.valueOf(result).toCharArray();
	}
}

public class Solution {
	public static final MyCalculator my_calculator = new MyCalculator();
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int p = in.nextInt();

			try {
				System.out.println(my_calculator.power(n, p));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}