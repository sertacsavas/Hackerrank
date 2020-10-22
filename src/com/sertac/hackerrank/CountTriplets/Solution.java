package com.sertac.hackerrank.CountTriplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		HashMap<Long, Long> afterMap = new HashMap<Long, Long>();
		HashMap<Long, Long> beforeMap = new HashMap<Long, Long>();

		long result = 0;
		for (int i = 0; i < arr.size(); i++) {
			Long count = afterMap.get(arr.get(i));
			afterMap.put(arr.get(i), count != null ? count + 1 : 1);
		}

		for (int i = 0; i < arr.size(); i++) {
			Long countAfter = afterMap.get(arr.get(i));
			afterMap.put(arr.get(i), countAfter - 1);

			if (arr.get(i) % r == 0) {
				long a = arr.get(i) / r;
				long b = arr.get(i) * r;
				Long countOFA = beforeMap.get(a);

				if (countOFA != null && countOFA > 0) {
					Long countOFB = afterMap.get(b);
					if (countOFB != null && countOFB > 0) {
						result += countOFA * countOFB;
					}
				}

			}

			Long countBefore = beforeMap.get(arr.get(i));
			beforeMap.put(arr.get(i), countBefore != null ? countBefore + 1 : 1);

		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Long> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr.add(arrItem);
		}

		long ans = countTriplets(arr, r);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
