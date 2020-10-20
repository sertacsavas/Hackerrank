package com.sertac.hackerrank.NewYearChaos;

import java.util.Scanner;

public class Solution {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int[] a = new int[q.length];
		int moves = 0;

		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}

		for (int i = 0; i < q.length; i++) {

			if (q[i] != a[i]) {
				if (i + 1 < q.length && q[i] == a[i + 1]) {
					int temp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = temp;

					moves++;
				} else if (i + 2 < q.length && q[i] == a[i + 2]) {
					int temp1 = a[i];
					int temp2 = a[i + 1];

					a[i] = q[i];
					a[i + 1] = temp1;
					a[i + 2] = temp2;

					moves += 2;

				} else {
					System.out.println("Too chaotic");
					return;
				}
			}
		}

		System.out.println(moves);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
