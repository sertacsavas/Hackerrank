package com.sertac.hackerrank.TwoStrings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < c1.length; i++) {
			set.add(String.valueOf(c1[i]));
		}

		for (int i = 0; i < c2.length; i++) {
			if (set.contains(String.valueOf(c2[i]))) {
				return "YES";
			}
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
