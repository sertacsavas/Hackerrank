package com.sertac.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// you can also use imports, for example:

// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
// merge
// commit
class Solution {
	public static int solution(int[] A) {
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		Collections.sort(list);
		int checker = 1;
		for (Integer integer : list) {
			if (integer > 0) {
				if (checker < integer) {
					return checker;
				}
				if (checker <= integer) {
					checker++;
				}
			}
		}
		return checker;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 4, 1, 2 };
		System.out.println(solution(A));
	}
}
