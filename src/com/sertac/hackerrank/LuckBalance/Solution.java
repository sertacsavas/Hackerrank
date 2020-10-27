package com.sertac.hackerrank.LuckBalance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the luckBalance function below.
	static int luckBalance(int k, int[][] contests) {
		int luckBalance = 0;
		int looseBalance = k;
		int[] importantContests = new int[contests.length];

		for (int i = 0; i < contests.length; i++) {
			int tempLuck = contests[i][0];
			boolean isImportant = contests[i][1] == 1;

			if (isImportant) {
				importantContests[i] = tempLuck;

			} else {
				luckBalance += tempLuck;
			}
		}

		Arrays.sort(importantContests);

		for (int i = importantContests.length - 1; i >= 0; i--) {
			if (importantContests[i] > 0) {
				if (looseBalance > 0) {
					luckBalance += importantContests[i];
					looseBalance--;
				} else {
					luckBalance -= importantContests[i];
				}
			} else {
				break;
			}
		}

		return luckBalance;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[][] contests = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] contestsRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int contestsItem = Integer.parseInt(contestsRowItems[j]);
				contests[i][j] = contestsItem;
			}
		}

		int result = luckBalance(k, contests);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
