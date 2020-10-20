package com.sertac.hackerrank.RepeatedString;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {

		char[] array = s.toCharArray();

		long numberOfAsInTheLastOccurance = 0;
		long numberOfAs = 0;

		for (int i = 0; i < (n > array.length ? array.length : n); i++) {
			if (array[i] == 'a') {
				if (i < n % array.length) {
					numberOfAsInTheLastOccurance++;
				}
				numberOfAs++;
			}
		}
		if (n < array.length) {
			return numberOfAs;
		} else {
			return (numberOfAs * (n / array.length)) + numberOfAsInTheLastOccurance;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		System.out.println(result);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
