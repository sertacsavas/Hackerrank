package com.sertac.hackerrank.HashTablesRansomNote;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < magazine.length; i++) {
			Integer count = map.get(magazine[i]);

			if (count != null) {
				map.put(magazine[i], count + 1);
			} else {
				map.put(magazine[i], 1);
			}
		}

		for (int i = 0; i < note.length; i++) {
			Integer count = map.get(note[i]);
			if (count == null || count == 0) {
				System.out.println("No");
				return;
			}
			map.put(note[i], count - 1);
		}

		System.out.println("Yes");

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
