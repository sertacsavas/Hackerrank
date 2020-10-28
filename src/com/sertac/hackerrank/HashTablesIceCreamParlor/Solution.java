package com.sertac.hackerrank.HashTablesIceCreamParlor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the whatFlavors function below.
	static void whatFlavors(int[] cost, int money) {

		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		HashMap<Integer, List<Integer>> index = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < cost.length; i++) {
			frequency.put(cost[i], frequency.getOrDefault(cost[i], 0) + 1);

			List<Integer> list = index.get(cost[i]);
			if (list != null) {
				list.add(i + 1);
			} else {
				list = new ArrayList<Integer>();
				list.add(i + 1);
				index.put(cost[i], list);
			}

		}

		for (int i = 0; i < cost.length; i++) {
			if (cost[i] < money) {
				int neededValue = money - cost[i];
				Integer valueFromFrequency = frequency.get(neededValue);
				if (valueFromFrequency != null) {
					if (neededValue != cost[i]) {
						System.out.println((i + 1) + " " + index.get(neededValue).get(0));
						return;
					} else {
						List<Integer> tempIndexes = index.get(neededValue);
						if (tempIndexes.size() > 1) {
							System.out.println(tempIndexes.get(0) + " " + tempIndexes.get(1));
							return;
						}
					}
				}
			}
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];

			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}

			whatFlavors(cost, money);
		}

		scanner.close();
	}
}
