package com.sertac.hackerrank.GreedyFlorist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the getMinimumCost function below.
	static int getMinimumCost(int k, int[] c) {
		int result = 0;

		Arrays.sort(c);
		int costMultiplier = 0;
		for (int i = c.length - 1; i >= 0; i--) {

			for (int j = 0; j < k; j++) {
				if (i - j >= 0) {
					result += (1 + costMultiplier) * c[i - j];
				} else {
					return result;
				}
			}
			i = i - k + 1;
			costMultiplier++;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int minimumCost = getMinimumCost(k, c);

		bufferedWriter.write(String.valueOf(minimumCost));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
