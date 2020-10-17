package com.sertac.hackerrank.trial;

import java.math.BigInteger;

public class Trial1 {

	private static BigInteger factorial(BigInteger a) {
		if (a.compareTo(BigInteger.ONE) <= 0) {
			return BigInteger.ONE;
		}
		return a.multiply(factorial(a.subtract(BigInteger.ONE)));
	}

	public static void main(String[] args) {
		// System.out.println(factorial(new BigInteger("5001")));

		int[] values = new int[10];
		for (int i = 0; i < 10; ++i) {
			values[i] = i;
		}
		System.out.println(values[3]);

		int a = -3;
		System.out.println(a);
	}

}
