package com.sertac.hackerrank.HashTablesIceCreamParlor;

import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {

	// Complete the whatFlavors function below.
	static void whatFlavors(int[] cost, int money) {
		HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] < money) {
				Integer neededValueIndex = index.get(money - cost[i]);
				if (neededValueIndex != null) {
					System.out.println(neededValueIndex + " " + (i + 1));
					return;
				}
			}

			index.put(cost[i], i + 1);
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
