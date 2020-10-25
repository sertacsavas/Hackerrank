package com.sertac.hackerrank.SpecialStringAgain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {

		long res = 0;

		for (int i = 0; i < n; i++) {
			res++;
			for (int j = i + 1; j < n; j++) {

				if (s.charAt(i) == s.charAt(j)) {
					// System.out.println(s.substring(i, j));
					res++;
				} else {
					boolean isSpecial = true;
					for (int k = j + 1; k < 2 * j - i + 1; k++) {
						if (k > s.length() - 1 || s.charAt(i) != s.charAt(k)) {
							isSpecial = false;
							break;
						}
					}

					if (isSpecial) {
						// System.out.println(s.substring(i, 2 * j - i + 1));
						res++;
					}

					break;
				}
			}
		}
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		long result = substrCount(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
