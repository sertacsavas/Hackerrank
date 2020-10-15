package com.sertac.hackerrank.JavaDequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		// List<Long> uniqueCountList = new ArrayList<Long>();
		int n = in.nextInt();
		int m = in.nextInt();
		int maxCount = 0;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.addLast(num);
			set.add(num);
			if (deque.size() > m) {
				deque.removeFirst();
			}

			if (deque.size() == m) {
				if (set.size() > maxCount) {
					maxCount = set.size();
				}
				int first = deque.remove();

				if (!deque.contains(first))
					set.remove(first);

				/*
				 * Long uniqueCount = deque.stream().distinct().count();
				 * //uniqueCountList.add(uniqueCount); if (maxCount.compareTo(uniqueCount) < 0)
				 * { maxCount = uniqueCount; }
				 */
			}

		}

		System.out.println(maxCount);

		// System.out.println(uniqueCountList.stream().max(Long::compare).get());
	}
}
