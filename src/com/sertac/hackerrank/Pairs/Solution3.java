package com.sertac.hackerrank.Pairs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Solution3 {

	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		int result = 0;
		for (int i = 0; i < arr.length; i++) {

			int required = arr[i] + k;
			int required2 = arr[i] - k;

			if (numbers.contains(required)) {
				result++;
			}

			if (numbers.contains(required2)) {
				result++;
			}
			numbers.add(arr[i]);
		}

		System.out.println(result);
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader scanner = new BufferedReader(new FileReader(
				new File("C:\\dev\\workspace\\HackerRank\\src\\com\\sertac\\hackerrank\\Pairs\\testcase14.txt")));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.readLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.readLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = pairs(k, arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
