package com.sertac.hackerrank.JavaList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();

		List<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < q; ++i) {
			int j = scan.nextInt();
			list.add(j);
		}

		int x = scan.nextInt();

		for (int i = 0; i < x; i++) {
			String s = scan.next();

			if ("Insert".equals(s)) {
				int index = scan.nextInt();
				int value = scan.nextInt();

				list.add(index, value);

			} else if ("Delete".equals(s)) {
				int index = scan.nextInt();
				list.remove(index);
			}

		}

		for (Integer integer : list) {
			System.out.print(integer + " ");
		}

		scan.close();
	}
}