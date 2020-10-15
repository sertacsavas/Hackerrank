package com.sertac.hackerrank;

import java.util.Scanner;

public class Loops {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			for (int j = 0; j < n; j++) {
				int res = a;
				for (int z = 0; z < j; z++) {
					res = res + (int) (Math.pow(t, j) * b);
				}
				System.out.print(res + " ");
			}
			System.out.println();

		}
		in.close();
	}
}
