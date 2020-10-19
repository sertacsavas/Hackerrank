package com.sertac.hackerrank.JavaSubarray;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		int count = 0;

		for (int i = 0; i < a.length; i++) {

			for (int j = i; j < a.length; j++) {
				int sumOfSub = 0;
				for (int z = 0; z < a.length - j; z++) {
					sumOfSub += a[i + z];
					// System.out.println("a[" + (i + z) + "]");
				}
				// System.out.println(sumOfSub);
				if (sumOfSub < 0) {
					count++;
				}
			}
		}

		System.out.println(count);

		scan.close();
	}
}