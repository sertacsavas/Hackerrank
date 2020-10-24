package com.sertac.hackerrank.FraudulentActivityNotifications;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int getMedian(int[] arr, int value) {
		int counting = 0;
		for (int i = 0; i < arr.length; i++) {
			counting += arr[i];
			if (counting >= value) {
				return i;
			}
		}

		return -1;
	}

	static int activityNotifications(int[] expenditure, int d) {

		int median = (int) Math.ceil(d / 2.0);
		boolean isOdd = d % 2 == 1;
		int notifications = 0;

		int[] countingSort = new int[201];

		for (int i = 0; i < expenditure.length; i++) {

			if (i + 1 > d) {
				// Collections.sort(list);
				double medianValue = isOdd ? getMedian(countingSort, median)
						: ((double) (getMedian(countingSort, median) + getMedian(countingSort, median + 1)) / 2);

				if (medianValue * 2 <= expenditure[i]) {
					notifications++;
				}

			}

			countingSort[expenditure[i]]++;

			if (i >= d) {
				countingSort[expenditure[i - d]]--;
			}
		}

		return notifications;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
