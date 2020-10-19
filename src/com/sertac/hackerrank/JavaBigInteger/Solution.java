package com.sertac.hackerrank.JavaBigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger a = scan.nextBigInteger();
		BigInteger b = scan.nextBigInteger();

		System.out.println(a.add(b));
		System.out.println(a.multiply(b));
		scan.close();

	}
}