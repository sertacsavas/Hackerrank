package com.sertac.hackerrank.JavaBigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();

		Comparator<String> customComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return new BigDecimal(o2).compareTo(new BigDecimal(o1));
			}
		};

		Arrays.sort(s, 0, n, customComparator);

		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}

}