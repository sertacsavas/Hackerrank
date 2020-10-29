package com.sertac.hackerrank.Pairs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Solution2 {

	// Complete the pairs function below.
	static int pairs(long k, int[] arr) {
		HashSet<Long> numbers = new HashSet<Long>();
		HashSet<String> results = new HashSet<String>();
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (numbers.contains(Math.abs((long) arr[i] - k))) {
				results.add(arr[i] + " " + Math.abs((long) arr[i] - k));
				results.add(Math.abs((long) arr[i] - k) + " " + arr[i]);
				result++;
			}

			if (numbers.contains(Math.abs(k + (long) arr[i]))) {
				results.add(arr[i] + " " + Math.abs((long) arr[i] + k));
				results.add(Math.abs((long) arr[i] + k) + " " + arr[i]);
				result++;
			}
			numbers.add((long) arr[i]);
		}

		HashSet<Long> numbers2 = new HashSet<Long>();
		HashSet<String> results2 = new HashSet<String>();
		int result2 = 0;
		for (int i = 0; i < arr.length; i++) {
			numbers2.add((long) arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (numbers.contains(k + arr[i])) {
				results2.add(arr[i] + " " + Math.abs((long) arr[i] + k));
				results2.add(Math.abs((long) arr[i] + k) + " " + arr[i]);
				result2++;
			}

		}
		results.removeAll(results2);
		System.out.println(result2);
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
