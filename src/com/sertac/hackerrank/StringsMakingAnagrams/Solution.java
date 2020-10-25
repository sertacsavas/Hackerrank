package com.sertac.hackerrank.StringsMakingAnagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the makeAnagram function below.

	static int makeAnagram(String a, String b) {
		int deletions = 0;
		HashMap<String, Integer> aMap = new HashMap<String, Integer>();
		HashMap<String, Integer> bMap = new HashMap<String, Integer>();
		HashSet<String> set = new HashSet<String>();

		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		for (int i = 0; i < aArr.length; i++) {
			String s = String.valueOf(aArr[i]);
			Integer value = aMap.get(s);
			Integer newValue = value != null ? value + 1 : 1;
			aMap.put(s, newValue);
			set.add(s);
		}

		for (int i = 0; i < bArr.length; i++) {
			String s = String.valueOf(bArr[i]);
			Integer value = bMap.get(s);
			Integer newValue = value != null ? value + 1 : 1;
			bMap.put(s, newValue);
			set.add(s);
		}

		List<String> list = new ArrayList<String>(set);

		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			Integer aMapValue = aMap.get(s);
			if (aMapValue == null) {
				aMapValue = 0;
			}
			Integer bMapValue = bMap.get(s);
			if (bMapValue == null) {
				bMapValue = 0;
			}

			int comparison = aMapValue.compareTo(bMapValue);

			if (comparison > 0) {
				aMap.put(s, bMapValue);
				deletions += aMapValue - bMapValue;
			} else if (comparison < 0) {
				bMap.put(s, aMapValue);
				deletions += bMapValue - aMapValue;
			}

		}

		return deletions;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
