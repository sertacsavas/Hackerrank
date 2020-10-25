package com.sertac.hackerrank.SherlockandtheValidString;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the isValid function below.
	static String isValid(String s) {
		int[] counts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int code = s.charAt(i) - 'a';
			counts[code]++;
		}

		int temp = 0;
		boolean deleted = false;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0) {
				if (temp == 0) {
					temp = counts[i];
				}

				if (temp != counts[i]) {

					if (deleted) {
						return "NO";
					}

					if (Math.abs(temp - counts[i]) == 1 || counts[i] == 1 || temp == 1) {
						deleted = true;
					} else {
						return "NO";
					}
				}
			}
		}

		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = isValid(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
