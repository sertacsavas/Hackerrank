package com.sertac.hackerrank.MergeSortCountingInversions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	private static class MergeSort {
		/*
		 * Our array has up to n = 100,000 elements. That means there may be O(n^2)
		 * swaps. n^2 is 10,000,000,000. A Java int has max value 2,147,483,647 so we
		 * use a long to avoid integer overflow
		 */
		private long swaps = 0;

		public long mergeSort(int[] array) {
			int[] helper = new int[array.length];
			mergeSort(array, helper, 0, array.length - 1);
			return swaps;
		}

		private void mergeSort(int[] array, int[] helper, int start, int end) {
			if (start < end) {
				int mid = (start + end) / 2;
				mergeSort(array, helper, start, mid);
				mergeSort(array, helper, mid + 1, end);
				merge(array, helper, start, mid, end);
			}
		}

		private void merge(int[] array, int[] helper, int start, int mid, int end) {
			/* Fill helper array with same elements as original array */
			for (int i = start; i <= end; i++) { // notice "i" goes from "start" to "end", not "0" to "array.length"
				helper[i] = array[i];
			}

			int curr = start;
			int left = start;
			int right = mid + 1;

			/*
			 * Loop through helper[] left and right halves and continuously copy smaller
			 * element to array[]
			 */
			while (left <= mid && right <= end) {
				if (helper[left] <= helper[right]) {
					array[curr++] = helper[left++];
				} else {
					/*
					 * Each time we choose element from right side, we count up how many elements it
					 * is less than from left side. This is equivalent to counting swaps.
					 */
					swaps += mid + 1 - left;
					array[curr++] = helper[right++];
				}
			}

			/*
			 * Copy remaining elements of left half. Right half elements are already in
			 * proper place
			 */
			while (left <= mid) {
				array[curr++] = helper[left++];
			}
		}
	}

	static long countInversions(int[] arr) {
		MergeSort m = new MergeSort();

		m.mergeSort(arr);
		return m.swaps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			long result = countInversions(arr);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
