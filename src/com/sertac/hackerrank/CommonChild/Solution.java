package com.sertac.hackerrank.CommonChild;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the commonChild function below.
	static int commonChild(String s1, String s2) {
		int length1 = s1.length();
		int length2 = s2.length();
		int[][] commonLengths = new int[length1 + 1][length2 + 1];
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					commonLengths[i][j] = commonLengths[i - 1][j - 1] + 1;
				} else {
					commonLengths[i][j] = Math.max(commonLengths[i - 1][j], commonLengths[i][j - 1]);
				}
			}
		}
		return commonLengths[length1][length2];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = commonChild(s1, s2);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
