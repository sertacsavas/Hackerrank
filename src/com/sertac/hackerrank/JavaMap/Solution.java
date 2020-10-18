package com.sertac.hackerrank.JavaMap;

import java.util.HashMap;
//Complete this code or write your own from scratch
import java.util.Scanner;

class Solution {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();

			map.put(name, phone);

			in.nextLine();
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			Integer result = map.get(s);
			if (result != null) {
				System.out.println(s + "=" + result);
			} else {
				System.out.println("Not found");
			}
		}
	}
}
