package com.sertac.hackerrank.JavaArraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			int d = in.nextInt();
			for (int j = 0; j < d; j++) {
				tempList.add(in.nextInt());
			}

			list.add(tempList);
		}

		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int y = in.nextInt();
			int x = in.nextInt();

			if (list.size() < y || list.get(y - 1).size() < x) {
				System.out.println("ERROR!");
			} else {
				System.out.println(list.get(y - 1).get(x - 1));
			}

		}

		in.close();

	}
}