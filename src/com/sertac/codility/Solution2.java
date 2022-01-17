package com.sertac.codility;

import java.util.HashSet;

// you can also use imports, for example:

// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution2 {
	public static int solution(int[] A) {

		// List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		HashSet<Integer> set = new HashSet<>();
		for (int i : A) {
			set.add(i);
		}

		for (int i = 1; i <= 1000000; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		/*
		 * Collections.sort(list);
		 * 
		 * int checker = 1;
		 * 
		 * for (Integer integer : list) { if (integer > 0) {
		 * 
		 * if (checker <= integer) { checker++; }
		 * 
		 * if(true){ return checker; } } }
		 */

		return 0;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 4, 1, 2 };
		System.out.println(solution(A));
	}
}
