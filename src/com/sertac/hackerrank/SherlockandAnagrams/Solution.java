package com.sertac.hackerrank.SherlockandAnagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	// Complete the sherlockAndAnagrams function below.

	static int sherlockAndAnagrams(String s) {
		int result = 0;
		char[] c = s.toCharArray();
		HashMap<String, Integer> subStrings = new HashMap<String, Integer>();

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length - i; j++) {
				String substring = s.substring(j, j + i + 1);
				char[] chars = substring.toCharArray();
				Arrays.sort(chars);
				String sortedSubstring = String.valueOf(chars);
				Integer substringValue = subStrings.get(sortedSubstring);
				if (substringValue == null) {
					substringValue = 0;
				}

				subStrings.put(sortedSubstring, substringValue + 1);
			}
		}

		Iterator<Entry<String, Integer>> it = subStrings.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<String, Integer> pair = it.next();

			if (pair.getValue() > 1) {
				result += (pair.getValue() * (pair.getValue() - 1)) / 2;
			}

			it.remove();
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		// long time1 = System.currentTimeMillis();
		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
		// long time2 = System.currentTimeMillis();

		// System.out.println(time2 - time1);
		scanner.close();
	}
}
