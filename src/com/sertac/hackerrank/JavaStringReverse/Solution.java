package com.sertac.hackerrank.JavaStringReverse;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();

		char[] charArray = A.toCharArray();

		boolean isPalindrome = true;

		for (int i = 0; i < charArray.length; ++i) {
			if (charArray[i] != charArray[charArray.length - i - 1]) {
				isPalindrome = false;
			}
		}

		System.out.println(isPalindrome ? "Yes" : "No");

	}
}
