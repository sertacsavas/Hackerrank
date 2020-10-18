package com.sertac.hackerrank.JavaStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {

	private static boolean isBalanced(String s) {

		char[] A = s.toCharArray();
		Stack<String> stack = new Stack<String>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("{", "}");
		map.put("(", ")");
		map.put("[", "]");

		for (char c : A) {
			String temp = map.get(String.valueOf(c));
			if (temp != null) {
				stack.push(String.valueOf(c));
			} else {

				if (stack.size() > 0) {
					String poppedString = stack.pop();
					String poppedStringCloser = map.get(poppedString);
					if (poppedStringCloser == null || poppedStringCloser.compareTo(String.valueOf(c)) != 0) {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		return stack.size() == 0;
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			System.out.println(isBalanced(input));
		}

		sc.close();

	}
}
