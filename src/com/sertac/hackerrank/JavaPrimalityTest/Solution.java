package com.sertac.hackerrank.JavaPrimalityTest;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String n = scanner.nextLine();

		scanner.close();

		BigInteger b = new BigInteger(n);

		System.out.println((b.isProbablePrime(10) ? "prime" : "not prime"));

	}
}
